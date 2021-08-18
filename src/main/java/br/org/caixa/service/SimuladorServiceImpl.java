package br.org.caixa.service;

import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.org.caixa.model.simulador.FilaSimulador;
import br.org.caixa.persistencia.entidade.MensagemFila;
import br.org.caixa.persistencia.entidade.MensagemServico;
import br.org.caixa.persistencia.entidade.ServicoSibarKey;
import br.org.caixa.persistencia.repository.MensagemFilaRepository;
import br.org.caixa.persistencia.repository.MensagemServicoRepository;

@ApplicationScoped
public class SimuladorServiceImpl implements SimuladorService {
	
	@Inject
	MensagemFilaRepository mensagemFilaRepository;
	
	@Inject
	MensagemServicoRepository mensagemServicoRepository;
	
	@Override
	@Transactional
	public RespostaMensagemSimulador obterMensagem(FilaSimulador filaSimulador) {
		
		var mensagemFila = mensagemFilaRepository.findAtivoByNomeFila(filaSimulador.getFila());
		
		var listaServicoKey = filaSimulador.getListaIdServico().stream().map(x -> 
				new ServicoSibarKey(x.getServico(), x.getOperacao(), x.getVersao())
			).collect(Collectors.toList());
		
		var servicos = mensagemServicoRepository.findAtivoByServico(listaServicoKey);
		
		var msgServicos  = servicos.stream().map(MensagemServico::getMensagem).collect(Collectors.joining());
		
		var mensagem = mensagemFila.getMensagem().replace("${tarefas}", msgServicos);
		
		return new RespostaMensagemSimulador(mensagem,mensagemFila.getFila().getNomeResposta());
	}

}
