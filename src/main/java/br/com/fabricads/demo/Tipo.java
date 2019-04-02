package br.com.fabricads.demo;

@lombok.AllArgsConstructor
public enum Tipo {

	PROVENTO("P"),
	DESCONTO("D");

	private String valor;
}