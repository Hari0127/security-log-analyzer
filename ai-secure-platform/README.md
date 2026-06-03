# Security Log Analyzer

A full-stack security tool that analyzes logs and detects sensitive data such as emails, passwords, and API keys. It evaluates risk levels and provides actionable insights.

---

## Features

-  Detects sensitive data (Email, Passwords, API Keys)
-  Risk scoring engine (Low / Medium / High)
-  Automated action recommendation (ALLOW / BLOCK)
-  File upload support (TXT, LOG, PDF)
-  Insights generation
-  Interactive UI dashboard
-  Timestamped analysis

---

## Tech Stack

**Backend**
- Java
- Spring Boot
- REST API

**Frontend**
- HTML
- CSS
- JavaScript (Fetch API)

**Libraries**
- Apache PDFBox (PDF processing)
- Swagger (API documentation)

---

## API Endpoints

### Analyze Logs
POST /api/analyse

### Analyze File

---

## Demo

- GitHub Repo: https://github.com/Hari0127/AI-Secure-Platform

---

## How to Run

```bash
mvn spring-boot:run

Then Open : http://localhost:8080/index.html

 Future Improvements
 Drag & Drop file upload UI
 Risk meter visualization dashboard
 AI-based anomaly detection (ML integration)
 Cloud deployment (AWS / Render)
 Authentication & role-based access
 Database integration for log history
 Analytics dashboard

Author,
Shree Hari Muralidharan
