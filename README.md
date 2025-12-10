# 📚 libraryApp

> A robust backend system for library management operations, built with **Java** and **Spring Boot**.

![Java](https://img.shields.io/badge/Java-17%2B-orange) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0%2B-brightgreen) ![License](https://img.shields.io/badge/license-MIT-blue)

## 📖 Overview

**libraryApp** is a comprehensive backend solution designed to modernize traditional library operations. It adheres to modern **RESTful API** standards and is built upon a strict **N-Tier Architecture** (Controller-Service-Repository).

By leveraging **Dependency Injection** and **Inversion of Control (IoC)**, the project ensures a loosely coupled, scalable, and highly maintainable codebase. It efficiently manages the lifecycle of books, authors, and borrowing transactions while ensuring data integrity through **Spring Data JPA** and **Hibernate**.

## 🚀 Key Features

* **RESTful API Design:** Standardized HTTP methods (GET, POST, PUT, DELETE) for resource management.
* **Book Management:** CRUD operations for adding, updating, and removing books from the inventory.
* **Author & Category Tracking:** Relational data management for authors and book genres.
* **Borrowing System:** Logic to handle book checkout and return processes.
* **Database Integration:** Seamless integration with relational databases (MySQL/PostgreSQL) using ORM.

## 🛠️ Tech Stack & Architecture

* **Language:** Java
* **Framework:** Spring Boot
* **Data Access:** Spring Data JPA, Hibernate
* **Architecture:** N-Tier (Layered) Architecture
    * **Controller Layer:** Handles HTTP requests and responses.
    * **Service Layer:** Contains business logic.
    * **Repository Layer:** Manages database interactions.
* **Build Tool:** Maven / Gradle

## 📂 Project Structure

The project follows a clean separation of concerns:

```text
src/main/java/com/aysavsar/libraryapp
├── controller   # REST Controllers (API Endpoints)
├── service      # Business Logic
├── repository   # Database Interfaces (JPA)
├── entity       # Database Models
└── dto          # Data Transfer Objects
