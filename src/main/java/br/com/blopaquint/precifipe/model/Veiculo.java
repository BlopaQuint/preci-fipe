package br.com.blopaquint.precifipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(

        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer ano,
        @JsonAlias("Combustivel") String tipoCombustivel

) {

    @Override
    public String toString() {
        return "Ano: " + ano +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nTipo de Combustível: " + tipoCombustivel +
                "\nValor: " + valor + "\n";
    }

}
