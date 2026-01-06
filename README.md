# docker-angular-spring

Projeto full stack utilizando **Angular**, **Spring Boot** e **PostgreSQL**, orquestrado com **Docker Compose** para facilitar o ambiente de desenvolvimento e produção.

> ⚠️ **Não é necessário instalar Java, Maven, Node.js ou Angular CLI na máquina local.**  
> Todo o ambiente é executado dentro de containers Docker.

---

## 📁 Estrutura do projeto

```text
.
├── backend-spring/        # API Spring Boot
├── frontend-angular/      # Aplicação Angular
├── docker/                # Arquivos Docker e Docker Compose
│   ├── docker-compose.yml
│   ├── docker-compose.dev.yml
│   ├── docker-compose.prod.yml
│   ├── Dockerfile-angular
│   └── Dockerfile-spring
````

---

## 🧰 Pré-requisitos

Você precisa apenas ter instalado:

* **Docker**
* **Docker Compose** (ou Docker Desktop)

Verifique com:

```bash
docker --version
docker compose version
```

---

## 🚀 Executando o projeto (Desenvolvimento)

O arquivo `docker/docker-compose.yml` está configurado para **ambiente de desenvolvimento**.

### Start (subir os containers)

```bash
cd docker
docker compose up
```

Ou em background:

```bash
docker compose up -d
```

---

## ⏹️ Stop (parar os containers)

```bash
docker compose down
```

---

## 🔁 Start novamente (containers já criados)

```bash
docker compose start
```

---

## ⏸️ Stop sem remover containers

```bash
docker compose stop
```

---

## 🧹 Stop + remover volumes (reset completo)

⚠️ Remove banco de dados e dependências cacheadas:

```bash
docker compose down -v
```

---

## 🌐 Serviços disponíveis

Após subir os containers:

| Serviço         | URL                                            |
| --------------- | ---------------------------------------------- |
| Angular         | [http://localhost:4200](http://localhost:4200) |
| Spring Boot API | [http://localhost:8080](http://localhost:8080) |
| PostgreSQL      | localhost:5432                                 |

---

## 🧠 Como funciona o ambiente de desenvolvimento

### 🔹 Spring Boot

* Executa dentro do container `maven:3.9.6-eclipse-temurin-21`
* O código é montado via volume:

  ```yaml
  - ../backend-spring:/app
  ```
* O comando executado é:

  ```bash
  mvn spring-boot:run
  ```
* Dependências Maven cacheadas em:

  ```yaml
  - ~/.m2:/root/.m2
  ```

👉 **Não é necessário instalar Java ou Maven localmente**

---

### 🔹 Angular

* Executa dentro de um container Node.js
* Código montado via volume:

  ```yaml
  - ../frontend-angular:/app
  ```
* `node_modules` isolado no container:

  ```yaml
  - /app/node_modules
  ```
* Comando executado:

  ```bash
  npm install && npm run start -- --host 0.0.0.0 --poll=2000
  ```

👉 **Não é necessário instalar Node.js ou Angular CLI localmente**

---

### 🔹 PostgreSQL

* Imagem oficial `postgres:16-alpine`
* Dados persistidos via volume Docker
* Healthcheck configurado para garantir inicialização correta do Spring

---

## 🔁 Hot Reload

* Alterações no **backend** e **frontend** refletem automaticamente
* Não é necessário rebuild dos containers durante o desenvolvimento

---

## 🏗️ Produção

Para produção, utilize o compose específico:

```bash
docker compose -f docker-compose.prod.yml up --build
```

Neste modo:

* São utilizados os **Dockerfiles**
* As aplicações são buildadas
* Não há volumes de código
* Ambiente otimizado para produção

---

## 🐞 Solução de problemas comuns

### Reinstalar dependências do Angular

```bash
docker compose down -v
docker compose up
```

### Porta já em uso

Verifique se as portas abaixo estão livres:

* `4200`
* `8080`
* `5432`

---

## 📄 Licença

Este projeto está sob uma licença **permissiva**, permitindo:

* ✔️ Uso comercial e pessoal
* ✔️ Reprodução
* ✔️ Modificação
* ✔️ Distribuição

Desde que este aviso de licença seja mantido.

---

## ✉️ Contato

**Renato Gomes**
📧 Email: **[renatotgomesdev@gmail.com](mailto:renatotgomesdev@gmail.com)**
