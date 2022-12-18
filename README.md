## Drones Project

[[_TOC_]]

---

:scroll: **START**

### Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

---

### Set-up

1. Load application in eclipse or Visual Studio Code for running in development mode (It is maven existing project)

2. Run application after it loads/installs necessary libraries

3. Since the application requires authentication, run the API for signing up user via the API documentation in the next section below.

4. Sign in with the same credentials via the Sign in end point (details via API Documentation below)

5. Register a drone

6. Register Medication

7. Load Drone with Medication

8. Check loaded medication items for a given drone

9. Check available drones for loading

10. Check drone battery level for a given drone

**Note: The API end points are details in the API documentation section below**

---

### API Documentation

**1. Creating Account**:

POST: localhost:5000/api/auth/signup

example:

{
"name": "Simon Lubambo",
"username": "slubambo",
"email": "slubambo57@gmail.com",
"password": "Alpharest@01"
}

**2. Signing in**:

POST: localhost:5000/api/auth/sign-in

example:

{
"username": "slubambo",
"password": "Alpharest@01"
}

**3. Registering a Drone**:

POST: localhost:5000/api/dispatch/register-drone

example:

{
"serialNumber": "AB4563",
"model": "LIGHT_WEIGHT",
"weightLimit": 500,
"batteryCapacity": 98,
"state": "IDLE"
}

**4. Registering a Medication**:

POST: localhost:5000/api/dispatch/register-medication

example:

{
"name": "Panadol",
"weight": 100,
"code": "A",
"imagePath": "/images/panadol.img"
}

**5. Checking available drones for loading**:

GET: localhost:5000/api/dispatch/get-available-drones

**6. check drone battery level for a given drone**:

GET: localhost:5000/api/dispatch/get-drone-battery-perecentage

example:

{
"id": 1
}

**7. loading a drone with medication items**:

GET: localhost:5000/api/dispatch/load-drone-with-medication

example:

{
"droneId": 1,
"medicationId": "1",
"count": 5,
"loadStatus": "LOADING"
}

**8. checking loaded medication items for a given drone**:

GET: localhost:5000/api/dispatch/check-drone-medication-load

example:

{
"id": 1
}

### Architecture

The program is developed using Spring Boot java framework.
An in-memory database of hsqldb is used.

### Assumptions

The application's functional components are accessed by authenticated users
The image property of Medication is set to an image path of an image saved in public directory. This is due to its advantages compare to saving the Image bytes in the database

:scroll: **END**
