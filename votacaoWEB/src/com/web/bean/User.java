package com.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.web.service.EleitorService;
import com.web.service.MesarioService;

public class User {
	private String titulo;
	private String nome;
	private String senha;
	private Eleitor man = new Eleitor();
	private Mesario mes = new Mesario();
	private List<Eleitor> eleitorList = new ArrayList<Eleitor>();
	private List<Mesario> mesarioList = new ArrayList<Mesario>();
	
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
				man = (Eleitor) eleitorList.get(eleitorList.size()-1);
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
				setEleitor(eleitorList.get(eleitorList.size()-1));
				return true;
			}else
				return false;
		}catch (Exception e) {
			return false;
		}
	}
	public void salvarEleitor(Eleitor el) {
		try{
			EleitorService.update(el);
		}catch (Exception e) {
			
		}
	}
	public void setEleitor(Eleitor t1) {
		man = t1;
	}
	public Eleitor getEleitor(){
		return man;
	}
	public List<Eleitor> getConsulta(String titu) {
		try {
			return EleitorService.consultar(titu);
		}catch (Exception e){
			eleitorList.add(man);
			return eleitorList;
		}
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
			return false;
		}
	}
	public Mesario getMesario(){
		return mes;
	}
}
