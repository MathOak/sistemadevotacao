package com.web.bean;

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

	public String getLogin() {
		return titulo;
	}

	public void setLogin(String login) {
		this.titulo = login;
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
}
