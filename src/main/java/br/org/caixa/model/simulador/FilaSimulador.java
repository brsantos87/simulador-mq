package br.org.caixa.model.simulador;

import java.util.ArrayList;
import java.util.List;

public class FilaSimulador {

	private String fila;

	private List<IdServico> listaIdServico;
	
	public FilaSimulador(String fila) {
		this.fila = fila;
		this.listaIdServico = new ArrayList<IdServico>();
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public List<IdServico> getListaIdServico() {
		return listaIdServico;
	}

	public void setListaIdServico(List<IdServico> listaIdServico) {
		this.listaIdServico = listaIdServico;
	}

}
