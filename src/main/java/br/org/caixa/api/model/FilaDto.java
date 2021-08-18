package br.org.caixa.api.model;

public class FilaDto {
	 
	private String nomeRequisicao;

	private String nomeResposta;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRequisicao() {
		return nomeRequisicao;
	}

	public void setNomeRequisicao(String nomeRequisicao) {
		this.nomeRequisicao = nomeRequisicao;
	}

	public String getNomeResposta() {
		return nomeResposta;
	}

	public void setNomeResposta(String nomeResposta) {
		this.nomeResposta = nomeResposta;
	}

		
}
