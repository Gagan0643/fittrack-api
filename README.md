# 🏋️‍♂️ FitTrack API

A secure and scalable **Fitness Tracking Backend Application** built using **Spring Boot**. This project enables users to track their fitness activities, view recommendations, and manage their profiles, while providing admin-level controls for monitoring and managing the system.

---

## 🚀 Features

### 👤 User Functionalities

* User Registration & Login
* Secure authentication using **JWT (JSON Web Token)**
* Track daily fitness activities
* Retrieve and manage personal activity data
* Get activity recommendations

### 🛠️ Admin Functionalities

* View all registered users
* Monitor user activities across the application
* Delete users when required

### 🔐 Security

* JWT-based authentication & authorization
* Stateless session management
* Custom JWT Authentication Filter
* Role-based access control (User/Admin)
* CSRF disabled for REST API usage

### ⚙️ Exception Handling

* Centralized **Global Exception Handling**
* Consistent and meaningful error responses

---

## 🏗️ Tech Stack

* **Backend:** Spring Boot
* **Security:** Spring Security + JWT
* **Database:** MySQL / PostgreSQL (configurable)
* **Build Tool:** Maven
* **Language:** Java 8+
* **Tools:** IntelliJ IDEA, Postman, Git, GitHub

---

## 📂 Project Structure

```
fittrack-api/
│── controller/        # REST Controllers (Auth, Activity, Admin)
│── service/           # Business logic layer
│── repository/        # Data access layer
│── entity/            # JPA Entities
│── security/          # JWT, filters, and security configuration
│── exception/         # Global exception handling
│── dto/               # Data Transfer Objects
│── config/            # Application configuration
```

---

## 🔑 Authentication Flow

1. User registers or logs in
2. On successful login, a **JWT token** is generated
3. Token must be included in request headers:

   ```
   Authorization: Bearer <token>
   ```
4. All protected endpoints validate the token via JWT filter

---

## 📌 API Endpoints Overview

### 🔐 Auth Controller

* `POST /auth/register` → Register new user
* `POST /auth/login` → Login & get JWT token

### 🏃 Activity Controller

* `POST /activities` → Add activity
* `GET /activities` → Get user activities
* `GET /activities/recommendations` → Get suggested activities

### 🛡️ Admin Controller

* `GET /admin/users` → Get all users
* `GET /admin/activities` → Get all activities
* `DELETE /admin/user/{id}` → Delete a user

---

## ⚡ Getting Started

### Prerequisites

* Java 8+
* Maven
* MySQL/PostgreSQL

### Installation

```bash
git clone https://github.com/your-username/fittrack-api.git
cd fittrack-api
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

---

## 🔧 Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fitness_db
spring.datasource.username=root
spring.datasource.password=yourpassword

jwt.secret=your_secret_key
```

---

## 🧪 Testing

Use **Postman** or any API testing tool:

* Test authentication endpoints first
* Use JWT token for secured endpoints

---

## 📈 Future Enhancements

* Frontend integration (React / Next.js)
* Activity analytics dashboard
* Email notifications
* Docker deployment

---

## 🤝 Contribution

Contributions are welcome! Feel free to fork the repo and submit a pull request.

---

## 📬 Contact

**Gagan Kumar E**


---

## ⭐ Acknowledgment

If you found this project useful, consider giving it a ⭐ on GitHub!
