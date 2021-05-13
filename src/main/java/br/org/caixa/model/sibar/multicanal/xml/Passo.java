package br.org.caixa.model.sibar.multicanal.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PASSO")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passo {
	
	@XmlElement(name = "SERVICO")
	private String servico;

	@XmlElement(name = "OPERACAO")
	private String operacao;

	@XmlElement(name = "VERSAO")
	private String versao;

	@XmlElement(name = "RECURSOS")
	private Recursos recursos;

	public String getServico() {
		return servico;
	}

	public String getOperacao() {
		return operacao;
	}

	public String getVersao() {
		return versao;
	}

	public Recursos getRecursos() {
		return recursos;
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

	public void setRecursos(Recursos recursos) {
		this.recursos = recursos;
	}

}
