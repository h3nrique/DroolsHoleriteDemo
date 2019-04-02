package br.com.fabricads.demo;

@lombok.AllArgsConstructor
public enum Medida {

    PORCENTAGEM("P"),
    UNIDADE("U");

    private String valor;
}