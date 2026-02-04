# Documentation (with Live Deployment Link)

  # Live Application URL
https://bookapi-1-7avc.onrender.com


The application is deployed and publicly accessible at the above URL.

# API Endpoints

# Add a Book

POST /api/book/save

        Description:
        Creates a new book and stores it in memory.
        
         Example:
        
        POST https://bookapi-1-7avc.onrender.com/api/book/save
        
        
        Request Body (JSON):
        
        {
        "name": "Clean Code",
        "author": "Robert C. Martin",
        "genre": "Programming",
        "description": "A handbook of agile software craftsmanship"
        }


        Responses:
        
        201 CREATED → Book added successfully
        
        400 BAD REQUEST → Validation failure

# Get Book by ID

GET /api/book/{id}

        Description:
        Fetches a book by its unique ID.
        
        Full URL Example:
        
        GET https://bookapi-1-7avc.onrender.com/api/book/1


        Responses:
        
        200 OK → Book found
        
        404 NOT FOUND → Book does not exist

# Important Implementation Details

This is a Spring Boot RESTful backend application

Data is stored in memory using an ArrayList

Book IDs are auto-generated

DTOs are used for request/response separation

Input validation is implemented using Jakarta Validation

Exception handling is centralized using @RestControllerAdvice

# Note
Since the application uses in-memory storage, all data will be reset if the application restarts.