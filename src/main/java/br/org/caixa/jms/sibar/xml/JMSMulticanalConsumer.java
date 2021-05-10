package br.org.caixa.jms.sibar.xml;

import org.apache.log4j.Logger;

import br.org.caixa.jms.ConstantesJMS;
import br.org.caixa.jms.JMSConsumer;
import br.org.caixa.model.simulador.FilaSimulador;

public class JMSMulticanalConsumer extends JMSConsumer {
	
	private final Logger logger = Logger.getLogger(JMSMulticanalConsumer.class);

	@Override
	protected String getQueueConsumer() {
		return ConstantesJMS.SIBAR_REQ_MULTICANAL;
	}

	@Override
	public FilaSimulador obterMensagemEntrada(String msg) {
		return null;
	}

	
}
