package br.org.caixa.model.sibar.multicanal.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RECURSOS")
@XmlAccessorType(XmlAccessType.FIELD)
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
