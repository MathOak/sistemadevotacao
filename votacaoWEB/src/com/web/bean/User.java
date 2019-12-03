package com.web.bean;

import com.web.service.EleitorService;

public class User {
	private String titulo;
	private String nome;
	private String senha;
	
	public User(String titulo){
		this.titulo = titulo;
	}
	public User(String titulo, String senha){
		this.titulo = titulo;
		this.senha = senha;
	}

	public User(){
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean autenticou () {
		try {
			if(EleitorService.autenticar(getTitulo())) {
				Eleitor man = new Eleitor();
				return true;
			}else
				return false;
		}catch (Exception e) {
			return false;
		}
	}
}
