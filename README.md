📦 Courier Management System

A Java-based desktop application designed to manage courier services efficiently. The system allows users to record courier bookings, manage shipment details, and track deliveries through a simple and user-friendly interface.

🚀 Features

📄 Add new courier records

🔍 Search courier details

📦 Track shipment status

🗂 Manage courier database

🖥 Simple and intuitive desktop interface

🛠 Tech Stack

Language: Java

IDE: Eclipse IDE

Database: MySQL

UI: Java Swing

📂 Project Structure
Courier-Management-System
│
├── src/                 # Java source code
├── database/
│   └── courier_db.sql   # MySQL database export
├── .classpath
├── .project
└── README.md
⚙️ Prerequisites

Before running the project, ensure you have the following installed:

Java JDK

Eclipse IDE or any Java IDE

MySQL Server

MySQL Workbench (optional for database import)

🧑‍💻 How to Run the Project
1️⃣ Clone the Repository
git clone https://github.com/midhulsasikumar-an/Courier-Management-System.git
2️⃣ Import the Project

Open Eclipse IDE

Click File → Import

Select Existing Projects into Workspace

Choose the cloned project folder

3️⃣ Setup the Database

Open MySQL Workbench

Create a new database:

CREATE DATABASE courier;

Import the SQL file located in:

database/courier_db.sql

This will create all required tables and data.

4️⃣ Configure Database Connection

Update the database credentials in the project if required:

String url = "jdbc:mysql://localhost:3306/courier";
String username = "root";
String password = "your_password";
5️⃣ Run the Application

Run the main Java file from Eclipse to start the Courier Management System.

📸 Screenshots

(Add screenshots of your application here)

Example:

screenshots/homepage.png
screenshots/add_courier.png
screenshots/search_courier.png
📌 Future Improvements

User authentication system

Online courier tracking

Web-based version of the application

Automated notifications for delivery status

👨‍💻 Author

Midhul Sasikumar
Integrated MCA Student
Rajagiri College of Social Sciences

GitHub:
https://github.com/midhulsasikumar-an

📜 License

This project is for educational and learning purposes.
