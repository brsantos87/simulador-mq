package br.org.caixa.model.sibar.multicanal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ORQUESTRACAO")
public class Orquestracao {
	
	private Passos passos;

	public Passos getPassos() {
		return passos;
	}

	public void setPassos(Passos passos) {
		this.passos = passos;
	}

}
