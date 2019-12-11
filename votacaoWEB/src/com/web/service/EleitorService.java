package com.web.service;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web.bean.Eleitor;
import com.web.factory.ConnectionFactory;

public class EleitorService {

	public static void inserir(Eleitor eleitor) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO Eleitor (TituloEleitor,NomeEleitor,data,status,hora) VALUES (?,?,?,?,?)";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, eleitor.getTitulo_eleitor());
			ps.setString(2, eleitor.getNome_eleitor());
			ps.setString(3, eleitor.getData());
			ps.setString(4, eleitor.getStatus());
			ps.setString(5, eleitor.getHora());
			
			ps.execute();
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			conexao.close();
		}
	}
	
	public static void update(Eleitor eleitor) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		
		String sql = "UPDATE eleitor set `status`= ?, `data`= ?, `hora` = ? where TituloEleitor = ?";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, eleitor.getStatus());
			ps.setString(2, eleitor.getData());
			ps.setString(3, eleitor.getHora());
			ps.setString(4, eleitor.getTitulo_eleitor());
			
			
			
			ps.execute();
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			conexao.close();
		}
	}
	public static List<Eleitor> consultar(String Titulo_eleitor) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Eleitor> listaEleitor = new ArrayList<Eleitor>();
		
		String sql = "SELECT TituloEleitor,NomeEleitor,data,status,hora FROM Eleitor where TituloEleitor=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, Titulo_eleitor);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Eleitor eleitor = new Eleitor();
				eleitor.setTitulo_eleitor(rs.getString("TituloEleitor"));
				eleitor.setNome_eleitor(rs.getString("NomeEleitor"));
				eleitor.setData(rs.getString("data"));
				eleitor.setStatus(rs.getString("status"));
				eleitor.setHora(rs.getString("hora"));
				listaEleitor.add(eleitor);
			}
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return listaEleitor;
	}
	public static List<Eleitor> consultar() throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Eleitor> listaEleitor = new ArrayList<Eleitor>();
		
		String sql = "SELECT TituloEleitor,NomeEleitor,data,status,hora FROM Eleitor";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Eleitor eleitor = new Eleitor();
				eleitor.setTitulo_eleitor(rs.getString("TituloEleitor"));
				eleitor.setNome_eleitor(rs.getString("NomeEleitor"));
				eleitor.setData(rs.getString("data"));
				eleitor.setStatus(rs.getString("status"));
				eleitor.setHora(rs.getString("hora"));
				listaEleitor.add(eleitor);
			}
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return listaEleitor;
	}

	
	public static boolean autenticar(String Titulo_eleitor) throws SQLException {
		
		List<Eleitor> listaEleitor = consultar(Titulo_eleitor);;
		Eleitor valida = new Eleitor();
		valida = listaEleitor.get(listaEleitor.size()-1);
		if(!listaEleitor.isEmpty() && valida.getStatus().contentEquals("aguardando")){
			return true;
		} 
		
		else{
			return false;
		}
	}
	public static boolean autenticarLiberar(String Titulo_eleitor) throws SQLException {
		
		List<Eleitor> listaEleitor = consultar(Titulo_eleitor);;
		Eleitor valida = new Eleitor();
		valida = listaEleitor.get(listaEleitor.size()-1);
		if(!listaEleitor.isEmpty() && valida.getStatus().equals("bloqueado")){
			return true;
		} 
		
		else{
			return false;
		}
	}
	public static boolean autenticarVotou(String Titulo_eleitor) throws SQLException {
		
		List<Eleitor> listaEleitor = consultar(Titulo_eleitor);;
		Eleitor valida = new Eleitor();
		valida = listaEleitor.get(listaEleitor.size()-1);
		if(!listaEleitor.isEmpty() && valida.getStatus().equals("aguardando")){
			return true;
		} 
		
		else{
			return false;
		}
	}
	public static boolean cabineLiberar() throws SQLException {
		
		List<Eleitor> listaEleitor = consultar();;
		Eleitor valida = new Eleitor();
		System.out.println(listaEleitor);
		if(!listaEleitor.isEmpty()) {
			for (int i = 0; i < listaEleitor.size(); i++) {
				valida = listaEleitor.get(i);
				if(!valida.getStatus().equals("fechado")) {
					valida.setStatus("bloqueado");
					update(valida);
					System.out.println(valida.getNome_eleitor());
				}
			}
			return true;
		}
		
		else{
			System.out.println("Erro na lista");
			return false;
		}
	}
	public static boolean cabineEncerrar() throws SQLException {
		
		List<Eleitor> listaEleitor = consultar();;
		Eleitor valida = new Eleitor();
		System.out.println(listaEleitor);
		if(!listaEleitor.isEmpty()) {
			for (int i = 0; i < listaEleitor.size(); i++) {
				valida = listaEleitor.get(i);
				if(!valida.getStatus().equals("votou")) {
					valida.setStatus("fechado");
					update(valida);
					System.out.println(valida.getNome_eleitor());
				}
			}
			return true;
		}
		
		else{
			System.out.println("Erro na lista");
			return false;
		}
	}
	public static boolean cabineLiberar(String Titulo_eleitor) throws SQLException {
		
		List<Eleitor> listaEleitor = consultar(Titulo_eleitor);;
		Eleitor valida = new Eleitor();
		valida = listaEleitor.get(listaEleitor.size()-1);
		if(!listaEleitor.isEmpty() && valida.getStatus().equals("aguardando")){
			return true;
		} 
		
		else{
			return false;
		}
	}
	public static Eleitor consultUnico(String Titulo_eleitor) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		Eleitor elei = new Eleitor();
		List<Eleitor> listaEleitor = new ArrayList<Eleitor>();
		
		String sql = "SELECT TituloEleitor,NomeEleitor,data,status,hora FROM Eleitor where TituloEleitor=?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, Titulo_eleitor);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Eleitor eleitor = new Eleitor();
				eleitor.setTitulo_eleitor(rs.getString("TituloEleitor"));
				eleitor.setNome_eleitor(rs.getString("NomeEleitor"));
				eleitor.setData(rs.getString("data"));
				eleitor.setStatus(rs.getString("status"));
				eleitor.setHora(rs.getString("hora"));
				listaEleitor.add(eleitor);
			}
			elei = listaEleitor.get(listaEleitor.size()-1);
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
			elei.setStatus("FailConnection");
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return elei;
	}
}
