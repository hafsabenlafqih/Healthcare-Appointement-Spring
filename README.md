
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
