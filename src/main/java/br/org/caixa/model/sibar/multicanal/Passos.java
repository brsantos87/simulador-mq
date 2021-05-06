package br.org.caixa.model.sibar.multicanal;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PASSOS")
public class Passos {

	private List<Passo> passo;

	public List<Passo> getPasso() {
		return passo;
	}

	public void setPasso(List<Passo> passo) {
		this.passo = passo;
	}

}
