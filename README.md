# 🛡 AI Secure Log Analyzer

Hero Image (later)
# 🛡 AI Secure Log Analyzer
┌──────────────────────────────────────────────┐
│                                              │
│          AI SECURE LOG ANALYZER              │
│                                              │
│         Detect • Analyze • Protect           │
│                                              │
└──────────────────────────────────────────────┘

> AI-powered Spring Boot application that analyzes security logs, detects exposed credentials, calculates security risk scores, and provides actionable recommendations for security analysts.

Built using Java • Spring Boot • REST API • Swagger • PDFBox

Badges
![Java](https://img.shields.io/badge/Java-21-orange)

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)

![Maven](https://img.shields.io/badge/Maven-Build-blue)

![License](https://img.shields.io/badge/License-MIT-yellow)

![Status](https://img.shields.io/badge/Status-Active-success)

Short Description
## Overview

AI Secure Log Analyzer is a cybersecurity-focused web application designed to inspect application logs and identify sensitive information before it leads to security incidents.

The application automatically scans uploaded logs and pasted log content, detects exposed credentials, assigns risk scores, masks sensitive information, and provides security recommendations through an intuitive dashboard.

Features
## Features

✔ Detect Email Addresses

✔ Detect Plaintext Passwords

✔ Risk Score Calculation

✔ Security Recommendations

✔ File Upload (.txt .log .pdf)

✔ REST API

✔ Swagger Documentation

✔ Spring Boot Backend

✔ Interactive Web Dashboard

✔ Mask Sensitive Information


Screenshots
## Screenshots

### Dashboard

![Dashboard](images/dashboard.png)

---

### Analysis Result

![Analysis](images/result.png)

---

### Swagger UI

![Swagger](images/swagger.png)

Architecture
                User
                  │
                  ▼
      Web Dashboard / Swagger
                  │
                  ▼
        Analysis Controller
                  │
                  ▼
         Analysis Service
                  │
      ┌───────────┼────────────┐
      ▼           ▼            ▼
 Email Detector Password API Key
                  │
                  ▼
         Risk Score Engine
                  │
                  ▼
      Security Recommendations
                  │
                  ▼
          JSON Response

Workflow


Tech Stack
## Tech Stack

Backend

- Java 21
- Spring Boot
- Maven

Frontend

- HTML
- CSS
- JavaScript

Libraries

- Apache PDFBox
- SpringDoc OpenAPI

Tools

- IntelliJ IDEA
- Git
- GitHub

Project Structure

REST API

Detection Engine
## Detection Engine

Current Detection

- Email Addresses

- Passwords

Upcoming Detection

- JWT Tokens

- AWS Credentials

- SSH Private Keys

- Credit Cards

- SQL Injection

- XSS

- Command Injection

Risk Scoring
The application assigns a security risk score based on the type and number of sensitive findings detected.

| Risk Score | Severity | Recommended Action |
|------------:|----------|--------------------|
| 0–2 | 🟢 Low | Allow |
| 3–5 | 🟡 Medium | Review |
| 6–8 | 🟠 High | Investigate |
| 9–10 | 🔴 Critical | Immediate Action |

Installation
Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/security-log-analyzer.git
```

Navigate to the project directory

```bash
cd security-log-analyzer
```

Build the project

```bash
mvn clean install
```

Run the application

```bash
mvn spring-boot:run
```

The application will start at

```
http://localhost:8080
```

Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

Usage


### Analyze Text Logs

1. Open the web dashboard.
2. Paste system logs into the text area.
3. Click **Analyze Text**.
4. Review the detected findings, risk score, and recommendations.

### Analyze Log Files

1. Click **Choose File**.
2. Upload a supported log file (.txt, .log, or .pdf).
3. Click **Analyze File**.
4. Review the generated security analysis.

Example Input

```text
2026-07-24 21:35:12 INFO User login successful
Username: hari
Email: hari@example.com
Password: MyPassword@123
API_KEY=sk_live_9A82BCDFE12456ABCDE
```

Example Output

```text
Risk Level : HIGH

Risk Score : 8

Action : REVIEW

Detected Findings

✔ Email Address

✔ Plaintext Password

✔ API Key

Recommendation

Remove sensitive credentials from logs immediately.

Rotate exposed credentials.

Review logging configuration.
```

Roadmap


- [x] Web Dashboard

- [x] REST API

- [x] File Upload

- [x] Risk Scoring

- [x] Swagger Documentation

- [ ] JWT Detection

- [ ] AWS Secret Detection

- [ ] MITRE ATT&CK Mapping

- [ ] Dashboard Analytics

- [ ] Authentication

- [ ] Docker Support

## Why This Project?

Modern applications generate thousands of log entries every day. Accidentally logging passwords, API keys, JWT tokens, or cloud credentials can create serious security risks.

AI Secure Log Analyzer helps security teams identify exposed secrets early by automatically scanning logs, assigning risk scores, masking sensitive information, and generating actionable security recommendations.

Future Improvements
     1) Drag & Drop file upload UI
     2) Risk meter visualization dashboard
     3) AI-based anomaly detection (ML integration)
     4) Cloud deployment (AWS / Render)
     5) Authentication & role-based access
     6) Database integration for log history
     7) Analytics dashboard

## Author

Shree Hari Muralidharan

Cybersecurity Enthusiast

GitHub : https://www.github/Hari0127

LinkedIn : https://www.linkedin.com/in/shreeharimuralidharan/

Portfolio : https://www.shreeharimuralidharan/netlify.app

