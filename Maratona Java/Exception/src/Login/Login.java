package Login;

import java.util.Scanner;

import dominio.LoginInvalidoException;

public class Login {

	public static void main(String[] args) {
		try {
			logar();
		}catch (LoginInvalidoException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
	private static void logar() throws LoginInvalidoException {
		Scanner teclado = new Scanner(System.in); 
		String usernameDB = "Teste";
		String senhaDB = "admin123";
		System.out.println("Usuário");
		String usernameDigitado = teclado.nextLine();
		System.out.println("Senha");
		String senhaDigitada = teclado.nextLine();
		if(!usernameDB.equals(usernameDigitado) || senhaDB.equals(senhaDigitada)) {
			throw new LoginInvalidoException("Usuario ou senha invalido");
		}
		
		System.out.println("Usuário logado com sucesso");
		
		}
}
