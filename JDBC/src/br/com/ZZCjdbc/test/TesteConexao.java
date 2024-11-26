package br.com.ZZCjdbc.test;

import br.com.ZZCjdbc.conn.ConexaoFactory;
import classes.Comprador;
import db.CompradorDB;

public class TesteConexao {

	public static void main(String[] args) {
//		deletar();
		atualizar();
	}
	
	
	public static void inserir() {
		Comprador comprador = new Comprador("Teste122", "111.111.221-30");
		CompradorDB.save(comprador);
	}
	
	public static void deletar() {
		Comprador comprador = new Comprador();
		comprador.setId(2);
		CompradorDB.delete(comprador);
	}
	
	public static void atualizar() {
		Comprador comprador = new Comprador(1, "222.222.444-45", "MARIA");
		CompradorDB.update(comprador);
	}
}
