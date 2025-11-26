<img width="1478" height="6218" alt="_C__Users_rites_OneDrive_Desktop_NodeApp_BLW-Project_Harmuz_src_main_resources_static_index html (1)" src="https://github.com/user-attachments/assets/f4d1643c-53a6-4215-a383-479084d59ec0" /># Harmuz

Harmuz is a **B2B-focused web application** built to streamline information sharing, improve communication, and provide secure access control between business entities.  
Developed with a modern backend stack, the platform ensures reliability, scalability, and secure data handling.

---

## 🚀 Tech Stack

- **Backend:** Spring Boot  
- **Database:** MongoDB  
- **Authentication:** JWT (JSON Web Token)  
- **Architecture:** REST APIs, Role-Based Access  
- **Others:** Maven, Java 17+

---

## 🔍 About the Project

B2B entities often face challenges in sharing information securely and managing roles across teams.  
**Harmuz** solves these problems by providing:

- Secure, token-based authentication  
- Role-based access for different user levels  
- A centralized dashboard for communication and information exchange  
- A scalable backend designed for real-world business needs  

---

## ✨ Features

- 🔐 **JWT Authentication System**  
- 👤 **Role-Based Access Control (RBAC)**  
- 📊 **Information Sharing Dashboard**  
- 📁 **Modular and Maintainable Code Structure**  
- ⚡ **Fast & Scalable REST APIs**  
- 🗄️ **MongoDB Integration**

---

## 📦 Project Structure
Harmuz/
├── src/
│ ├── main/
│ │ ├── java/com/harmuz/...
│ │ ├── resources/
│ │ │ └── application.properties
│ └── test/
├── pom.xml
└── README.md


---

## Screenshot
![App Screenshot](screenshot.png)

## 🛠️ Setup & Installation

### 1. Clone the Repository
```bash
git clone https://github.com/Ritesh9793/Harmuz.git
cd Harmuz

### 2. Configure MongoDB
Update your MongoDB URI in application.properties:

spring.data.mongodb.uri=mongodb://localhost:27017/harmuz

3. Run the Application
mvn spring-boot:run


Server will start at:

http://localhost:8080

📘 Sample API Endpoints
Method	Endpoint	Description
POST	/auth/register	Register a new user
POST	/auth/login	Authenticate and get JWT
GET	/dashboard	Get dashboard data
GET	/admin/users	Admin-only: list all users

🤝 Contributing

Contributions, feature requests, and issues are welcome!
Open a pull request or raise an issue anytime.

### Developed By

Ritesh Gupta
