package br.org.caixa.api.model;

public class MensagemFilaDto {
	
	private Long id;

    private String descricao;

    private String mensagem;

    private boolean ativo;

    private Long idFila;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getIdFila() {
		return idFila;
	}

	public void setIdFila(Long idFila) {
		this.idFila = idFila;
	}
}
