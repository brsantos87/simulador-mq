package br.org.caixa.model.sibar.multicanal.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SERVICO_ENTRADA")
@XmlAccessorType(XmlAccessType.FIELD)
public class MulticanalServicoEntrada {

	@XmlElement(name = "ORQUESTRACAO")
	private Orquestracao orquestracao;

	public Orquestracao getOrquestracao() {
		return orquestracao;
	}

	public void setOrquestracao(Orquestracao orquestracao) {
		this.orquestracao = orquestracao;
	}

}
