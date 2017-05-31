Spring-Boot Example
=========================

This is a sample Java / Spring / Maven / MongoDB / application that can be used as a starter.

Security
----------------
Authentication based on [Json Web Token](https://jwt.io/).

Requirements
------------
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [MongoDB](https://www.mongodb.com/download-center?jmp=nav#community) or by `docker pull mongo`
* [Apache Maven 3.x](http://maven.apache.org/)

Quick start
-----------
1. Clone this project
2. Run MongoDB process(`docker run --name mongo-latest -v /opt/db/mongo:/data/db -p 27017:27017 -d mongo:latest`).
3. Run in console `mvn clean install`, `java -jar target/*.jar` or just `mvn spring-boot:run`
4. Point your browser to [http://localhost:8080/](http://localhost:8080/)

API urls
--------
* Authentication: POST to `/auth/login` with body(example)
```
{
    "username": "admin",
    "password": "admin"
}
```

* Secured page: GET to `/secured` with header type: `x-auth-token` and token value.

* Load all users: GET to `/api`.

* Load user by ID: GET to `/api/{id}`.