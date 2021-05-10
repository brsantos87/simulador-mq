package br.org.caixa.model.sibar.multicanal.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ORQUESTRACAO")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orquestracao {
	
	@XmlElement(name = "PASSOS")
	private Passos passos;

	public Passos getPassos() {
		return passos;
	}

	public void setPassos(Passos passos) {
		this.passos = passos;
	}

}
