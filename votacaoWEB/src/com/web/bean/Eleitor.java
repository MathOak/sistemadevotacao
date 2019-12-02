package com.web.bean;

public class Eleitor {
	
	private String titulo_eleitor;
	private String nome_eleitor;
	private String data;
	private String status;
	private String hora;
	private String zona_eleitoral;
	
	public String getTitulo_eleitor() {
		return titulo_eleitor;
	}

	public void setTitulo_eleitor(String titulo_eleitor) {
		this.titulo_eleitor = titulo_eleitor;
	}
	
	public String getNome_eleitor() {
		return nome_eleitor;
	}

	public void setNome_eleitor(String nome_eleitor) {
		this.nome_eleitor = nome_eleitor;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getZona_eleitoral() {
		return zona_eleitoral;
	}

	public void setZona_eleitoral(String zona_eleitoral) {
		this.zona_eleitoral = zona_eleitoral;
	}
}
