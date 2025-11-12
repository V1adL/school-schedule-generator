# 📅 School Schedule Generator

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue) ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3-darkgreen)

A full-stack web application designed to automate the complex process of creating weekly school timetables. The system allows administrators to manage educational resources (teachers, classrooms, subjects) and uses a greedy algorithm to generate a conflict-free schedule based on defined constraints.

## ✨ Key Features

* **Admin Dashboard:** A comprehensive interface for managing school data (CRUD operations):
    * 👩‍🏫 **Teachers:** Manage teacher profiles and assign "home" classrooms.
    * 🏢 **Classrooms:** Manage available rooms.
    * 📚 **Subjects:** Link subjects to specific teachers.
    * 🎓 **Student Groups:** Manage classes and student counts.
* **Curriculum Planning:** Define the workload (e.g., "Group 10-A needs 5 hours of Math per week").
* **Automatic Generation:** One-click schedule generation that resolves basic conflicts.
* **Visualization:** Displays the generated schedule in a clear, organized weekly grid format.

## 🛠️ Tech Stack

* **Backend:** Java 17, Spring Boot 3 (Spring Web, Spring Data JPA)
* **Database:** PostgreSQL
* **Frontend:** Thymeleaf (Server-side rendering), HTML5, CSS3
* **Tools:** Maven, Lombok, Git

## 🧠 How the Algorithm Works

The core of the application is a **Greedy Algorithm** designed to solve the scheduling logic:

1.  **Data Loading:** The system fetches all Curriculum tasks (workload) and available Time Slots (from the database).
2.  **Randomization:** Time slots are shuffled to ensure a natural distribution of lessons throughout the week (avoiding "stacking" all lessons on Monday).
3.  **Iteration:** The algorithm iterates through every curriculum task.
4.  **Constraint Checking (Hard Constraints):** For each potential slot, it checks:
    * ✅ Is the **Teacher** free at this time?
    * ✅ Is the **Student Group** free at this time?
    * ✅ Is the Teacher's **Home Classroom** available?
5.  **Booking:** If a valid slot is found, the lesson is saved to the database, marking the resources as "booked" for that specific time.

## 🚀 Getting Started

### Prerequisites
* JDK 17 or higher
* PostgreSQL installed and running
* Maven

### Installation

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/your-username/school-schedule-app.git](https://github.com/your-username/school-schedule-app.git)
    ```

2.  **Configure Database**
    Create a database named `school_db` (or update the name in properties).
    Update `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3.  **Run the Application**
    ```bash
    mvn spring-boot:run
    ```

4.  **Access the App**
    Open your browser and go to `http://localhost:8080/`

## 🔮 Future Improvements

* [ ] Implement Spring Security for Admin/Teacher/Student roles.
* [ ] Export schedule to PDF/Excel.
* [ ] Improve the algorithm using Genetic Algorithms for better optimization.

