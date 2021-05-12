package br.org.caixa.persistencia.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.org.caixa.persistencia.entidade.MensagemServico;
import br.org.caixa.persistencia.entidade.ServicoSibarKey;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class MensagemServicoRepository implements PanacheRepository<MensagemServico> {

	public List<MensagemServico> findAtivoByServico(List<ServicoSibarKey> lista) {
        return find("SELECT m FROM MensagemServico m join fetch m.servicoSibar s where s.key in (:lista) and m.ativo = true",
                Parameters.with("lista", lista)).list();
    }
	
}
