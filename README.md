# Library Spring Application

## Описание

Это Spring Boot приложение для управления библиотекой. Оно предоставляет REST API для работы с авторами и книгами.

## Зависимости

- **Spring Boot**: Основной фреймворк для создания приложения.
- **Spring Data JPA**: Для работы с базой данных.
- **PostgreSQL**: СУБД для хранения данных.
- **Liquibase**: Для управления версиями базы данных и миграциями.
- **Springdoc OpenAPI**: Для автоматической генерации документации API с использованием Swagger.
- **Lombok**: Для сокращения шаблонного кода (getter/setter и т.д.).
- **Validation API**: Для валидации данных.

## Конфигурация

### Приложение

- **Datasource**:
    - URL: `jdbc:postgresql://localhost:5432/Project`
    - Username: `postgres`
    - Password: `mina1a2a3a`

- **JPA**:
    - `ddl-auto`: `none` (не изменять схему базы данных автоматически)

- **Liquibase**:
    - Включен

- **Swagger**:
    - Путь для Swagger UI: `/swagger-ui.html`
    - Путь для API документации: `/v3/api-docs`

## Запуск приложения

1. Убедитесь, что PostgreSQL запущен и база данных `Project` создана.
2. Убедитесь, что все зависимости установлены.
3. Запустите приложение с помощью командной строки:
   ```bash
   ./mvnw spring-boot:run





### 8. Подготовка коллекции запросов для проверки REST API в Postman

1. **Создайте новую коллекцию в Postman**:
    - Откройте Postman и создайте новую коллекцию (например, назовите её `Library API`).

2. **Добавьте запросы в коллекцию**:

    - **POST** `/createAuthor`
        - **URL**: `http://localhost:8080/createAuthor`
        - **Method**: POST
        - **Body**: JSON (raw)
      ```json
      {
        "name": "Author Name",
        "biography": "Author Biography"
      }
      ```

    - **GET** `/getAuthor/{id}`
        - **URL**: `http://localhost:8080/getAuthor/{id}`
        - **Method**: GET

    - **DELETE** `/deleteAuthor/{id}`
        - **URL**: `http://localhost:8080/deleteAuthor/{id}`
        - **Method**: DELETE

    - **PUT** `/updateAuthorDescription/{id}`
        - **URL**: `http://localhost:8080/updateAuthorDescription/{id}?newDescription=New Description`
        - **Method**: PUT

    - **POST** `/createBook`
        - **URL**: `http://localhost:8080/createBook`
        - **Method**: POST
        - **Body**: JSON (raw)
      ```json
      {
        "title": "Book Title",
        "description": "Book Description",
        "author": {
          "id": 1
        },
        "amountOfReads": 10,
        "addingTime": "2024-07-18T10:00:00Z",
        "imageURL": "http://example.com/image.jpg",
        "text": "Book Text"
      }
      ```

    - **GET** `/getBookById/{bookId}`
        - **URL**: `http://localhost:8080/getBookById/{bookId}`
        - **Method**: GET

    - **DELETE** `/deleteBook/{bookId}`
        - **URL**: `http://localhost:8080/deleteBook/{bookId}`
        - **Method**: DELETE

    - **GET** `/getTextOfBook/{bookId}`
        - **URL**: `http://localhost:8080/getTextOfBook/{bookId}`
        - **Method**: GET

    - **PUT** `/updateBookText/{bookId}`
        - **URL**: `http://localhost:8080/updateBookText/{bookId}`
        - **Method**: PUT
        - **Body**: Text (raw)
      ```text
      Updated Book Text
      ```

    - **GET** `/getBooksByAuthor/{authorId}`
        - **URL**: `http://localhost:8080/getBooksByAuthor/{authorId}`
        - **Method**: GET

3. **Сохраните коллекцию и запросы**.

Эти шаги помогут вам документировать и протестировать ваш REST API. Удачи с проектом!
