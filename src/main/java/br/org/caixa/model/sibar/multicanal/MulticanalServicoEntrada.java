package br.org.caixa.model.sibar.multicanal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SERVICO_ENTRADA")
public class MulticanalServicoEntrada {

	private Orquestracao orquestracao;

	public Orquestracao getOrquestracao() {
		return orquestracao;
	}

	public void setOrquestracao(Orquestracao orquestracao) {
		this.orquestracao = orquestracao;
	}

}
