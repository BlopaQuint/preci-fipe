package br.com.blopaquint.precifipe.model;

public record Dados(String nome, String codigo) {

    @Override
    public String toString() {
        return nome + " [ Código: " + codigo + " ]";
    }

}
