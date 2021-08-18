package br.org.caixa.api.model;

import java.util.List;


public class FilaRetornoDto {
	 
	private String nomeRequisicao;

	private String nomeResposta;
	
	private Long id;

	private List<MensagemFilaDto> mensagensFila;

	public FilaRetornoDto(Long id, String nomeReq, String nomeResp, List<MensagemFilaDto> listaMensagems) {
		this.id = id;
		this.nomeRequisicao = nomeReq;
		this.nomeResposta = nomeResp;
		this.mensagensFila = listaMensagems;
	}

	public List<MensagemFilaDto> getMensagensFila() {
		return mensagensFila;
	}

	public void setMensagensFila(List<MensagemFilaDto> mensagensFila) {
		this.mensagensFila = mensagensFila;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
