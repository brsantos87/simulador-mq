package br.org.caixa.persistencia.entidade;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ServicoSibarKey{
   
    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String operacao;

    @Column(length = 10, nullable = false)
    private String versao;
    
	public ServicoSibarKey(String nome, String operacao, String versao) {
		this.nome = nome;
		this.operacao = operacao;
		this.versao = versao;
	}
	
	public ServicoSibarKey() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
    

}