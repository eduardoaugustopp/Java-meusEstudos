## Coleções pt 06 - List pt 01

`List` - uma coleção ordenada ou seja que tem uma sequência;

- As listas no pacote `Collection` ele é altamente coeso, geralmente trabalha orientado a interface e você precisa de um tipo para esse objeto; tem vários tipos que pode criar mas o mais simples é o `ArrayList` e esse `ArrayList` ele é basicamente um Array que pode ser dinamicamente incrementado; era feito até a versão 1.4;
- Precisa definir o tipo na variavel de referencia;

```java
public static void main(String[] args) {
		List<String> nomes = new ArrayList<>(16);

        // Adicionando elementos à lista
        nomes.add("William");
        nomes.add("DevDojo Academy");

        // Iterando sobre a lista usando um for-each
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println(" -------- ");

        // Adicionando mais um elemento
        nomes.add("Suane");

        // Iterando sobre a lista usando um for com índice
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

	}
```

```
William
DevDojo Academy
 --------
William
DevDojo Academy
Suane
```
