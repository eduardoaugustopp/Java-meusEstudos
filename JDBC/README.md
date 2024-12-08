<h1 align="center">JDBC</h1>

<h3 align="center"> Canal do YouTube: <a href="https://www.youtube.com/watch?v=QoB0jbnXM0o&list=PL62G310vn6nHrMr1tFLNOYP_c73m6nAzL&index=142">DevDojo</a> </h3>

> Curso Java Completo - Aula 141: JDBC pt 02 Criando o banco e as tabelas

```
**PROMPT**

show databases;

create database agencia;

use agencia;

create table comprador (
    ->     id int not null auto_increment,
    ->     nome varchar(45) not null,
    ->     primary key (id)
    -> );

create table carro (
    ->     id int not null auto_increment,
    ->     placa varchar(8) not null,
    ->     nome varchar(45) not null,
    ->     compradorid int,
    ->     primary key (id),
    ->     foreign key (compradorid) references comprador(id)
    -> );

show tables;

desc carro;

desc comprador;

alter table comprador add column cpf varchar(30);

**WORKBENCH**

select * from agencia.carro;

select * from agencia.comprador;

```

> Curso Java Completo - Aula 142: JDBC pt 03 Criando conexão com o banco de dados

**`JDBC`** é um pacote disponível desde os primórdios do Java. Ele foi criado justamente para abstrair os desenvolvedores dos problemas relacionados ao banco de dados;

- Algumas interfaces que tem no pacote `java.sql:` `Connection` - buscar conexão, `Statement` - realizar operações que vão afetar o estado do banco, `ResultSet` - é como estivesse fazendo select, você esta trabalhando com os resultados daquela consulta, essas são as 3 principais; elas são interfaces porque são dependentes do sistema de banco de dados que você esta utilizando, você não sabe por exemplo como é que faz uma conexão com MySQL, eles implementaram essas interfaces e você só precisa trabalhar chamando essa interface;

- A conexão ela vem através de uma classe chamada `driverManager` - é uma classe concreta e ela vai buscar o conector específico daquele banco de dados e vai devolver pra você uma conexão e a partir da conexão você consegui trabalhar com todas as outras interfaces;

- Para obter a conexão, precisamos de 3 coisas `url`- é o mais importante porque o driveManager é uma fábrica de objetos que vai te devolver uma conexão baseado na url que você especificar aqui, `usuario`, `password`;

- Agora vamos pegar uma conexão `Connection`, a maior parte das classes que estão no pacote `java.sql` vão lançar algum tipo de exceção;

```
**ConexaoFactory**

package br.com.ZZCjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    public Connection getConexao() {
        String url = "jdbc:mysql://localhost:3306/agencia";
        String user = "root";
        String password = "admin123";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }
}
```

```
**TesteConexao**

package br.com.ZZCjdbc.test;

import br.com.ZZCjdbc.conn.ConexaoFactory;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexaoFactory conn = new ConexaoFactory();
		conn.getConexao();
	}

}               SAÍDA: com.mysql.cj.jdbc.ConnectionImpl@58e1d9d
```

> Curso Java Completo - Aula 143: JDBC pt 04 Inserindo dados no banco com Statement

- O método getConexao não esta utilizando nenhum atributo de classe e a conexão é a mesma independente de quantas vezes você chamar esse objeto então por isso coloca com `static`;
- O comando `Inline Variable` no Eclipse é uma funcionalidade de refatoração que substitui todas as referências de uma variável no código pelo valor ou expressão atribuída a ela (Alt + Shift + I);

```
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
            (Alt + Shift + I)
            return DriverManager.getConnection(url, user, password);
```

- Toda vez que abre uma conexão ela precisa ser fechada e tratada;

- Criar um pacote DB e criar uma classe CompradorDB, depois precisa de uma conexão, criar um `Statement` é o objeto que irá trabalhar com os dados lá no banco é o que vai executar essa instrução de comando `INSERT INTO...`;
- Quase todos os métodos lançam sql exception porque geralmente o banco de dados precisa passar pela rede para ser acessado e essa rede pode estar indisponível;
- Agora que nós temos o statement podemos executar `stmt.execute`; tem vários tipos de `execute`, quando precisar executar algo que vai mudar o estado do banco de dados por exemplo atualizar, inserir ou deletar utiliza `executeUpdate` se não tiver certeza no que vai executar até receber esse sql execute o `execute`, `executeQuery` que quando quer fazer uma consulta você vai ter diversos resultados para trabalhar;

```
**ConexãoFactory**

		String url = "jdbc:mysql://localhost:3306/agencia";
		String user = "root";
		String password = "admin123";

		try {

			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}

	public void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void close(Connection connection, Statement stmt) {
		close(connection);
		try {
			if (stmt != null) {
				stmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
```

```
**CompradorDB**
String sql = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('Maria', '123.456.789.12')";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Linhas afetadas: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
```

```
**TesteConexao**
		CompradorDB compradordb = new CompradorDB();
		compradordb.save();

        SAÍDA: Linhas afetadas: 1
```

- Alterando os códigos para passar os objetos:
- Criar um pacote classes e uma classe Comprador;

```

public class Comprador {
	private Integer id;
	private String cpf;
	private String nome;

	public Comprador() {

	}


	public Comprador(Integer id, String cpf, String nome) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comprador other = (Comprador) obj;
		return Objects.equals(id, other.id);
	}

```

```
public class TesteConexao {

	public static void main(String[] args) {
		Comprador comprador = new Comprador("Teste122", "111.111.221-30");
		CompradorDB compradordb = new CompradorDB();
		compradordb.save(comprador);
	}
}
```

```
public class CompradorDB {
	public void save(Comprador comprador) {
		String sql = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome() + "')";
```

> Curso Java Completo - Aula 144: JDBC pt 05 Atualizando e excluindo dados com Statement

```
package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ZZCjdbc.conn.ConexaoFactory;
import classes.Comprador;

public class CompradorDB {
	public static void save(Comprador comprador) {
		String sql = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('" + comprador.getCpf() + "', '"
				+ comprador.getNome() + "')";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Registro com sucesso");
			System.out.println("Linhas afetadas: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não excluiu, esta sem id");
			return;
		}
		String sql = "DELETE FROM `agencia`.`comprador` WHERE (`id` = '" + comprador.getId() + "');";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Registro excluido");
			System.out.println("Linhas afetadas: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void update(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não atualizo, esta sem id");
			return;
		}
		String sql = "UPDATE `agencia`.`comprador` SET `nome` = '" + comprador.getNome() + "', `cpf` = '"
				+ comprador.getCpf() + "' WHERE `id` = '" + comprador.getId() + "';";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Registro atualizado");
			System.out.println("Linhas afetadas: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}

```

```
package br.com.ZZCjdbc.test;

import br.com.ZZCjdbc.conn.ConexaoFactory;
import classes.Comprador;
import db.CompradorDB;

public class TesteConexao {

	public static void main(String[] args) {
//		deletar();
		atualizar();
	}


	public static void inserir() {
		Comprador comprador = new Comprador("Teste122", "111.111.221-30");
		CompradorDB.save(comprador);
	}

	public static void deletar() {
		Comprador comprador = new Comprador();
		comprador.setId(2);
		CompradorDB.delete(comprador);
	}

	public static void atualizar() {
		Comprador comprador = new Comprador(1, "222.222.444-45", "MARIA");
		CompradorDB.update(comprador);
	}
}

```

## �� Tecnologias

<div>
  
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/>
          
</div>
