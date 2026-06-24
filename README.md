# 🍔 Online Food Ordering System

> A backend-focused food ordering application built using **Java Spring Boot** that provides secure user authentication, restaurant and menu management, order processing, and role-based access control using RESTful APIs.

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring%20Boot-Framework-6DB33F?logo=springboot" />
  <img src="https://img.shields.io/badge/Hibernate-ORM-59666C" />
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql" />
  <img src="https://img.shields.io/badge/JPA-Persistence-blue" />
</p>

---

# 📌 Overview

The **Online Food Ordering System** is a backend application developed using **Spring Boot** that manages restaurants, food items, customers, and orders through RESTful APIs.

The project demonstrates modern backend development practices including layered architecture, database relationships, authentication, CRUD operations, and API design.

---

# ✨ Features

## 👤 Customer

- User Registration & Login
- Browse Restaurants
- Browse Menu Items
- Place Orders
- View Order History

### 🍽 Restaurant

- Restaurant Registration
- Menu Management
- Food Item Management
- Order Management

### 🔐 Security

- User Authentication
- Password Encryption
- Role-Based Authorization
- Secure REST APIs

---

# 🛠 Tech Stack

| Category | Technologies |
|-----------|--------------|
| Language | Java |
| Framework | Spring Boot |
| ORM | Hibernate / Spring Data JPA |
| Database | MySQL |
| Build Tool | Maven |
| API Testing | Postman |

---

# 🏗 Architecture

```text
             Client
                │
        REST API Requests
                │
        Controller Layer
                │
         Service Layer
                │
      Repository (JPA)
                │
        Hibernate ORM
                │
         MySQL Database
```

---

# 📂 Project Structure

```text
Food-Ordering-System
│
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── config/
├── exception/
├── resources/
├── pom.xml
└── README.md
```

---

# ⚙ Installation

## Clone Repository

```bash
git clone https://github.com/Kavan-Dave/Food-Ordering-System.git

cd Food-Ordering-System
```

---

## Configure Database

Update

```
application.properties
```

with your MySQL credentials.

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run the Application

```bash
mvn spring-boot:run
```

The backend server will start on:

```
http://localhost:8080
```

---

# 📡 Core API Modules

- Authentication
- User Management
- Restaurant Management
- Menu Management
- Food Item Management
- Order Management

---

# 🗄 Database Design

Major entities include:

- User
- Restaurant
- Menu
- Food Item
- Order
- Order Items

The project demonstrates one-to-one, one-to-many, and many-to-many relationships using JPA and Hibernate.

---

# 🚀 Future Improvements

- [ ] Payment Gateway Integration
- [ ] Delivery Tracking
- [ ] Email Notifications
- [ ] JWT Authentication
- [ ] Docker Deployment
- [ ] Admin Dashboard
- [ ] Swagger API Documentation

---

# 📚 Learning Outcomes

This project helped me gain practical experience in:

- Spring Boot
- Spring Data JPA
- Hibernate ORM
- REST API Development
- Layered Architecture
- MySQL Database Design
- Dependency Injection
- Exception Handling
- Maven
- CRUD Operations

---

# 👨‍💻 Developer

**Kavan Dave**

B.Tech Computer Engineering
Dharmsinh Desai University

📧 Email: **kavandave15@gmail.com**

🐙 GitHub: **https://github.com/Kavan-Dave**

---

# 📄 License

Developed for educational and learning purposes.

---

⭐ If you found this project helpful, consider giving it a star.
