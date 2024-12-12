# JDBC

- Criar o arquivo `docker-compose.yml`; `yml` - é um padrão de arquivos de propriedades baseado no python;

```
version: '2.4'
services:
  db:
    image: mysql
    container_name: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3307:3306"
    volumes:
      - devdojo_maratona_data:/var/lib/mysql

volumes:
  devdojo_maratona_data:
```

- `version: '2.4'` - é a melhor versão para trabalhar com imagens direto, sem precisar ser gerenciadas por outros aplicativos;
- `services` - tanto faz o nome;
- `image` - qual imagem eu quero instalar (https://hub.docker.com/);
- `container_name`- precisa colocar um nome para o container;
- `environment` - precisa passar as configurações de ambiente; o mysql é uma aplicação que esta rodando dentro de container então imagina como se você estivesse instalando sua aplicação dentro do sistema operacional e você precisa de alguns dados por exemplo do password `command` - vai ser executado quando inicializar o seu container, é um comando executável que é utilizado pelo própio mysql;
- `restart: always` - se ele parasse ele automaticamente subiria, é bom quando esta em ambiente onde precisa ter certeza absoluta de que o container esta sempre rodando;
- `ports` - se você tiver a porta padrão mysql sendo utilizada 3306, pode trocar e utilizar qualquer porta mas precisa utilizar essa sintaxe a porta do container : a porta do pc;
- `volumes` - o container é como se fosse uma máquina virtual que vai matar, reiniciar mas os dados você não quer perder, então geralmente os dados não fica dentro do container;
- Pode ter várias aplicação cada aplicação com volume diferente;
- Vai salvar os volumes separadamente do container:

```
volumes:
 - devdojo_maratona_data:
```

- Abri o docker desktop e no terminal do eclipse `docker ps` vai mostrar que não tem nenhum container sendo excutado no momento mas o docker esta sendo executado;

```
C:\Users\eduar>docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
```

- Para iniciar aplicação `docker-compose up`; precisa estar no caminho certo listar `dir` e `cd`; ele vai fazer download da imagem, ele separa a imagem por camadas e no final vai montar essa imagem e container vai ser inicializado; abri outro terminal e verifica se foi:

```
C:\Users\eduar\eclipse-workspace\JDBC\JDBC>docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED         STATUS         PORTS                               NAMES
06e5fbe0282f   mysql     "docker-entrypoint.s…"   2 minutes ago   Up 2 minutes   33060/tcp, 0.0.0.0:3307->3306/tcp   mysql
```

- Para mostrar todos os containers mesmo que parados `docker ps -a`;
- `docker-compose down` - para remover o container mas se estivesse dados eles continuariam salvos em volumes `docker volume ls`;
