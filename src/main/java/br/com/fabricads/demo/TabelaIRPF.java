package br.com.fabricads.demo;

@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public @lombok.Data class TabelaIRPF implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("Deducao Legal")
	private java.lang.Double deducaoLegal;

	@lombok.Singular("deducao")
	@org.kie.api.definition.type.Label(value = "Deducoes")
	private java.util.List<BaseIRPF> deducoes;

}