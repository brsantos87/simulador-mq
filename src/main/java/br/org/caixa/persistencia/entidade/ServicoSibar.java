package br.org.caixa.persistencia.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "servico_sibar",
		uniqueConstraints =  {@UniqueConstraint(columnNames = {"nome", "operacao", "versao"})}
)
public class ServicoSibar{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(name = "operacao", length = 150, nullable = false)
    private String operacao;

    @Column(name = "versao", length = 10, nullable = false)
    private String versao;
    
    @OneToMany(mappedBy = "servicoSibar")
    private List<ServicoMensagem> servicoMensagens;

    public Long getId() {
        return this.id;
    }

    public String getNomeServico() {
        return this.nome;
    }

    public void setNomeServico(String nomeServico) {
        this.nome = nomeServico;
    }

    public String getOperacao() {
        return this.operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

}