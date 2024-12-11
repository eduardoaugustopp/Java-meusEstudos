package Oexception9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import dominio.Leitor1;
import dominio.Leitor2;

public class RuntimeExceptionTest06 {
	public static void main(String[] args) {
			lerArquivo();
	}
	
	
	public static void lerArquivo() {
		try (Leitor1 leitor1 = new Leitor1();
			Leitor2 leitor2 = new Leitor2()) {
			
			
		} catch (IOException e) {
		}
		
	}
}
