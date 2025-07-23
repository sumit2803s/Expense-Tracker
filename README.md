
# Expense Tracker - Spring Boot Application

An advanced Expense Tracker application built with **Spring Boot**, featuring:
- JWT-based login/signup authentication
- Expense CRUD operations with categories and descriptions
- Monthly recurring entries (subscriptions, rent, etc.)
- Monthly email summaries using Spring Mail + Scheduler
- Export expenses to **CSV** format
- Deployable to **Railway**, **Render**, or **AWS EC2**

---

## ✅ Features

### 🔐 Authentication (JWT)
- **Signup**: `POST /api/auth/signup`
- **Login**: `POST /api/auth/login`
- JWT token returned on successful login.
- Secure all other endpoints using JWT.

### 💸 Expense Management
- Create, Read, Update, Delete expenses.
- Fields: `title`, `description`, `category`, `amount`, `date`, `isRecurring`, `userId`
- Categories: `FOOD`, `TRAVEL`, `RENT`, `UTILITIES`, `MEDICAL`, `OTHER`

### ♻️ Recurring Entries
- Support monthly recurring expenses (e.g., rent, subscriptions)
- Handled by a **Scheduled Job** which copies recurring entries to current month.

### 📧 Monthly Summary Email
- At month-end, sends a summary email with total spend per category.
- Uses **Spring Mail** + `@Scheduled`

### 📦 Export to CSV
- Export all user expenses to downloadable CSV.
- Endpoint: `GET /api/expenses/export/csv?userId=USER_ID`

### 📊 Reporting (Future)
- Planned: export to PDF using iText, visualize via frontend charts.

---

## 🧪 Sample JSON for POST `/api/expenses`

```
POST /api/expenses
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

{
  "title": "Zomato Dinner",
  "description": "Pizza and Coke",
  "category": "FOOD",
  "amount": 450,
  "date": "2025-07-15",
  "isRecurring": false,
  "userId": "user123"
}
```

---

## 🚀 Deployment

### Railway
- Connect GitHub repo
- Set build command: `./mvnw clean package`
- Set start command: `java -jar target/*.jar`

### Render
- Use Web Service with Dockerfile or JAR
- Set environment variables for DB and Mail

### AWS EC2
- SSH into EC2
- Install Java 17+, MySQL or PostgreSQL
- Copy `.jar`, run with `java -jar expense-tracker.jar`

---

## 📂 Project Structure (Backend)

```
src/main/java/com/example/expensetracker
├── auth         # JWT login/signup
├── controller   # REST APIs
├── model        # Expense, User entities
├── repository   # JPA Repos
├── service      # Business logic
├── config       # Spring Security config
├── scheduler    # Monthly recurring task & email summary
└── util         # CSV export utility
```

---

## 📅 Scheduled Jobs

- Monthly email summary on `@Scheduled(cron = "0 0 9 1 * ?")` (1st of month)
- Recurring expenses copied monthly

---

## 📁 CSV Export Example

```
GET /api/expenses/export/csv?userId=user123
Response: CSV file download with headers:
Title,Description,Category,Amount,Date
```

---

## 🧪 Postman Collection

Postman collection includes:
- Signup, Login, Auth-protected Expense CRUD
- CSV Export
- Monthly summary test

> Download: [`expense-tracker.postman_collection.json`](#)

---

## 🔧 Tech Stack

- Java 17, Spring Boot 3.x
- Spring Security, JWT
- Spring Data JPA + H2/MySQL/Postgres
- Spring Mail
- Quartz / Spring Scheduler

---

## 📝 Future Enhancements

- Export to **PDF** using iText
- Dashboard Charts (React.js or plain JS)
- Recurring payment reminders
- Tag-wise filtering and budget limits

---

## 📌 Sample Categories

- `FOOD`, `TRAVEL`, `RENT`, `UTILITIES`, `MEDICAL`, `OTHER`
- Easily extendable via enum or database

---

## 📞 Contact / Contribution

Want to contribute or suggest features? Open an issue or PR!

---

## ✅ Sample Data

```json
[
  {
    "title": "Netflix Subscription",
    "description": "Monthly recurring subscription",
    "category": "UTILITIES",
    "amount": 499,
    "date": "2025-07-01",
    "isRecurring": true,
    "userId": "user123"
  },
  {
    "title": "Cab to Airport",
    "description": "Ola cab from home to terminal",
    "category": "TRAVEL",
    "amount": 880,
    "date": "2025-07-12",
    "isRecurring": false,
    "userId": "user123"
  }
]
```

---

> Built with ❤️ using Spring Boot.
