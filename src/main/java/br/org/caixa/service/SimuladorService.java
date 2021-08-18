package br.org.caixa.service;

import br.org.caixa.model.simulador.FilaSimulador;

public interface SimuladorService {
	
	RespostaMensagemSimulador obterMensagem(FilaSimulador filaSimulador);

}
