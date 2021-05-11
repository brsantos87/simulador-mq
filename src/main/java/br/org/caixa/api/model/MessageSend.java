package br.org.caixa.api.model;

public class MessageSend {

	private String queue;
	
	private String messagem;

	public String getQueue() {
		return queue;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}

}
