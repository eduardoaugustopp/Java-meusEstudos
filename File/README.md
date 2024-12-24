<h1 align="center">File</h1>

<h3 align="center"> Canal do YouTube: <a href="https://www.youtube.com/watch?v=1MnFUxq3Z4M&list=PL62G310vn6nHrMr1tFLNOYP_c73m6nAzL&index=100">DevDojo</a> </h3>

> Curso Java Completo - Aula 98: IO pt 01 Classe File para arquivos

- Para criar o arqivo preciso chamar `file.createNewFile` esse é um método que vai retornar um valor booleano dizendo se aquele arquivo foi criado ou não, ele só será criado se ele não existir e que também precisa de um tratamento de exceção (Ctrl + 1 -> Surround Try/Catch) depois (Ctrl + 1 -> new local variable);

````java
File file = new File("Arquivo.txt");
        try {
            // Cria o arquivo e verifica se foi criado
            System.out.println("Arquivo criado? " + file.createNewFile());

            // Verifica se o arquivo existe
            boolean exists = file.exists();
            System.out.println("Permissão de leitura? " + file.canRead());
            System.out.println("Caminho relativo: " + file.getPath());
            System.out.println("Caminho absoluto: " + file.getAbsolutePath());
            System.out.println("É diretório? " + file.isDirectory());
            System.out.println("Está oculto? " + file.isHidden());
            System.out.println("Última modificação: " + new Date(file.lastModified()));

            // Deleta o arquivo se ele existe
            if (exists) {
                System.out.println("Deletado? " + file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SAÍDA: 

                Arquivo criado? false
                Permissão de leitura? true
                Caminho relativo: Arquivo.txt
                Caminho absoluto: C:\Users\eduar\eclipse-workspace\Wio\Teste\Arquivo.txt
                É diretório? false
                Está oculto? false
                Última modificação: Mon Nov 25 10:10:30 BRT 2024
                Deletado? true
````

## �� Tecnologias

<div>
  
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/>
          
</div>