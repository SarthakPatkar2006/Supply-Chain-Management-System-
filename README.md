# 📦 Supply Chain Management System

## 📌 Overview

This project is a **Supply Chain Management System** developed using **Object-Oriented Programming (OOP) in Java** with **MySQL database integration using JDBC**.

The system helps manage and track the flow of goods, inventory, suppliers, and orders efficiently.

---

## 🚀 Features

* 📦 Product Management (Add, Update, Delete Products)
* 🏭 Supplier Management
* 📊 Inventory Tracking
* 🧾 Order Processing
* 🔍 Search and Filter Functionality
* 💾 Data Persistence using MySQL
* 🔗 Database Connectivity via JDBC

---

## 🛠️ Technologies Used

* **Java (OOP Concepts)**
* **MySQL**
* **JDBC (Java Database Connectivity)**
* **IntelliJ IDEA / VS Code / Eclipse**

---

## 🧠 OOP Concepts Used

* Classes and Objects
* Encapsulation
* Inheritance
* Polymorphism
* Abstraction

---

## 🗄️ Database Design

The system uses MySQL with tables such as:

* `products`
* `suppliers`
* `orders`
* `inventory`

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git
cd YOUR_REPO
```

### 2. Setup MySQL Database

* Create a database:

```sql
CREATE DATABASE supply_chain;
```

* Import tables (if SQL file provided)

---

### 3. Configure JDBC

Update your database credentials in code:

```java
String url = "jdbc:mysql://localhost:3306/supply_chain";
String user = "root";
String password = "your_password";
```

---

### 4. Run the Project

* Compile and run Java files using IDE or terminal

---

## 📂 Project Structure

```
Supply-Chain-Management-System/
│── src/
│   ├── model/
│   ├── dao/
│   ├── service/
│   └── main/
│── database/
│── README.md
```

---



---

## 🔮 Future Improvements

* Web-based UI (React / Angular)
* Authentication System
* Real-time tracking
* API Integration

---

## 🤝 Contributing

Contributions are welcome. Feel free to fork and improve.

---

## 📜 License

This project is open-source and available under the MIT License.

---

## 👨‍💻 Author

**Sarthak Anil Patkar**

---

## ⭐ Acknowledgements

* Java Documentation
* MySQL Docs
* JDBC Tutorials
