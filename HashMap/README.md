<h1 align="center">HashMap</h1>

<h3 align="center"> Canal do YouTube: <a href="https://www.youtube.com/watch?v=H62Jfv1DJlU">Coding with John </a> </h3>

- `MAP` - no seu nível mais básico, é apenas um conjunto de pares chave-valor.
- **EXEMPLO:** imagine se eu estou administrando uma empresa e tenho um monte de funcionários e todos eles têm números de identificação, eu provavelmente gostaria de algo onde eu pudesse colocar um nome de funcionário e obter seu número de identificação, esse é o tipo de coisa que um 'map' pode fazer por você, podemos criar um 'map' de nomes de funcionários e números de identificação;

> HashMap<String, Integer> emIds = new HashMap<>();

**`Os dois tipos que estamos usando devem ser classes java, eles não podem ser tipos primitivos`**

- `emIds` - ids de funcionários;

- É possível criar um `HashMap` sem especificar tipos, é recomendado parametrizar para garantir a segurança de tipos; Exemplo.: as chaves serão String e os valores serão Integer;

- `<>` -> `HashMap<>()`- teve que especificar novamente os tipos de chave-valor;

- `HashMap` é uma classe que implementa a interface `Map`. A interface 'Map' especifica os métodos que uma implementação de mapa deve suportar;

- É um mapeamento de chave-valor, nomes de funcionários e ids de funcionários; 'map' - não garante uma determinanda ordem, ele existe para armazenar esses pares de chave-valor e é com isso que você se preocupa;

```
System.out.println(empIds);
                SAÍDA: {Augusto=67891, Eduardo=12345, Teste=62291}
```

- Você pode armazenar pares de chave-valor, esta chave corresponde a este valor e mais tarde você pode procurar qual valor corresponde a esta chave, neste caso qual é o ID do funcionário Eduardo;

```
System.out.println(empIds.get("Eduardo"));
                SAÍDA: 12345
```

- Verificar se existe uma determinada chave;

```
System.out.println(empIds.containsKey("Augusto"));
                SAÍDA: true
```

- Verificar se o 'map' contém um certo valor;

```
System.out.println(empIds.containsValue(1235));
                SAÍDA: false
```

- Tem como substituir o valor `empIds.put("Eduardo", 77777);` uma outra maneira é com `replace`;

```
SAÍDA: {Augusto=67891, Eduardo=77777, Teste=62291}
```

- `REPLACE` - substituição; se não tiver com o funcionário já criado não altera e não retorna nada;

```
empIds.replace("Teste2", 12345);
		System.out.println(empIds);
            SAÍDA: {Augusto=67891, Eduardo=77777, Teste=62291}
```

```
empIds.replace("Augusto", 20);
		System.out.println(empIds);
            SAÍDA: {Augusto=20, Eduardo=77777, Teste=62291}
```

- Isso apenas adicionará o par chave-valor que você especificou se essa chave ainda não existir em algum lugar do seu 'map';

```
empIds.putIfAbsent("Eduardo", 222);
		System.out.println(empIds);
        SAÍDA: {Augusto=67891, Eduardo=77777, Teste=62291}

empIds.putIfAbsent("Teste2", 222);
		System.out.println(empIds);
        SAÍDA: {Augusto=67891, Eduardo=77777, Teste2=222, Teste=62291}
```

- Agora se quiser remover;

```
empIds.remove("Teste2");
		System.out.println(empIds);
        SAÍDA: {Augusto=67891, Eduardo=77777, Teste=62291}
```

**`Mapa é apenas uma coleção de pares chave-valor, é como uma tabela de pesquisa, neste caso, temos os nomes dos funcionários e seus ids; qualquer coisa onde você precisa criar um relacionamento como esse;`**

## �� Tecnologias

<div>
  
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/>
          
</div>
