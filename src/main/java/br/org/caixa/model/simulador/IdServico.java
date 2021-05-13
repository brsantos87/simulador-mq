package br.org.caixa.model.simulador;

public class IdServico {
	
	public IdServico(String servico, String operacao, String versao) {
		super();
		this.servico = servico;
		this.operacao = operacao;
		this.versao = versao;
	}

	private String servico;

	private String operacao;

	private String versao;

	public String getServico() {
		return servico;
	}

	public String getOperacao() {
		return operacao;
	}

	public String getVersao() {
		return versao;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	

}
