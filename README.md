# Library-API

###

<div>
  <img src="https://cdn.simpleicons.org/spring/6DB33F" height="40" alt="spring logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo"  />
  <img width="12" />
  <img src="https://cdn.simpleicons.org/docker/2496ED" height="40" alt="docker logo"  />
</div>

###

## 🖥️About the Project

The project is a study on creating APIs using Java and Spring. An example library was used, where the software needs to 
handle the creation, manipulation, and deletion of the User, Book, and Loan classes. The main goal is to create a functional 
backend that adapts to various business rules as needed.

## ⚙️Functionalities

<p>All the classes will represent tables in our database, so we have created classes to manipulate the data in those table, 
specifically Repository and Service.</p>
<p>The classes also need DTO classes, to avoid access the entity directly.</p> 

### User:
- The User class can receive the user's name and email, and also create a UUID (Universal Unique Identifier) for the User.
- User will be used for Loan.

### Book:
- The Book class can receive the book's name, author, publisher and if he is avaliable, and also create a UUID for the Book.
- Book will be used for Loan.

### Loan:
- The Loan class is the main part of this system.
- It receives the User and the Book IDs.
- Loan also stores the loan date.
- It calculates the return date, wich in that case was 7 days after loan date.
- The loan update will store the actual return date of the loan.

## 💻Technologies

The technologies used were:
- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [Docker](https://www.docker.com)
- [MySQL](https://www.mysql.com)

## 🛠️Instalation

1. Clone repository:
````git bash
git clone https://github.com/devMarceloCimadon/Library-API.git
````
2. Install dependencies with Maven.
3. Start Docker application:
````yaml
docker compose up
````

## 🔧Usage

1. Start dependencies with Maven.
2. The API will be acessible at http://localhost:8080

## 🌐API Endpoints

All the paths from API starts with:` /api `

### User:
| **Actions**       | **Type** | **Path**        |
|-------------------|----------|-----------------|
| Create User       | Post     | /users          |
| List Users        | Get      | /users          |
| Get User By ID    | Get      | /users/{userId} |
| Update User By ID | Put      | /users/{userId} |
| Delete User By ID | Delete   | /users/{userId} |

- Create User body:
````json
{
  "name" : "Example Name",
  "email" : "email@example.com"
}
````

- Update User body:
````json
{
  "email" : "otheremail@example.com"
}
````

### Book:
| **Actions**       | **Type** | **Path**        |
|-------------------|----------|-----------------|
| Create Book       | Post     | /books          |
| List Books        | Get      | /books          |
| Get Book By ID    | Get      | /books/{bookId} |
| Delete Book By ID | Delete   | /books/{bookId} |

- Create Book body:
````json
{
  "name" : "Book name example",
  "author" : "Name example",
  "publisher" : "Enterprise example"
}
````

### Loan:
| **Actions**       | **Type** | **Path**        |
|-------------------|----------|-----------------|
| Create Loan       | Post     | /loans          |
| List Loans        | Get      | /loans          |
| Get Loan By ID    | Get      | /loans/{loanId} |
| Update Loan By ID | Put      | /loans/{loanId} |
| Delete Loan By ID | Delete   | /loans/{loanId} |

- Create Loan body:
````json
{
  "userId" : "{userId}",
  "bookId" : "{bookId}"
}
````

- Update don't need a body, because it only updates the return date.

## ☝️🤓Author

Developed by [Marcelo Cimadon](https://github.com/devMarceloCimadon)
