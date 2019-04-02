package br.com.fabricads.demo;

@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public @lombok.Data class BaseIRPF implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label(value = "Valor Inicial")
	private java.lang.Double valorInicial;

	@org.kie.api.definition.type.Label(value = "Valor Final")
	private java.lang.Double valorFinal;

	@org.kie.api.definition.type.Label(value = "Aliquota")
	private java.lang.Double aliquota;

	@org.kie.api.definition.type.Label(value = "Parcela")
	private java.lang.Double parcela;

}