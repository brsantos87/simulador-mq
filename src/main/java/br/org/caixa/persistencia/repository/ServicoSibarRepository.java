package br.org.caixa.persistencia.repository;

import javax.enterprise.context.ApplicationScoped;

import br.org.caixa.persistencia.entidade.ServicoSibar;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ServicoSibarRepository implements PanacheRepository<ServicoSibar> {

}
