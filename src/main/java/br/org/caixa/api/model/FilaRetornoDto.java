package br.org.caixa.api.model;

import java.util.List;


public class FilaRetornoDto {
	 
	private String nome;
	
	private Long id;

	private List<MensagemFilaDto> mensagensFila;

	public FilaRetornoDto(Long id, String nome, List<MensagemFilaDto> listaMensagems) {
		this.id = id;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
