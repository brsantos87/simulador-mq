package br.org.caixa.jms.sibar;

import br.org.caixa.model.simulador.FilaSimulador;

public interface ConverterMensagem {
	
	FilaSimulador obterMensagemEntrada(String msg);

}
