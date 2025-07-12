package br.com.blopaquint.precifipe.main;

import br.com.blopaquint.precifipe.model.Dados;
import br.com.blopaquint.precifipe.model.Modelos;
import br.com.blopaquint.precifipe.model.Veiculo;
import br.com.blopaquint.precifipe.service.ConsumoApi;
import br.com.blopaquint.precifipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        var menu = """
                \n*************** PRECIFIPE ***************\n
                ##### OPÇÕES #####
                [1] - Carro
                [2] - Moto
                [3] - Caminhão
                ##################\n                
                Digite o número da opção desejada para consultar:
                """;

        System.out.println(menu);
        var opcao = leitura.nextInt();
        leitura.nextLine();

        System.out.println();

        String endereco;

        while (opcao < 1 || opcao > 3) {
            System.out.println("\nOpção inválida, digite uma opção entre 1 e 3: \n");
            opcao = leitura.nextInt();
            leitura.nextLine();
        }

        if (opcao == 1) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao == 2) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::nome, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);

        System.out.println("\nDigite o código da marca para consulta: \n");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("\nModelos da marca escolhida: \n");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::nome, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);


        System.out.println("\nDigite o nome do modelo para consulta: \n");
        var nomeModelo = leitura.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeModelo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite o código do modelo para consulta\n");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size() ; i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }
        System.out.println("\nTodos os veículos por ano: \n");
        veiculos.stream()
                .sorted(Comparator.comparing(Veiculo::ano))
                .forEach(System.out::println);

    }

}
