package br.org.caixa.persistencia.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "servico_mensagem",
		uniqueConstraints =  {@UniqueConstraint(columnNames = {"id_servico_sibar", "descricao"})}
)
public class ServicoMensagem{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250, nullable = false)
    private String descricao;

    @Column(length = 4000, nullable = false)
    private String mensagem;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name="id_servico_sibar", nullable=false, insertable=false)
    private ServicoSibar servicoSibar;

	public Long getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}