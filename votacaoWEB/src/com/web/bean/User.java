package com.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.web.service.EleitorService;
import com.web.service.MesarioService;

public class User {
	private String titulo;
	private String nome;
	private String senha;
	Eleitor man = new Eleitor();
	Mesario mes = new Mesario();
	List<Eleitor> eleitorList = new ArrayList();
	List<Mesario> mesarioList = new ArrayList();
	
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
	//ELEITOR
	public boolean autenticouEleitor () {
		try {
			if(EleitorService.autenticar(getTitulo())) {
				eleitorList = EleitorService.consultar(getTitulo());
				man = eleitorList.get(eleitorList.size()-1);
				return true;
			}else
				return false;
		}catch (Exception e) {
			return false;
		}
	}
	public boolean autenticouEleitorLiberar (String titulo) {
		try {
			if(EleitorService.autenticarLiberar(titulo)) {
				eleitorList = EleitorService.consultar(getTitulo());
				man = eleitorList.get(eleitorList.size()-1);
				return true;
			}else
				return false;
		}catch (Exception e) {
			return false;
		}
	}
	public void salvarEleitor(Eleitor el) {
		try{
			EleitorService.inserir(el);
		}catch (Exception e) {
			
		}
	}
	public Eleitor getEleitor(){
		return man;
	}
	//MESARIO
	public boolean autenticouMesario (String titulo, String senha) {
		try {
			if(MesarioService.autenticar(titulo, senha)) {
				mesarioList = MesarioService.consultar(titulo, senha);
				mes = mesarioList.get(mesarioList.size()-1);
				return true;
			}else
				return false;
		}catch (Exception e) {
			System.out.println("Erro de SQL"+ e.toString());
			return false;
		}
	}
	public Mesario getMesario(){
		return mes;
	}
}
