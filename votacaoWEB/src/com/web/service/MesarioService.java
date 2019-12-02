package com.web.service;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.bean.Mesario;
import com.web.factory.ConnectionFactory;

public class MesarioService {

	public static void inserir(Mesario mesario) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO Mesario (TituloMesario,NomeMesario,zonaEleitoral,senha) VALUES (?,?,?,?)";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, mesario.getTitulo_mesario());
			ps.setString(2, mesario.getNome_mesario());
			ps.setString(3, mesario.getZona_eleitoral());
			ps.setString(4, mesario.getSenha());
			
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
	
	public static List<Mesario> consultar(String Titulo_mesario, String Nome_mesario, String Zona_eleitoral, String Senha) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Mesario> listaMesario = new ArrayList<Mesario>();
		
		String sql = "SELECT TituloMesario,NomeMesario,zonaEleitoral,senha FROM Mesario where TituloMesario=? and NomeMesario=? and zonaEleitoral=? senha=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, Titulo_mesario);
			ps.setString(2, Nome_mesario);
			ps.setString(3, Zona_eleitoral);
			ps.setString(4, Senha);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Mesario mesario = new Mesario();
				mesario.setTitulo_mesario(rs.getString("TituloMesario"));
				mesario.setNome_mesario(rs.getString("NomeMesario"));
				mesario.setZona_eleitoral(rs.getString("zonaEleitoral"));
				mesario.setSenha(rs.getString("senha"));
				listaMesario.add(mesario);
			}
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return listaMesario;
	}
	
	public static boolean autenticar(String Titulo_mesario, String Nome_mesario, String Zona_eleitoral, String Senha) throws SQLException {
		
		List<Mesario> listaMesario = consultar(Titulo_mesario, Nome_mesario, Zona_eleitoral, Senha);;
		
		if(!listaMesario.isEmpty()){
			return true;
		} 
		
		else{
			return false;
		}
	}
}
