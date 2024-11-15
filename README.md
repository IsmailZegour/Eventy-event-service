# Event Service

Event Service est un microservice conçu pour gérer les événements. Il fait partie d'une architecture de microservices, permettant la création, la modification, la récupération et la suppression d'événements.

## Technologies Utilisées

- Java 17+
- Spring Boot 3.3.5
- Spring Data JPA
- PostgreSQL
- Spring Cloud (Eureka Client, OpenFeign)
- Lombok
- MapStruct
- Springdoc OpenAPI (Swagger)

## Prérequis

- Java 17 ou plus
- Maven
- PostgreSQL (configuré comme base de données pour ce service)

## Configuration

1. Configurez la base de données PostgreSQL et mettez à jour le fichier `application.yml` avec vos informations d'accès :

    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/eventdb
        username: <your-username>
        password: <your-password>
    ```

2. Assurez-vous que l'URL d'Eureka est correcte dans `application.yml` pour l'enregistrement du service :

    ```yaml
    eureka:
      client:
        service-url:
          defaultZone: http://localhost:8761/eureka
    ```

## Démarrage

1. Cloner le dépôt :

    ```bash
    git clone <repository-url>
    cd event-service
    ```

2. Compiler et démarrer le service :

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints API

### Obtenir tous les événements
- **GET** `/events`
- Réponse : Liste des événements existants

### Obtenir un événement par ID
- **GET** `/events/{id}`
- Réponse : Détails d'un événement spécifique

### Créer un événement
- **POST** `/events`
- Corps de la requête : JSON contenant les détails de l'événement
- Réponse : L'événement créé

### Mettre à jour un événement
- **PUT** `/events/{id}`
- Corps de la requête : JSON contenant les détails mis à jour de l'événement
- Réponse : L'événement mis à jour

### Supprimer un événement
- **DELETE** `/events/{id}`
- Réponse : 204 No Content en cas de succès

## Documentation Swagger

Accédez à la documentation complète de l'API via Swagger :

