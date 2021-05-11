package br.org.caixa.persistencia.repository;

import javax.enterprise.context.ApplicationScoped;

import br.org.caixa.persistencia.entidade.ServicoMensagem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ServicoMensagemRepository implements PanacheRepository<ServicoMensagem> {

}
