# Exception

`throw new` - para lançar novas exceções e o objeto `IllegalArgumentException` - método recebeu um argumento inapropriado, é uma filha ou subclasse de `RuntimeException`; caso queira a avisar outras pessoas que estão utilizando novo método, coloca na assinatura do método depois do parentese `throws` - é tipo uma flag falando existe a possibilidade de lançar e coloca a exceção;

**`Sempre bom tentar utilizar as exceções mais específicas possíveis`**

- Esse é um exemplo quando estiver fazendo diversos tipos de métodos, idade - não deixar as pessoas colocar idade negativo, uma idade maior que 150 anos, esses tipos de coisa vai tratar com `exceções` e **não** com `retorno` que tecnicamente é inválido, sempre que tiver que fazer alguma validação pode lançar uma nova exceção e se lança uma exceção tambem poderia colocar um `try catch` dentro do médoto main;

- As exceções do tipo `Runtime` não precisam ter declaração aqui na nossa assinatura do método, pode colocar uma mensagem falando "olha essa divisão tenho possibilidade de lançar `IllegalArgumentException`" o que acontece é que quando faz isso, você vai na divisão, ele mostra que existe a possibilidade de `IllegalArgumentException` quando você diz isso você ta falando para outras pessoas que estão utilizando o seu método que caso alguma coisa aconteça vai ser lançado uma exceção;

```
public class RunTimeExceptioTest {
	public static void main(String[] args) {
		divisao(1, 0);
		System.out.println("Código finalizado");
	}
	/**
	 *
	 * @param a
	 * @param b não pode ser 0
	 * @return
	 * @throws IllegalArgumentException caso b seja zero
	 */

	private static int divisao(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Argumento ilegal, não pode ser 0");
		}
		return a / b;
	}
   }
      SAÍDA: Exception in thread "main" java.lang.IllegalArgumentException: Argumento ilegal, não pode ser 0
	at Exceptions/Oexception.RunTimeExceptioTest.divisao(RunTimeExceptioTest.java:24)
	at Exceptions/Oexception.RunTimeExceptioTest.main(RunTimeExceptioTest.java:9)

```
