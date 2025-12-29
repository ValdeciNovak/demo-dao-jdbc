# DemoDaoJdbc

## Descrição

Projeto de exemplo que demonstra o padrão DAO (Data Access Object) usando JDBC puro em Java. O objetivo é separar a lógica de acesso a dados (CRUD) da lógica de negócio, aplicando boas práticas de organização e reutilização de código.

O projeto contém entidades `Seller` e `Department` e implementações JDBC das interfaces DAO para realizar operações básicas no banco de dados.

## O que o projeto faz / Problema que resolve

- Realiza operações CRUD (Create, Read, Update, Delete) para as entidades `Seller` e `Department`.
- Demonstra a separação de responsabilidades entre camadas (aplicação <-> DAO <-> banco).
- Facilita a troca da camada de persistência (bastaria substituir as implementações DAO).

## Objetivo principal

Fornecer um exemplo simples, didático e funcional de como implementar DAOs com JDBC em Java, incluindo tratamento de exceções de banco e uso de arquivo de configuração de conexão (`db.properties`).

## Tecnologias utilizadas

- Linguagem: Java (Java SE 11+)
- Acesso a dados: JDBC (Java Database Connectivity)
- Banco de dados: MySQL
- Arquitetura: DAO (Data Access Object)
- Build: manual (sem Maven/Gradle)


## Estrutura do projeto

- `src/` - código-fonte Java
  - `application/` - classes com método `main` (pontos de execução)
  - `db/` - classes utilitárias de conexão e exceções (`DB`, `DbException`, `DBIntegrityException`)
  - `model/dao/` - interfaces DAO e fábrica (`DaoFactory`, `SellerDao`, `DepartmentDao`)
  - `model/dao/impl/` - implementações JDBC (`SellerDaoJDBC`, `DepartmentDaoJDBC`)
  - `model/entities/` - entidades do domínio (`Seller`, `Department`)
- `db.properties` - arquivo com configurações de conexão (usuário, senha, URL)

Observação: há também uma pasta `bin/` gerada com classes compiladas quando o projeto é executado pelo Eclipse.

## Funcionalidades (Principais features)

- `SellerDao` (interface) — métodos implementados em `SellerDaoJDBC`:
  - `insert(Seller obj)`
  - `update(Seller obj)`
  - `deleteById(Integer id)`
  - `findById(Integer id)`
  - `findAll()`
  - `findByDepartment(Department department)`
- `DepartmentDao` (interface) — métodos implemented em `DepartmentDaoJDBC`:
  - `insert(Department obj)`
  - `update(Department obj)`
  - `deleteById(Integer id)`
  - `findById(Integer id)`
  - `findAll()`

Com isso, o usuário da aplicação consegue criar, ler, atualizar e remover Sellers e Departments via as classes de aplicação (`Program`, `Program2`).

## Pré-requisitos

- JDK 11+ instalado e variável `JAVA_HOME` configurada.
- Driver JDBC para MySQL (MySQL Connector/J). Baixe o `.jar` correspondente à versão do MySQL e coloque-o em algum local acessível.
- Um banco de dados MySQL rodando (ou outro banco compatível, atualize `db.properties` conforme necessário).

## Configuração do banco de dados

No arquivo `db.properties` (na raiz do projeto) configure os parâmetros de conexão. Exemplo fornecido no projeto:

```
user=developer
password=your_password
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

1. Crie a database `coursejdbc` no seu MySQL (ou altere `dburl` para o nome do seu schema).
2. Ajuste `user` e `password` conforme seu ambiente.
3. Certifique-se de que o usuário tenha permissões para criar/alterar dados.

Observação: o projeto não contém scripts SQL de criação das tabelas; se necessário, crie as tabelas `department` e `seller` conforme o modelo do curso/exemplo usado (campos básicos: id, name, email, birthDate, baseSalary, department_id, etc.).

## Como executar o projeto

Opção A — Recomendado: abrir em uma IDE (Eclipse / IntelliJ IDEA)

- Importe o projeto como um projeto Java (Source folder `src`).
- Adicione o `.jar` do MySQL Connector/J como biblioteca no classpath do projeto.
- Confirme as configurações em `db.properties`.
- Execute `Program` ou `Program2` (classes em `src/application`) como aplicação Java.

Opção B — Linha de comando (Windows PowerShell)

1. Clone o repositório:

```powershell
git clone <URL-DO-REPO>
cd DemoDaoJdbc
```

2. Ajuste o `db.properties` conforme seu ambiente (ver seção anterior).

3. Baixe o driver MySQL Connector/J e guarde o caminho (ex.: `C:\libs\mysql-connector-java-8.0.31.jar`).

4. Compile os fontes para a pasta `bin` (exemplo simples):

```powershell
$mysqlJar = 'C:\libs\mysql-connector-java-8.0.31.jar'
Get-ChildItem -Recurse -Filter '*.java' -Path .\src | ForEach-Object { $_.FullName } | %{ javac -d bin -cp $mysqlJar -sourcepath src $_ }
```

Observação: o comando acima compila cada arquivo Java individualmente. Em projetos maiores ou modulares, recomenda-se usar uma ferramenta de build (Maven/Gradle) ou compilar pela IDE.

5. Executar a classe principal (ex.: `application.Program`):

```powershell
java -cp "bin;C:\libs\mysql-connector-java-8.0.31.jar" application.Program
```

Substitua o caminho do `.jar` conforme seu ambiente.

## Screenshots / Demonstração

Adicione aqui prints ou GIFs da execução da aplicação, por exemplo saídas no console mostrando CRUDs funcionando. Se houver deploy ou demo online, coloque o link.

## Arquitetura / Estrutura (opcional)

- Padrão: DAO + JDBC
- Separação em camadas: `application` (apresentação/executável) -> `model` (entidades + DAO) -> `db` (conexão/execuções/erros)

## Aprendizados / Conceitos aplicados

- Implementação do padrão DAO para desacoplamento de persistência.
- Uso de JDBC para executar queries SQL e mapear resultados para objetos Java.
- Tratamento de exceções específicas de banco (`DbException`, `DBIntegrityExeption`).
- Leitura de configurações a partir de arquivo `db.properties`.

## Desafios enfrentados

- Manter código limpo ao trabalhar com recursos (conexões, statements, ResultSet) e garantir fechamento adequado.
- Gerenciar transações e integridade referencial via SQL e tratamento de exceções.

## Próximos passos / Melhorias

- Adicionar scripts SQL para criação das tabelas e dados de teste.
- Automatizar build com Maven ou Gradle e configurar dependências (MySQL Connector/J) no `pom.xml`/`build.gradle`.
- Adicionar testes unitários/integration tests (por exemplo com JUnit + H2 em memória).
- Implementar logging (SLF4J + Logback) em vez de prints no console.

## Autor

- Valdeci Novak Junior
- GitHub: https://github.com/ValdeciNovak
- LinkedIn - https://www.linkedin.com/in/valdecijuniordev/

---
