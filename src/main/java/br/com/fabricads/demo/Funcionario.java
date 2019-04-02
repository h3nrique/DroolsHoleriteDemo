package br.com.fabricads.demo;

@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public @lombok.Data class Funcionario implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("Matricula")
	private long matricula;

	@org.kie.api.definition.type.Label("Nome")
	private java.lang.String nome;

	@lombok.Singular("verba")
	@org.kie.api.definition.type.Label("Verbas")
	private java.util.List<Verba> verbas;

	@org.kie.api.definition.type.Label(value = "Depententes")
	private java.lang.Integer dependentes;

}