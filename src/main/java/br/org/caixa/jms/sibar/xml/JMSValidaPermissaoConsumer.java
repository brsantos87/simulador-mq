package br.org.caixa.jms.sibar.xml;

import br.org.caixa.jms.ConstantesJMS;
import br.org.caixa.jms.JMSConsumer;
import br.org.caixa.model.simulador.FilaSimulador;

public class JMSValidaPermissaoConsumer extends JMSConsumer {

	@Override
	protected String getQueueConsumer() {
		return ConstantesJMS.SIBAR_REQ_VALIDA_PERMISSAO;
	}

	@Override
	public FilaSimulador obterMensagemEntrada(String msg) {
		return null;
	}

}
