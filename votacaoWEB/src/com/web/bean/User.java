package com.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.web.service.CandidatoService;
import com.web.service.EleitorService;
import com.web.service.MesarioService;

public class User {
	private String titulo;
	private String nome;
	private String senha;
	private Eleitor Elei = new Eleitor();
	private Mesario mes = new Mesario();
	private Candidato Cand = new Candidato();
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
				Elei = (Eleitor) eleitorList.get(eleitorList.size()-1);
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
				Elei = EleitorService.consultUnico(titulo);
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
	public Eleitor getEleitor(){
		return Elei;
	}
	public List<Eleitor> getConsulta(String titu) {
		try {
			return EleitorService.consultar(titu);
		}catch (Exception e){
			eleitorList.add(Elei);
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
	//CANDIDATO
	public boolean autenticouCandidatoRel (String id) {
		try {
			if(CandidatoService.autenticar(id)) {
				Cand = CandidatoService.consultarUnico(id);
				System.out.println("Consultou!"+ Cand.getNome_candidato());
				return true;
			}else
				System.out.println("Não existe");
				return false;
		}catch (Exception e) {
			return false;
		}
	}
	public Candidato getCandidato(){
		return Cand;
	}
}
