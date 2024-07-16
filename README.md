# Library Management System

## Overview

This Library Management System is my first attempt at learning Spring Boot. Implemented following a comprehensive [blog post](https://ithelp.ithome.com.tw/articles/10339298), it incorporates controller, service, and DAO layers. 
The system provides essential CRUD (Create, Read, Update, Delete) operations for managing books in a library. 
The system utilizes MySQL as the relational database and exposes RESTful APIs to interact seamlessly with book records.

## Database Table Design

The `book` table schema is defined as follows:

```sql
CREATE TABLE book
(
    book_id            INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title              VARCHAR(128) NOT NULL,
    author             VARCHAR(32)  NOT NULL,
    image_url          VARCHAR(256) NOT NULL,
    price              INT          NOT NULL,
    published_date     TIMESTAMP    NOT NULL,
    created_date       TIMESTAMP    NOT NULL,
    last_modified_date TIMESTAMP    NOT NULL
);
```
## CRUD Operations
### Retrieve a Book
- Endpoint: GET /books/{bookId}
- Description: Retrieve details of a book by its ID.
- Response: Returns the book details if found, otherwise returns a 404 status.
  
  ![Retrieve a Book](https://github.com/user-attachments/assets/f52af150-ff8e-48de-8b3e-f2650bd50acd)

### Create a Book
- Endpoint: POST /books
- Description: Create a new book record.
- Request Body: Includes title, author, image URL, price, and published date.
- Response: Returns the created book with a 201 status.

  ![image](https://github.com/user-attachments/assets/cf680556-e613-4b55-91a4-4ba4d249c326)
 
### Update a Book
- Endpoint: PUT /books/{bookId}
- Description: Update an existing book record by its ID.
- Request Body: Includes updated title, author, image URL, price, and published date.
- Response: Returns the updated book details if the book is found, otherwise returns a 404 status.

  ![image](https://github.com/user-attachments/assets/be5645a0-05f8-46c3-9d3f-aaa26aa40011)
  
### Delete a Book
- Endpoint: DELETE /books/{bookId}
- Description: Delete a book record by its ID.
- Response: Returns a 204 status if the book is successfully deleted.

  ![image](https://github.com/user-attachments/assets/4fe9bc9f-2e71-4886-9c89-c8a7219a1c24)

## API Testing
To test the CRUD functionalities, use tools like Postman or any API testing tool with the following endpoints:

- Retrieve a Book: GET /books/{bookId}
- Create a Book: POST /books
- Update a Book: PUT /books/{bookId}
- Delete a Book: DELETE /books/{bookId}
