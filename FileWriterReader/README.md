<h1 align="center">FileWriter e FileReader</h1>

<h3 align="center"> Canal do YouTube: <a href="https://www.youtube.com/watch?v=Czq4WgIpAe0&list=PL62G310vn6nHrMr1tFLNOYP_c73m6nAzL&index=100">
DevDojo</a> </h3>

> Curso Java Completo - Aula 99: IO pt 02 FileWriter e FileReader

- A classe FileWriter e FileReader servem para somente escrever e ler caracteres em um arquivo;
- Quando esta trabalhando com `IO` começa encadear diversas classes;
- Somente de criar o objeto já criamos o arquivo;
````
File file = new File("Arquivo.txt");
````
`FileWriter fw = new FileWriter(file);` - (Ctrl + 1 -> Surround Try/Catch);

- Toda vez que você escreve em um arquivo, está trabalhando com um `buffer`. Isso significa que você utiliza um recurso do sistema operacional, pois o arquivo está localizado no HD, e o sistema operacional cria um `túnel` para que o Java possa gravar os dados no arquivo (por exemplo, um arquivo.txt). Nesse túnel, chamado de `stream`, você pode realizar várias operações de escrita. Porém, durante esse processo, pode acontecer de algumas informações permanecerem no buffer, sem serem efetivamente gravadas no arquivo. Para garantir que todos os dados sejam transferidos do buffer para o arquivo, é necessário utilizar o `método flush`. Ele força a saída de todos os dados que estão no buffer para o arquivo. Após isso, o método `close` deve ser chamado para liberar o recurso e encerrar a conexão com o arquivo.
- Esse exemplo a seguir, toda vez que eu alterar a mensagem e roda vai sobrescrever:

````
		File file = new File("Arquivo.txt");
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.write("Escrevendo uma mensagem no arquivo\nE pulando uma linha 3");
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
````
- O `método append` permite incluir novos dados ao final do arquivo em vez de sobrescrever seu conteúdo. Para isso, é necessário configurá-lo no construtor do objeto usado para manipular o arquivo. Quando ativado, ele adiciona os dados ao final do arquivo existente, preservando o conteúdo já salvo. **, true**

````
FileWriter fw = new FileWriter(file, true);
````

- `fr.read` ele vai retornar um int e vai colocar dentro de um array; cria um array char;

````
package FileWriterReaderTest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Arquivo.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			
			fw.write("Escrevendo uma mensagem no arquivo\nE pulando uma linha 5");
			fw.flush();
			fw.close();
			
			FileReader fr = new FileReader(file);
			char[] in = new char[500];
			int size = fr.read(in);
			System.out.println("tamanho " + size);
				for(char c: in) {
					System.out.print(c);
				}
				
			fr.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
            SAÍDA:  tamanho 168
                    Escrevendo uma mensagem no arquivo
                    E pulando uma linha 3Escrevendo uma mensagem no arquivo
                    E pulando uma linha 5Escrevendo uma mensagem no arquivo
                    E pulando uma linha 5

````


## �� Tecnologias

<div>
  
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/>
          
</div>