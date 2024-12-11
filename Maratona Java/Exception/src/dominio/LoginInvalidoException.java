package dominio;

public class LoginInvalidoException extends Exception {

	public LoginInvalidoException() {
		// TODO Auto-generated constructor stub
		super("Login inválido");
	}
	
	public LoginInvalidoException(String message) {
		super(message);
	}
}
