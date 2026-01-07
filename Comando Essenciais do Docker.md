# 🐳 Docker — Comandos Básicos e Essenciais (Iniciante)

## 🔹 1. Verificar instalação

```bash
docker --version
docker info
```

---

## 🔹 2. Containers

### Listar containers

```bash
docker ps
docker ps -a
```

---

### Criar e rodar

```bash
docker run -d -p 8080:80 --name meu-nginx nginx
```

---

### Parar / iniciar / reiniciar

```bash
docker stop meu-nginx
docker start meu-nginx
docker restart meu-nginx
```

---

### Entrar no container

```bash
docker exec -it meu-nginx sh
```

---

### Logs

```bash
docker logs meu-nginx
docker logs -f meu-nginx
```

---

## 🔹 3. Docker Compose (🔥 muito usado)

### Subir serviços

```bash
docker compose up
docker compose up -d
```

---

### ⏸️ Parar serviços (SEM remover nada) ⭐

```bash
docker compose stop
```

✔ Containers param
✔ Volumes permanecem
✔ Redes permanecem

---

### ▶️ Iniciar serviços já criados ⭐

```bash
docker compose start
```

✔ Volta exatamente como estava
✔ Muito rápido

---

### ⛔ Derrubar tudo do compose

```bash
docker compose down
```

❌ Remove containers
✔ Mantém volumes (por padrão)

Remover volumes também:

```bash
docker compose down -v
```

---

### Ver status do compose

```bash
docker compose ps
```

---

## 🔹 4. Diferença importante (iniciante sempre confunde)

| Comando   | O que faz                     |
| --------- | ----------------------------- |
| `up`      | Cria e sobe containers        |
| `stop`    | Para containers               |
| `start`   | Inicia containers parados     |
| `down`    | Remove containers             |
| `down -v` | Remove containers **e dados** |

---

## 🔹 5. Volumes

```bash
docker volume ls
docker volume rm nome_volume
```

---

## 🔹 6. Redes

```bash
docker network ls
docker network inspect operacoes_net
```

---

## 🔹 7. PostgreSQL (exemplo)

```bash
docker exec -it postgres_operacoes psql -U admin -d operacoes_db
```

---

## 🔹 8. Limpeza

```bash
docker container prune
docker image prune
docker system prune
```

---

## 🧠 Comandos mais usados no dia a dia

```bash
docker compose up -d
docker compose stop
docker compose start
docker compose down
docker ps
docker logs -f container
```

---

## 📌 Dica de ouro (muito importante)

👉 Para **pausar o ambiente** e continuar depois:
✅ `docker compose stop`

👉 Para **finalizar e recriar tudo depois**:
❌ `docker compose down`

