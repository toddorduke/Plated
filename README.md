# Plated

Plated is the backend REST API for a food-review social app, where users share posts about the dishes they eat at restaurants and like each other's posts. It is built with Java and Spring Boot using a layered architecture.

## Features

- Create a food post with the restaurant, dish, location, rating, note, and image URL
- Retrieve all posts or a single post by ID
- Like and unlike a post, with the like count updating automatically
- Data stored in an in-memory H2 database through Spring Data JPA

Here's the full section, ready to paste:

```markdown
## Testing

Unit tests cover the service layer and the controller layer.

### What's tested
**Service layer (`PostService`)**
- `toggleLike`: liking, unliking, and toggling twice (JUnit 5)
- `createPost`: resets likes and liked state, saves once (Mockito)
- `getAllPosts`: returns the posts from the repository (Mockito)
- `findById`: returns the post when found, throws `NoSuchElementException` when not found (Mockito)

**Controller layer (`PostController`)**
- `GET /api/posts`
- `GET /api/posts/{id}`
- `POST /api/posts`
- `PUT /api/posts/{id}/like`

### How it's tested
- Service tests fake the repository with Mockito, so no database is needed.
- Controller tests use `@WebMvcTest` and MockMvc, with the service faked using `@MockitoBean`.
- Tests check status codes, the JSON returned, and that the right service calls were made.

### Tools
- JUnit 5
- Mockito
- MockMvc (Spring Boot test)

### How to run
- From a terminal: `./mvnw test`
- From IntelliJ: right-click a test class and choose Run


## Tech Stack

- Java 17
- Spring Boot 4.1.0 (Spring Web MVC)
- Spring Data JPA
- H2 database (in-memory)
- JUnit 5 and Mockito for testing
- Maven (wrapper included)

## Architecture

The project follows a layered Controller / Service / Repository structure:

| Layer | Class | Responsibility |
| --- | --- | --- |
| Controller | `PostController` | Handles HTTP requests under `/api/posts` |
| Service | `PostService` | Business logic, including the like/unlike toggle |
| Repository | `PostRepository` | Database access through Spring Data JPA |
| Model | `Post` | JPA entity that represents a food post |

Dependencies are injected through constructors.

## API Endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/posts` | Get all posts |
| POST | `/api/posts` | Create a new post |
| GET | `/api/posts/{id}` | Get a post by ID |
| PUT | `/api/posts/{id}/like` | Toggle like on a post |

### Post fields

| Field | Type | Notes |
| --- | --- | --- |
| `id` | Long | Generated automatically |
| `restaurant` | String | Name of the restaurant |
| `dish` | String | Name of the dish |
| `location` | String | Where the restaurant is |
| `note` | String | The reviewer's comments |
| `rate` | long | Rating for the dish |
| `imgUrl` | String | Link to a photo of the dish |
| `ticketNo` | long | Ticket number |
| `likes` | int | Starts at 0 when a post is created |
| `liked` | boolean | Starts as false when a post is created |

### Example request

Create a post:

```bash
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{
    "restaurant": "Example Grill",
    "dish": "Smash burger",
    "location": "Atlanta, GA",
    "note": "Crispy edges and great sauce.",
    "rate": 5,
    "imgUrl": "https://example.com/burger.jpg"
  }'
```

Like a post:

```bash
curl -X PUT http://localhost:8080/api/posts/1/like
```

## Getting Started

### Prerequisites

- Java 17 or newer

### Run the application

```bash
git clone https://github.com/toddorduke/Plated.git
cd Plated
./mvnw spring-boot:run
```

On Windows, use `mvnw.cmd spring-boot:run`. The API runs at `http://localhost:8080`.

### Run the tests

```bash
./mvnw test
```

A Postman collection is included in the `postman` folder for trying out the endpoints.

## Future Improvements

- Add update and delete endpoints for full CRUD support
- Return a proper 404 response when a post is not found
- Add more unit and integration tests
- Build a frontend for the app

## Author

Todd "Duke" Graham | [GitHub](https://github.com/toddorduke)
