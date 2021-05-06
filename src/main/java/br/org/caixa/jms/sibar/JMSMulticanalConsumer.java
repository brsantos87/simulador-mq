package br.org.caixa.jms.sibar;

import br.org.caixa.jms.ConstantesJMS;
import br.org.caixa.jms.JMSConsumer;

public class JMSMulticanalConsumer extends JMSConsumer{

	@Override
	protected String getQueueConsumer() {
		return ConstantesJMS.SIBAR_REQ_MULTICANAL;
	}

}
