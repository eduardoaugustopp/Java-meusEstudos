package br.com.ZZCjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoFactory {
	public static Connection getConexao() {
		String url = "jdbc:mysql://localhost:3306/agencia";
		String user = "root";
		String password = "admin123";

		try {

			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}

	public void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void close(Connection connection, Statement stmt) {
		close(connection);
		try {
			if (stmt != null) {
				stmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
