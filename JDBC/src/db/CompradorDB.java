package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ZZCjdbc.conn.ConexaoFactory;
import classes.Comprador;

public class CompradorDB {
	public static void save(Comprador comprador) {
		String sql = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome() + "')";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Registro com sucesso");
			System.out.println("Linhas afetadas: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void delete (Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("Não excluiu, esta sem id");
			return;
		}
		String sql = "DELETE FROM `agencia`.`comprador` WHERE (`id` = '"+ comprador.getId() +"');";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Registro excluido");
			System.out.println("Linhas afetadas: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void update (Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("Não atualizo, esta sem id");
			return;
		}
		String sql = "UPDATE `agencia`.`comprador` SET `nome` = '" + comprador.getNome() + "', `cpf` = '" + comprador.getCpf() + "' WHERE `id` = '" + comprador.getId() + "';";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Registro atualizado");
			System.out.println("Linhas afetadas: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
