package com.web.service;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.bean.Candidato;
import com.web.factory.ConnectionFactory;

public class CandidatoService {

	public static void inserir(Candidato candidato) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO Candidato (NumeroCandidato,NomeCandidato,Votos) VALUES (?,?,?)";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, candidato.getNum_candidato());
			ps.setString(2, candidato.getNome_candidato());
			ps.setInt(3, candidato.getVotos());
			
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
	
	public static void inserirV(Candidato candidato) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO Candidato (Votos) VALUES (?)";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, candidato.getVotos());
			
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
	
	public static void updateCandVot(Candidato candidato) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		
		String sql = "UPDATE Candidato SET Votos = ? WHERE NumeroCandidato = ?";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, candidato.getVotos());
			ps.setString(2, candidato.getNum_candidato());
			
			ps.executeUpdate();
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
	
	public static List<Candidato> consultar(String Num_candidato, String Nome_candidato, int Votos) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Candidato> listaCandidato = new ArrayList<Candidato>();
		
		String sql = "SELECT NumeroCandidato,NomeCandidato,Votos FROM Candidato where NumeroCandidato=? and NomeCandidato=? and Votos=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, Num_candidato);
			ps.setString(2, Nome_candidato);
			ps.setInt(3, Votos);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Candidato candidato = new Candidato();
				candidato.setNum_candidato(rs.getString("NumeroCandidato"));
				candidato.setNome_candidato(rs.getString("NomeCandidato"));
				candidato.setVotos(rs.getInt("Votos"));
				listaCandidato.add(candidato);
			}
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return listaCandidato;
	}
	
	public static boolean autenticar(String Num_candidato, String Nome_candidato, int Votos) throws SQLException {
		
		List<Candidato> listaCandidato = consultar(Num_candidato, Nome_candidato, Votos);;
		
		if(!listaCandidato.isEmpty()){
			return true;
		} 
		
		else{
			return false;
		}
	}
	
	public static List<Candidato> consultar(String Num_candidato) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Candidato> listaCandidato = new ArrayList<Candidato>();
		
		String sql = "SELECT NumeroCandidato,NomeCandidato,Votos FROM Candidato where NumeroCandidato=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, Num_candidato);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Candidato candidato = new Candidato();
				candidato.setNum_candidato(rs.getString("NumeroCandidato"));
				candidato.setNome_candidato(rs.getString("NomeCandidato"));
				candidato.setVotos(rs.getInt("Votos"));
				listaCandidato.add(candidato);
			}
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return listaCandidato;
	}
	public static Candidato consultarUnico(String Num_candidato) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Candidato> listaCandidato = new ArrayList<Candidato>();
		Candidato cand = new Candidato();
		
		String sql = "SELECT NumeroCandidato,NomeCandidato,Votos FROM Candidato where NumeroCandidato=?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, Num_candidato);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				
				Candidato candidato = new Candidato();
				candidato.setNum_candidato(rs.getString("NumeroCandidato"));
				candidato.setNome_candidato(rs.getString("NomeCandidato"));
				candidato.setVotos(rs.getInt("Votos"));
				listaCandidato.add(candidato);
			}
			cand = listaCandidato.get(listaCandidato.size()-1);
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
			cand.setNome_candidato("FailConnection");
			System.out.println(e.toString());
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return cand;
	}
	
	public static boolean autenticar(String Num_candidato) throws SQLException {
		
		List<Candidato> listaCandidato = consultar(Num_candidato);;
		
		if(!listaCandidato.isEmpty()){
			return true;
		} 
		
		else{
			return false;
		}
	}
}
