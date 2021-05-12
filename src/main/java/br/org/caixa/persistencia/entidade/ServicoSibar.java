package br.org.caixa.persistencia.entidade;

import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Embedded;
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

    @Embedded
    private ServicoSibarKey key;
    
    @OneToMany(mappedBy = "servicoSibar")
    @JsonbTransient
    private List<MensagemServico> servicoMensagens;

    public Long getId() {
        return this.id;
    }

	public ServicoSibarKey getKey() {
		return key;
	}

	public void setKey(ServicoSibarKey key) {
		this.key = key;
	}

	public List<MensagemServico> getServicoMensagens() {
		return servicoMensagens;
	}

	public void setServicoMensagens(List<MensagemServico> servicoMensagens) {
		this.servicoMensagens = servicoMensagens;
	}

    

}