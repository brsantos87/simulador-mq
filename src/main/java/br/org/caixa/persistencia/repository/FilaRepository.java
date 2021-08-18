package br.org.caixa.persistencia.repository;

import javax.enterprise.context.ApplicationScoped;

import br.org.caixa.persistencia.entidade.Fila;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FilaRepository implements PanacheRepository<Fila> {
	
}
