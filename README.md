# 🏧 ATM Machine Simulation System
<br>
A backend + frontend project simulating ATM functionalities such as user registration, login with JWT authentication, balance inquiry, deposits, withdrawals, and transaction history.  Built with Spring Boot, MySQL, JPA, and plain HTML/CSS/JavaScript
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

| Language-------- Java 17                           <br>
| Framework------- Spring Boot 3.5.0                   <br>
| ORM------------- Spring Data JPA / Hibernate         <br>
| Security-------- Spring Security + JWT               <br>
| Database-------- MySQL                               <br>
| Frontend-------- HTML, CSS, JavaScript               <br>
| Build Tool------ Maven                               <br>
| API Test Tool--- Postman                            <br>

---
<br>
## ⚙️ Project Structure
<br> 
atm-simulation/                                     <br>
├── src/                                             <br>
│ ├── main/                                            <br>
│ │ ├── java/com/example/atm/                         <br>
│ │ │ ├── controller/ → REST APIs                       <br>
│ │ │ ├── model/ → User, Transaction, ATM entities        <br>
│ │ │ ├── repository/ → JPA Repositories                <br>
│ │ │ ├── service/ → Business logic                   <br>
│ │ │ └── AtmApplication.java                            <br>
│ └── resources/                                     <br>
│ └── application.properties                         <br>
├── frontend/                                    <br>
│ ├── index.html                                <br>
│ └── script.js                                        <br>
└── README.md                                  <br>
