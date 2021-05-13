package br.org.caixa.api.model;

public class MessageSend {

	private String queue;
	
	private String mensagem;

	public String getQueue() {
		return queue;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public void setMensagem(String messagem) {
		this.mensagem = messagem;
	}

}
