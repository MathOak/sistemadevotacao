package com.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/* Constantes com os par�metros da conex�o */
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/urna_bd?useTimezone=true&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	public static java.sql.Connection getConnection() {

		Connection conexao = null;
		try {
			/* Obt�m o driver de conex�o com o banco de dados */
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			/* Tenta se conectar */
			conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			/* Configura commit como N�O Autom�tico */
			conexao.setAutoCommit(false);

			/* Caso a conex�o ocorra com sucesso, a conex�o � retornada */
			return conexao;

		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel conectar ao banco de dados.");
			return null;
		}
	}
}