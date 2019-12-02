package com.web.bean;

public class Candidato {
	private String num_candidato;
	private String nome_candidato;
	private String votos;
	private String zona_eleitoral;
	
	public String getNum_candidato() {
		return num_candidato;
	}

	public void setNum_candidato(String num_candidato) {
		this.num_candidato = num_candidato;
	}
	
	public String getNome_candidato() {
		return nome_candidato;
	}

	public void setNome_candidato(String nome_candidato) {
		this.nome_candidato = nome_candidato;
	}
	
	public String getVotos() {
		return votos;
	}

	public void setVotos(String votos) {
		this.votos = votos;
	}
	
	public String getZona_eleitoral() {
		return zona_eleitoral;
	}

	public void setZona_eleitoral(String zona_eleitoral) {
		this.zona_eleitoral = zona_eleitoral;
	}
}
