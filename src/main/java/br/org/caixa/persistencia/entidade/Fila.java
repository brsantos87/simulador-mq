package br.org.caixa.persistencia.entidade;

import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fila")
public class Fila{
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(length = 150, nullable = false, unique = true, name = "NOME_REQUISICAO")
    private String nomeRequisicao;
	
	@Column(length = 150, unique = true, name = "NOME_RESPOSTA")
    private String nomeResposta;
	
	@OneToMany(mappedBy = "fila")
	@JsonbTransient
    private List<MensagemFila> filaMensagens;

    public List<MensagemFila> getFilaMensagens() {
		return filaMensagens;
	}

	public void setFilaMensagens(List<MensagemFila> filaMensagens) {
		this.filaMensagens = filaMensagens;
	}

	public Long getId(){
        return id;
    }

	public String getNomeRequisicao() {
		return nomeRequisicao;
	}

	public void setNomeRequisicao(String nomeRequisicao) {
		this.nomeRequisicao = nomeRequisicao;
	}

	public String getNomeResposta() {
		return nomeResposta;
	}

	public void setNomeResposta(String nomeResposta) {
		this.nomeResposta = nomeResposta;
	}
	
	

	
}