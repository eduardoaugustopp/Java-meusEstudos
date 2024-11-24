<h1 align="center">ArrayList</h1>

<h3 align="center"> Canal do YouTube: <a href="https://www.youtube.com/watch?v=FeLl_JsjRSo">Academia dos Devs</a> </h3>

- `ARRAY` = `vetor`- > foi criado com um tamanho fixo de 5 posições, tem essa limitação por isso surgiu `ArrayList`;

```
		String[] arrayEstatico = new String[5];
		arrayEstatico[0] = "Teste1";
		arrayEstatico[1] = "Teste2";
		arrayEstatico[2] = "Teste3";
		arrayEstatico[3] = "Teste4";
		arrayEstatico[4] = "Teste5";

//		arrayEstatico[5] = "Teste6";

        System.out.println("Imprimindo o Array Estático");
        for (int indice = 0; indice < arrayEstatico.length; indice++) {
            System.out.println(arrayEstatico[indice]);
        }
```

`ARRAYlIST` - uma estrutura semelhante ao 'array';

- Sintaxe: `ArrayList<Tipo(Wrapper Class)> nome ArrayList<Tipo>();`
- É uma classe, a diferença é que passa uma informação, qual o tipo de informação vai guardar;

- Você adiciona vários elementos quando chegar no limite(Ex.:10), ele vai criar outro array dentro do array, esse novo array vai ser mais 50% do tamanho desse array que existia antes(Ex.:15) e assim por diante ele vai gerando um arrayDinamico;

```
		ArrayList<String> arrayDinamico = new ArrayList<>();
		arrayDinamico.add("Teste6");
		arrayDinamico.add("Teste7");
		arrayDinamico.add("Teste8");
		arrayDinamico.add("Teste9");
		arrayDinamico.add("Teste10");
		arrayDinamico.add("Teste11");

		System.out.println("Imprimindo o ArrayList");

		System.out.println("Removido Teste6");
		arrayDinamico.remove(0);

//        arrayDinamico.clear();

		System.out.println(arrayDinamico.size());

//        for (int indice = 0; indice < arrayDinamico.size(); indice++) {
//            System.out.println(arrayDinamico.get(indice));
//        }

		for (String nome : arrayDinamico) {
			System.out.println(nome);
		}

```

- No arrayDinamico não precisa passar qual índice ele vai pertencer; como começo com 0 elementos, a primeira vez que fazer o `add` automaticamente vai ser o índice 0;

`add` - é um `método` `público` que esta acessando e passando um `parâmetro` para ele, esse parâmetro que você passa nesse elemento, tem o mesmo tipo que definiu `String`;

`size` - no `ArrayList` não tem uma variável `length` precisa usar o `método` `size` - é um método público que retorna um inteiro que representa o tamanho do meu arraylist;

`remove` - remove um elemento por índice;

`clear` - limpa todo arrayList;

`for`

```
//        for (int indice = 0; indice < arrayDinamico.size(); indice++) {
//            System.out.println(arrayDinamico.get(indice));
//        }
```

**`=`**

`foreach` - cada vez que você repetir nesse arrayDinamico eu vou pegar a cada elemento e vou extrair ele e eu vou chamar esse elemento que foi extraido de `nome`, toda vez que o indice for aumentando ele vai ficar trocando o valor desse variável `nome` com o novo conteúdo;

```
for (String nome : arrayDinamico) {
        	System.out.println(nome);
        }
```

- Exercício com ArrayList com uma classe criada:
  `Pessoa.java`

```
App.java

		Pessoa eduardo = new Pessoa("Eduardo", 28);
		Pessoa augusto = new Pessoa("Augusto", 28);
		Pessoa teste = new Pessoa("Teste", 28);

		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(eduardo);
		pessoas.add(augusto);
		pessoas.add(teste);

		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome());
		}
```

**`=`**

- É possível criar um objeto dentro de add:

```
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Eduardo", 28));
		pessoas.add(new Pessoa("Augusto", 28));
		pessoas.add(new Pessoa("Teste", 28));

		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome());
		}
```

- Ordenar ArrayList do tipo `Integer` usando a classe `collections`:
  `sort` - > ordenar (vai ordenar de forma crescente);
- `COLLECTIONS` - ele não imprimi ordenado, ele está trocando as posições, dentro da `ArrayList` para ficar ordenado;

```
App.java
		ArrayList<Integer> numeros = new ArrayList<>();
		numeros.add(2);
		numeros.add(1);
		numeros.add(-1);
		numeros.add(3);
		numeros.add(7);
		numeros.add(6);
		numeros.add(5);
		numeros.add(4);

		Collections.sort(numeros);
		for (Integer numero : numeros) {
			System.out.println(numero);
		}
```

- Para fazer decrescente:

```
Collections.sort(numeros, Collections.reverseOrder());
```

## �� Tecnologias

<div>
  
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/>
          
</div>
