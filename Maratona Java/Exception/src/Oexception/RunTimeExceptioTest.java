package Oexception;

public class RunTimeExceptioTest {
	public static void main(String[] args) {

		abreConexao();
	}

	public static void abreConexao() {
		try {
			System.out.println("Abrindo arquivo");
			System.out.println("Escrevendo dados no arquivo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Fechando recurso liberado pelo SO");
		}
	}

}
