
# Ticket Reservation System

Sistema de reservas de boletos para eventos. Esta API RESTful permite gestionar eventos y tickets, incluyendo la funcionalidad de reservas y control de disponibilidad.

## Arquitectura General

El proyecto sigue una arquitectura por capas, garantizando una clara separación de responsabilidades:

* **API**
* **Controller**
* **Service**
* **Repository**
* **Base de Datos**

## Tecnologías Utilizadas

Las tecnologías empleadas en el desarrollo del sistema son:

* Java 17+
* Spring Boot
* Spring Web
* JPA (Hibernate)
* Lombok
* PostgreSQL
* Maven
* Docker

## Instrucciones de Ejecución

Para ejecutar el proyecto localmente, sigue los pasos a continuación:

### 1. Clonar el repositorio

```bash
git clone https://github.com/JDGarzon/tickets.git
```

### 2. Acceder al directorio del proyecto

```bash
cd tickets/ticket
```

### 3. Empaquetar el proyecto con Maven

```bash
mvn clean package -DskipTests
```

### 4. Configuración del entorno

El archivo `docker-compose.yml` incluye una instancia de PostgreSQL con las siguientes credenciales predefinidas, ya configuradas en `application.properties`:

* **Usuario:** `postgres`
* **Contraseña:** `postgres`
* **Base de datos:** `postgres`
* **Puerto base de datos:** `5432`
* **Puerto de la API:** `8080`

### 5. Construir la imagen Docker

```bash
docker compose build
```

### 6. Levantar los contenedores

```bash
docker compose up -d
```
