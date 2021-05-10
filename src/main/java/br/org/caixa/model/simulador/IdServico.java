package br.org.caixa.model.simulador;

public class IdServico {
	
	public IdServico(String servico, String operacao, double versao) {
		super();
		this.servico = servico;
		this.operacao = operacao;
		this.versao = versao;
	}

	private String servico;

	private String operacao;

	private double versao;

	public String getServico() {
		return servico;
	}

	public String getOperacao() {
		return operacao;
	}

	public double getVersao() {
		return versao;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public void setVersao(double versao) {
		this.versao = versao;
	}
	
	

}
