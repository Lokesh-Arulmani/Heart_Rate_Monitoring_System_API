# Heart_Rate_Monitoring_System_API
This is a backend application built using Spring Boot to manage users, patients, and heart rate data. The system allows user registration, patient management, and recording/retrieving heart rate data for patients.

### Features
- User Registration & Login
- Manage Patients (Add and Retrieve Patient Details)
- Record and Retrieve Heart Rate Data

- ### Prerequisites
- JDK 11 or above
- Maven
- MySQL Database

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Lokesh-Arulmani/Heart_Rate_Monitoring_System_API.git

2. Navigate to the project directory.

3. Update application.properties with your MySQL database credentials:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update

4. Run the application:
   ```bash
   mvn spring-boot:run



#### API Documentation

### API Endpoints

#### 1. User Registration and Login

- **POST /api/users/register**
  - Request body:
    ```json
    {
      "email": "user@example.com",
      "password": "password123"
    }
    ```
  - Response:
    ```json
    {
      "id": 1,
      "email": "user@example.com"
    }
    ```

- **POST /api/users/login**
  - Request body:
    ```json
    {
      "email": "user@example.com",
      "password": "password123"
    }
    ```
  - Response:
    ```json
    {
      "id": 1,
      "email": "user@example.com"
    }
    ```

#### 2. Manage Patients

- **POST /api/patients/add**
  - Request body:
    ```json
    {
      "name": "John Doe",
      "email": "john@example.com",
      "gender": "Male",
      "age": 30,
      "user": {
        "id": 1
      },
      "heartRateData": "120, 130, 140"
    }
    ```
  - Response:
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "email": "john@example.com",
      "gender": "Male",
      "age": 30,
      "heartRateData": "120, 130, 140"
    }
    ```

- **GET /api/patients/details**
  - Query Parameter:
    ```plaintext
    email=john@example.com
    ```
  - Response:
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "email": "john@example.com",
      "gender": "Male",
      "age": 30,
      "heartRateData": "120, 130, 140"
    }
    ```

#### 3. Heart Rate Details

- **POST /api/heart-rate/add**
  - Request body:
    ```json
    {
      "patient": {
        "id": 1
      },
      "heartRateData": "130, 135, 140, 145",
      "timestamp": "2025-01-08T12:00:00"
    }
    ```
  - Response:
    ```json
    {
      "id": 1,
      "heartRateData": "130, 135, 140, 145",
      "timestamp": "2025-01-08T12:00:00"
    }
    ```

- **GET /api/heart-rate/details**
  - Query Parameter:
    ```plaintext
    patientId=1
    ```
  - Response:
    ```json
    [
      {
        "id": 1,
        "heartRateData": "130, 135, 140, 145",
        "timestamp": "2025-01-08T12:00:00"
      }
    ]
    ```

---

#### **Assumptions and Decisions**

```markdown
- The application does not use authentication protocols like JWT or OAuth for simplicity. Email and password validation is used for registration and login.
- Heart rate data is stored as a simple string, but it can be extended to a more complex structure (e.g., JSON or time-series data).
- A patient can have multiple heart rate records.



