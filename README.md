# 🪑 Easy_Furniture  

**Easy_Furniture** is a mobile application designed to help students and individuals buy and sell both new and used furniture through a simple and user-friendly process.  

The app focuses on making second-hand and new furniture more accessible, affordable, and easy to exchange, especially for people moving frequently such as students.  

---

## 📱 Project Idea  

- Provide a **mobile platform** where users can:  
  - Register and manage their profile.  
  - Add new furniture items for sale.  
  - Browse available furniture items.  
  - Connect with sellers/buyers in an easy process.  

- The app is built with **Android (Java)** for the mobile frontend and communicates with a **Flask API (Python)** for backend operations.  

- Styling is handled with **custom JSON styles** and **theme-based UI design** to give the application a clean, modern, and consistent look.  

---

## ⚙️ API (Backend in Python – Flask)  

The backend is developed with **Flask (Python)** and acts as the bridge between the mobile application and the database.  

### Key API Features  
- **User Management**  
  - Register new users.  
  - Log in existing users.  
  - Fetch user profile details.  

- **Furniture Management**  
  - Add new furniture items.  
  - Retrieve available furniture items.  

### Database Integration (Firebase)  
- The project uses **Firebase Realtime Database** for storing and retrieving data.  
- Communication between the API and Firebase is handled via **REST requests**.  
- Firebase ensures **real-time synchronization** of data across devices, making it scalable and cloud-based.  

---

## 🏗️ MVC Architecture  

The project follows the **Model-View-Controller (MVC)** design pattern:  

- **Model**  
  - Defines the structure of data (e.g., `User`, `Item`).  
  - Handles JSON conversion for storage in Firebase.  

- **View**  
  - The Android mobile application (built in **Java**).  
  - User interface for interacting with the system (register, browse, buy/sell items).  

- **Controller**  
  - Manages business logic and API routing.  
  - Examples:  
    - `UserController` → registration, login, profile retrieval.  
    - `ItemController` → adding and fetching furniture items.  

This separation of concerns makes the app **modular, maintainable, and scalable**.  

---

## 🎨 Design & Theme  

- **Android (Java)** → smooth navigation and user-friendly interface.  
- **Custom JSON Styles** → standardized colors, fonts, and layouts.  
- **Theme-based UI** → consistent, modern look with accessibility in mind.  

---

## 🚀 Future Enhancements  

- 💬 Chat feature for direct buyer-seller communication.  
- 💳 Payment integration for secure transactions.  
- 🔍 Advanced search and filtering options.  
- 🚚 Furniture delivery and tracking system.  

---

## 📂 Project Stack  

- **Frontend (Mobile)** → Android (Java)  
- **Backend (API)** → Flask (Python)  
- **Database** → Firebase Realtime Database  
- **Design** → JSON styles & custom Android themes  

---
