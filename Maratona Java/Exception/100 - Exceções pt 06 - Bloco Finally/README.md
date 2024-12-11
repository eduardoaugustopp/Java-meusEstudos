# Exception

Quando precisa que algum pedaço de código seja executado independente da condição que esta acontecendo dentro do seu `try catch`:
- `finally` - é um bloco de código que sempre vai ser executado independente se executou normalmente ou não;

````
	public static void abreConexao() {
		try {
			System.out.println("Abrindo arquivo");
			System.out.println("Escrevendo dados no arquivo");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Fechando recurso liberado pelo SO");
		}
	}       
    
            SAÍDA: Abrindo arquivo
                   Escrevendo dados no arquivo
                   Fechando recurso liberado pelo SO

````