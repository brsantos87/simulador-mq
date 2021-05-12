package br.org.caixa.persistencia.repository;

import javax.enterprise.context.ApplicationScoped;

import br.org.caixa.persistencia.entidade.MensagemFila;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class MensagemFilaRepository implements PanacheRepository<MensagemFila> {

	public MensagemFila findAtivoByNomeFila(String nome) {
        return find("SELECT m FROM MensagemFila m join fetch m.fila f where f.nome = :nome and m.ativo = true",
                Parameters.with("nome", nome)).firstResult();
    }
}
