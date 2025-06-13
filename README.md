# 🏧 ATM Machine Simulation System
<br>
A Spring Boot-based RESTful application that simulates basic ATM operations like user registration, login with JWT authentication, balance inquiry, deposits, withdrawals, and transaction history.
<br>


## 📌 Features
<br>
- ✅ User Registration & Secure Login (JWT-based)   <br>
- 🔐 Role-based access (Admin/User)                   <br>
- 💰 Deposit & Withdrawal                             <br>
- 📄 View Transaction History                           <br>
- 🔍 Check Account Balance                          <br>
- ☁️ REST API tested using Postman                   <br>
- 🛡️ Spring Security for route protection                <br>
- 🔄 MySQL database with automatic schema creation         <br>

---
<br> 
## 🛠️ Tech Stack
<br> 

| Language--------Java 17                           <br>
| Framework-------Spring Boot 3.5.0                   <br>
| ORM-------------Spring Data JPA / Hibernate         <br>
| Security--------Spring Security + JWT               <br>
| Database--------MySQL                               <br>
| Build Tool------Maven                               <br>
| API Test Tool---Postman                            <br>

---
<br>
## ⚙️ Project Structure
<br> 
atm-simulation/                                 <br>
├── controller/ # REST Controllers               <br>
├── dto/ # DTO classes for requests/responses        <br>
├── model/ # Entity classes                  <br>
├── repository/ # DAO layer                  <br>
├── service/ # Business logic                 <br>
├── security/ # JWT & Security config            <br>
├── resources/                                   <br>
│ ├── application.properties            <br>
├── pom.xml                                  <br>
