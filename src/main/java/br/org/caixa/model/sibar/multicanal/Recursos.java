package br.org.caixa.model.sibar.multicanal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RECURSOS")
public class Recursos {

	@XmlElement(name = "FILA_RESPOSTA")
	private String filaResposta;

	public String getFilaResposta() {
		return filaResposta;
	}

	public void setFilaResposta(String filaResposta) {
		this.filaResposta = filaResposta;
	}

}
