# SecureFlag_Event_management
README.md

Prerequisites
How to run the tests
How to change the base URL
Notes about dependencies
Sample output/expectations


Event Management API – Automated Test Suite

1.	Overview

This repository contains automated API tests for SecureFlag Event Management System (Events & Bookings).  
The tests are written in Java using JUnit  and RestAssured.

---

2.	Prerequisites

- Java 11 or higher installed
- Maven installed (`mvn -v` to check)
- The Event Management API running and accessible (default: `http://localhost:8080`)
- (Optional) IDE like IntelliJ IDEA or Eclipse

---

3.	 How to Run the Tests

a)	Clone the Repository
Bash:
           cd <your-repo-folder>
           git clone <your-repo-url>
b) Configure Base URL (if needed)
        - By default, tests use `http://localhost:8080` as the API base URL.
        - To change it, modify the `baseUrl` value in `EventManagementApiTests.java`
c) Run src/main/java/com/secureflag/Application.java on your local machine
d) Run src/test/java/test_runner/TestRunner.java
e) get a booking reference from a created event, paste it in feature file under bookingref for cancel booking and run seperately

Java:
      String baseUrl = "http://localhost:8080";
      
    - Or refactor to load from an environment variable or config file if preferred.

c) Run Tests Using Maven
    bash
    mvn test
    
    - Maven will download dependencies and run all test cases.
    - Test results will be shown in the console and in the `target folder.

d) Interpreting Results
    - All tests should pass if the API is working as intended.
    - Failures indicate possible issues or negative/edge case handling.

---

Project Structure
Secure_api_automation/
│.idea
│Docs
   ├── Bug Report.docx
   ├──Test Plan for Event Management API.docx
    ├──Test Report.docx
├── src/
│   ├── main/
│   │   └── java/
│
│   └── test/
│       ├── java/
│       │   └── step_definitions/
│       │       ├── test_runner/
│       │       │   ── utilities/
│       │     
│       └── resources/
│           └── features_files/
│               └── secureFlagEvents.feature
	└── templates/
	     └── createBookingTemplate.json
│-└── target/
└── pom.xml

Dependencies

Main test dependencies are:
•	io.rest-assured
•	org.junit.jupiter
•	jackson-databind
•	io.cucumber

These are automatically handled by Maven (see `pom.xml`).

---


![image](https://github.com/user-attachments/assets/a9fe4b5e-c929-4c41-8372-2782feb8fc93)
