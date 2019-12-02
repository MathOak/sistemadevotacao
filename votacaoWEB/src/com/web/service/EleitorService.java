package com.web.service;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public static List<Eleitor> consultar(String Titulo_eleitor, String Nome_eleitor, String Data, String Status, String Hora) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Eleitor> listaEleitor = new ArrayList<Eleitor>();
		
		String sql = "SELECT TituloEleitor,NomeEleitor,data,status,hora FROM Eleitor where TituloEleitor=? and NomeEleitor=? and data=? status=? hora=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, Titulo_eleitor);
			ps.setString(2, Nome_eleitor);
			ps.setString(3, Data);
			ps.setString(4, Status);
			ps.setString(5,  Hora);
			
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
	
	public static boolean autenticar(String Titulo_eleitor, String Nome_eleitor, String Data, String Status, String Hora) throws SQLException {
		
		List<Eleitor> listaEleitor = consultar(Titulo_eleitor, Nome_eleitor, Data, Status, Hora);;
		
		if(!listaEleitor.isEmpty()){
			return true;
		} 
		
		else{
			return false;
		}
	}
}
