package Oexception7;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new RuntimeException();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Dentro do ArrayIndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Dentro do IndexOutOfBoundsException");
		} catch (IllegalArgumentException e) {
			System.out.println("Dentro do IllegalArgumentException");
		} catch (ArithmeticException e) {
			System.out.println("Dentro do ArithmeticException");
		} catch (RuntimeException e) {
			System.out.println("Dentro do RuntimeException");
		}

		try {
			talvezLanceException();
		} catch (Exception e) {

		}

	}

	private static void talvezLanceException() throws SQLException, FileNotFoundException {

	}

}
