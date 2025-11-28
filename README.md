- `rdv-service` utilise **FeignClient** pour appeler `docteur-service`
- `rdv-service` appelle `notification-service` pour envoyer des notifications
- `notification-service` utilise **WebClient** pour appeler des APIs externes (simulées)

---

## ⚙️ Technologies Utilisées

- Java 17/21
- Spring Boot 3.x
- Spring Data JPA
- Spring Data REST
- OpenFeign
- Spring WebFlux (WebClient)
- H2 Database
- Maven
- IntelliJ IDEA
- Git / GitHub

---

## 📂 Microservices

### 1️⃣ docteur-service (Port 8081)

**Rôle :**
- Gérer les informations des médecins

**Fonctionnalités :**
- Ajouter un médecin
- Lister les médecins
- Consulter un médecin par ID

**Exemples d’URLs :**
- Lister les médecins :
GET http://localhost:8081/api/doctors

diff
Copier le code
- Consulter un médecin :
GET http://localhost:8081/api/doctors/1

markdown
Copier le code

**Base de données :**
- H2 (en mémoire)

---

### 2️⃣ rdv-service (Port 8082)

**Rôle :**
- Créer et gérer les rendez-vous médicaux

**Fonctionnalités :**
- Créer un rendez-vous
- Lister les rendez-vous
- Vérifier l’existence du médecin via `docteur-service` (FeignClient)

**Création d’un rendez-vous :**
```http
POST http://localhost:8082/api/rdv?doctorId=1&patientName=Hafsa&patientEmail=hafsa@test.com&dateTime=2025-12-01T10:30
Lister les rendez-vous :

bash
Copier le code
GET http://localhost:8082/api/rdv
3️⃣ notification-service (Port 8085)
Rôle :

Envoyer des notifications SMS et Email (simulation)

Technologie :

Spring WebFlux + WebClient

Envoyer un SMS :

http
Copier le code
POST http://localhost:8085/api/notifications/sms?phoneNumber=0600000001&message=Votre%20rendez-vous%20est%20confirmé
🗄️ Base de Données
H2 Database (en mémoire)

Réinitialisée à chaque redémarrage

Utilisée pour :

docteur-service

rdv-service

▶️ Lancement des Services
Lancer chaque service dans un terminal différent :

bash
Copier le code
cd docteur-service
mvn spring-boot:run
bash
Copier le code
cd rdv-service
mvn spring-boot:run
bash
Copier le code
cd notification-service
mvn spring-boot:run
✅ Tests Rapides
Voir les médecins :

bash
Copier le code
http://localhost:8081/api/doctors
Voir les rendez-vous :

bash
Copier le code
http://localhost:8082/api/rdv
🔐 Sécurité (Amélioration Future)
Ajout possible de :

Spring Security

JWT

Gestion des rôles (admin, patient)

🚀 Améliorations Futures
Ajouter une vraie base de données (MySQL / PostgreSQL)

Ajouter Eureka (Service Discovery)

Ajouter une Gateway

Ajouter un Front-End (Angular / React)

Ajouter des vraies APIs SMS / Email

👨‍🎓 Contexte Académique
Ce projet a été réalisé dans un cadre pédagogique pour comprendre :

Les microservices

La communication entre services

Les APIs REST

Spring Boot

FeignClient

WebClient

JPA & H2

Maven
