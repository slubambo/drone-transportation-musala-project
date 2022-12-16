## Drones Project

[[_TOC_]]

---

:scroll: **START**

### Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

---

### Set-up

Create mysql database and give a name according to the properties file connection details


---

### API Documentation

1. **Creating Account**:

POST: localhost:5000/api/auth/signup

example:

{
"name": "Simon Lubambo",
"username": "slubambo",
"email": "slubambo57@gmail.com",
"password": "Alpharest@01"
}

2. **Signing in**:

POST: localhost:5000/api/auth/sign-in

example:

{
"username": "slubambo",
"password": "Alpharest@01"
}

3. **Registering a Drone**:

POST: localhost:5000/api/dispatch/register-drone

example:

{
"serialNumber": "AB4563",
"model": "LIGHT_WEIGHT",
"weightLimit": 500,
"batteryCapacity": 98,
"state": "IDLE"
}

4. **Checking available drones for loading**:

GET: localhost:5000/api/dispatch/get-available-drones

5. **check drone battery level for a given drone**:

GET: localhost:5000/api/dispatch/get-drone-battery-perecentage

example:

{
"id": 1
}

6. **loading a drone with medication items**:

GET: localhost:5000/api/dispatch/load-drone-with-medication

example:

{
"droneId": 1,
"medicationId": "1",
"count": 5,
"loadStatus": "LOADING"
}

7. **checking loaded medication items for a given drone**:

GET: localhost:5000/api/dispatch/check-drone-medication-load

example:

{
"id": 1
}

:scroll: **END**
