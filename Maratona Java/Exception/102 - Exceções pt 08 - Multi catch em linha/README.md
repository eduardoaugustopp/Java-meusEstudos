# Exception 

- Existe uma sintaxe que foi criada para facilitar e melhorar a legibilidade do código, essa ``sintaxe`` fala que pode colocar exceções que não estão na mesma linha de herança, dentro de uma mesmo catch separados via pai; ``EX.:`` ``SQLException, FileNotFoundException`` ambas exceções são feitas de exception mas não fazem parte da mesma herança, então o que pode fazer e ir no primeiro catch e dizer captura ``SQLException | ou FileNotFoundException``;

````
		try {
			talvezLanceException();
		}catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
````
- Tem que tomar cuidado porque não pode fazer isso quando tem classes na mesma linha de herança um ``EX.:`` digamos que ``throws SQLException, FileNotFoundException, IOException``:
- Vai ter um erro porque o Java vai identificar da mesma forma que faria com todos os catch qual exceção ela server e bate para fazer a referencia para essa variável, temos aqui a variável e;
````
	try {
			talvezLanceException();
		}catch (SQLException | FileNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	private static void talvezLanceException() throws SQLException, FileNotFoundException, IOException {

	}
````
