package br.org.caixa.model.sibar.multicanal.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PASSOS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passos {

	@XmlElement(name = "PASSO")
	private List<Passo> passo;

	public List<Passo> getPasso() {
		return passo;
	}

	public void setPasso(List<Passo> passo) {
		this.passo = passo;
	}

}
