# Toy store server

A full REST API project using Spring Boot, spring Data and PostgreSQL.

## Tech stack

- Java 11, built with Maven
- Spring Boot 2.1.8.RELEASE
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Spring Boot Actuator
- Lombok
- PostgreSQL driver
- H2 database
- Database: PostgreSQL (`toystoredb` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Toy` | code, minAge, maxAge, price, image, customersLikedToy, toyprovider |
| `Customer` | Id, Name, BirthDay, ToysLiked |
| `toyImage` | id, fileName, fileType, data |
| `toyProvider` | id, address, Toys |
| `Address` | id, city, streetNumber, postalCode, toyprovider |

## REST endpoints

Found in the controllers (`toyController`, `toyImageController`, `customerController`):

| Method | Path |
|---|---|
| GET | `/alltoys` |
| GET | `/toy/{id}` |
| POST | `/newToy` |
| PUT | `/updateToy/{id}` |
| GET | `/toyByName/{name}` |
| DELETE | `/removeToy/{id}` |
| DELETE | `/removeToyByType/{type}` |
| GET | `/getToySortedByName` |
| GET | `/getToySortedByType` |
| GET | `/allElectronicstoys` |
| POST | `/images/uploadFile` |
| POST | `/images/uploadMultipleFiles` |
| GET | `/images/downloadFile/{fileId}` |
| POST | `/images/api/files` |
| GET | `/customers/customersnameLike/{ch}` |
| GET | `/customers/customer/{id}` |

## Project structure

- (default package): CustomerLikes
- `com.jee.tp.serveruser`: ServerUserApplication
- `com.jee.tp.serveruser.Controllers`: customerController, toyController, toyImageController, toyProviderController
- `com.jee.tp.serveruser.Exceptions`: FileStorageException, fileNotFoundException
- `com.jee.tp.serveruser.Models`: Address, Customer, Toy, toyImage, toyProvider
- `com.jee.tp.serveruser.Repositories`: addressRepository, customerLikesRepository, customerRepository, toyCustomRepository, toyCustomRepositoryImp, toyImageRepository, toyProviderRepository, toyRepository
- `com.jee.tp.serveruser.Services`: toyImageService
- `com.jee.tp.serveruser.payload`: uploadImageResponse
- Tests: 2 test classes

## How to run

Requirements: a JDK 11+ and Maven (or the included Maven wrapper).
Create the `toystoredb` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:9855`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
