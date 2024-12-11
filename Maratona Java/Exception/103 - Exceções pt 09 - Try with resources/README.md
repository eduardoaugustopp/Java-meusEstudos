# Exeption

Exemplo para ler arquivo usando Java:

- Classe `Reader` do pacote `java.io` - classes responsáveis para trabalhar com a leitura de arquivos;
- Criando uma variável de referência com valor nulo separadamente em seguida ler o arquivo `BufferedReader` é uma versão mas otimizad;
- `FileReader` lança uma exceção, ou adiciona a assinatura no método e joga a bronca para quem chamo ou `try catch`;

- O `try()` com recursos tem a seguinte sintaxe, dentro do parentese declara a variável e instância objeto; o try com recursos esta se encarregando de tomar conta de fechar a conexão dessa variável de referência;
- Quando esta trabalhando com `try resources` pode remover o catch porem é obrigado a utilizar o `throws` e a exceção que esta sendo lançada `IOException`;

- Pode declarar quantas variáveis quiser a diferença é eu preciso que essas variáveis implementem a interface `closeable`

```
	public static void lerArquivo() {
		try (Leitor1 leitor1 = new Leitor1();
			Leitor2 leitor2 = new Leitor2()) {


		} catch (IOException e) {
		}
```

- O java foi responsável por chamar o `close` e eles são fechados na ordem inversa que eles foram declarados, isso é util quando esta trabalhando com banco de dados, precisa fechar na ordem inversa;

```
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

    SAÍDA: Leitor 2 fechando
           Leitor 1 fechando
```
