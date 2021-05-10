package br.org.caixa.jms.sibar.xml;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import br.org.caixa.jms.ConstantesJMS;
import br.org.caixa.jms.sibar.JMSMensagemXMLCosumer;
import br.org.caixa.model.sibar.multicanal.xml.MulticanalServicoEntrada;
import br.org.caixa.model.sibar.multicanal.xml.Passo;
import br.org.caixa.model.simulador.FilaSimulador;
import br.org.caixa.model.simulador.IdServico;

public class JMSMulticanalConsumer extends JMSMensagemXMLCosumer {
	
	private final Logger logger = Logger.getLogger(JMSMulticanalConsumer.class);

	@Override
	protected String getQueueConsumer() {
		return ConstantesJMS.SIBAR_REQ_MULTICANAL;
	}

	
	@Override
	public FilaSimulador obterMensagemEntrada(String msg) {
		FilaSimulador filaSimulador = new FilaSimulador(getQueueConsumer());
		logger.info("Transformando mensagem entrada");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(MulticanalServicoEntrada.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			MulticanalServicoEntrada entrada = (MulticanalServicoEntrada) jaxbUnmarshaller
					.unmarshal(new StringReader(transform(msg)));
			for (Passo passo : entrada.getOrquestracao().getPassos().getPasso()) {
				filaSimulador.getListaIdServico()
						.add(new IdServico(passo.getServico(), passo.getOperacao(), passo.getVersao()));
			}
		} catch (JAXBException | NullPointerException e) {
			logger.error("Erro ao obterMensagemEntrada", e);
		}
		return filaSimulador;
		
	}
	
}
