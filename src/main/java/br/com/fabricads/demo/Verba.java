package br.com.fabricads.demo;

@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public @lombok.Data class Verba implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("Codigo")
	private long codigo;

	@org.kie.api.definition.type.Label(value = "Descricao")
	private java.lang.String descricao;

	@org.kie.api.definition.type.Label("Tipo")
	private Tipo tipo;

	@org.kie.api.definition.type.Label("Valor")
	private java.lang.Double valor;

	@org.kie.api.definition.type.Label("Parametro")
	private java.lang.Double parametro;

	@org.kie.api.definition.type.Label("Medida")
	private Medida medida;

	@org.kie.api.definition.type.Label("Incidencia IRRF")
	private boolean incideIRRF;

}