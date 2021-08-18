package br.org.caixa.service;

public class RespostaMensagemSimulador {

	private String mensagem;

	private String filaResposta;
	
	public RespostaMensagemSimulador(String mensagem, String filaResposta) {
		super();
		this.mensagem = mensagem;
		this.filaResposta = filaResposta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getFilaResposta() {
		return filaResposta;
	}

	public void setFilaResposta(String filaResposta) {
		this.filaResposta = filaResposta;
	}

}
