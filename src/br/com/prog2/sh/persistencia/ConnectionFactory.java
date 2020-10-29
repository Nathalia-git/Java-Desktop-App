package br.com.prog2.sh.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		String driver = "mysql-connector-java_8.0.21-1-ubuntu18.04_all.deb";
		String user = "root";
		String senha = "Senha_Nova12";
		String url = "jdbc:mysql://localhost:3306/sistema_hospedagem";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, senha);
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

}
