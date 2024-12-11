# Exception

- Existe casos onde um método vai lançar mais de uma exceção;

`spring` - praticamente todos os outros frameworks que trabalha com web, eles tem protocolos que vão retornar exceções, tem vários tipos de `status` quando esta fazendo requisições `http`;

- É possível tratar várias exceções mas tem algumas `regras`;

1 - Não podemos colocar um tipo mais genérico a frente dos outros catch porque quando tem a `RuntimeException` tem o tipo mais genérico, todas do exemplo são filhas de RuntimeException significa que qualquer uma dessas exceções que temos elas podem ser referenciadas por um objeto da classe RuntimeException pela regra do polimorfismo ou seja se colocar o `catch RuntimeException` acima não vai acontecer nenhuma das outras exceções, **exceções mais genéricas sempre tem que vir no final** porque se não a referência do objeto vai diretamente para ela;

`throw new ArrayIndexOutOfBoundsException` -> quando executar esse código o Java vai procurar qual dessa exceções, ele consegue fazer a associação para variável de referência, aqui entra de novo o `polimorfismo` um objeto ArrayIndex ele tem duas opções `ArrayIndexOutOfBoundsException` ou `IndexOutOfBoundsException` sempre pega o primeiro catch;

```
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new ArrayIndexOutOfBoundsException();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Dentro do ArrayIndexOutOfBoundsException");
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Dentro do IndexOutOfBoundsException");
		}catch (IllegalArgumentException e) {
			System.out.println("Dentro do IllegalArgumentException");
		}catch (ArithmeticException e) {
			System.out.println("Dentro do ArithmeticException");
		}catch (RuntimeException e) {
			System.out.println("Dentro do RuntimeException");
	}

        SAÍDA: Dentro do ArrayIndexOutOfBoundsException
```

- Quando não tem o `catch` correto vai ter a exceção explodindo fazendo o programa ser terminado;

Classes filhas de `exception`:

`throws SQLException, FileNotFoundException` pode lançar mais de uma exceção, ambas exceções do tipo `checked` elas são filhas de `exception` mas elas não estão na mesma linha de `herança`, não importa a ordem que colocar; para tratar pode usar a regra de polimorfismo porque as duas são filhas de `Exception`- no exemplo independente da exceção que lançar o exception vai ser capaz de capturar aquele objeto e fazer referência para variável;

```
		try {
			talvezLanceException();
		}catch (Exception e) {

		}
	}

	private static void talvezLanceException() throws SQLException, FileNotFoundException{

	}
```
