# 🖥️ Sistema de Cadastro de Clientes - Desktop

## 📌 Sobre o projeto
Este projeto consiste em um sistema desktop para gerenciamento de clientes, desenvolvido com Java Swing e integrado a um banco de dados MySQL.

A aplicação permite realizar operações completas de CRUD (Create, Read, Update e Delete), simulando funcionalidades comuns em sistemas corporativos.

---

## 🚀 Tecnologias utilizadas
- Java
- Java Swing
- MySQL
- JDBC
- Maven

---

## 💻 Funcionalidades
- Cadastro de clientes
- Listagem de clientes
- Atualização de dados
- Exclusão de clientes

---

## 🧱 Arquitetura do projeto
O projeto segue uma estrutura baseada em separação de responsabilidades:

- **model** → Representação dos dados (Cliente)
- **dao** → Acesso ao banco de dados (ClienteDAO)
- **database** → Conexão com banco (ConnectionFactory)
- **view** → Interface gráfica (Swing)
- **controller** → Lógica de controle

---

## 🗄️ Banco de Dados

### 📌 Script inicial
```sql
CREATE DATABASE client_system;

USE client_system;

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20)
);

▶️ Como executar o projeto
1. Clonar o repositório
- git clone https://github.com/seu-usuario/seu-repositorio.git

2. Configurar o banco de dados
- Instalar MySQL
- Criar o banco utilizando o script acima

3. Configurar conexão
- Editar a classe ConnectionFactory com suas credenciais:
- String url = "jdbc:mysql://localhost:3306/client_system";
- String user = "root";
- String password = "sua_senha";

4. Executar o projeto
- Rodar a classe Main na IDE (NetBeans, IntelliJ ou Eclipse)
📷 Imagens do sistema
- 🚧 Em breve
📈 Status do projeto
- 🚧 Em desenvolvimento
🎯 Objetivo do projeto:
- Este projeto foi desenvolvido com foco em aprendizado e demonstração de conhecimentos em:
- Programação orientada a objetos
- Integração com banco de dados
- Desenvolvimento de aplicações desktop
- Boas práticas de organização de código
💼 Diferenciais
- Estrutura organizada (MVC + DAO)
- Integração com banco de dados real
- Uso de boas práticas com JDBC
- Gerenciamento de tarefas com GitHub Projects
👨‍💻 Autor
- Desenvolvido por Andrey