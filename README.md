# Muzix - A Capsule Case Study

## Problem Statement

Build a system to search for music, show list of music titles, bookmark music, create playlists and show recommended music to a user.

## Requirements:
1. The application needs to fetch music details from https://www.last.fm/api or https://developer.napster.com/
2. A frontend where the user can search, view, play music, bookmark it and should be able to create multiple playlist out of it.
3. A recommendation system should be able to recommend with similar music to the user based on the music played and playlist created.
4. An option to view recommended players should be available on frontend. 

## Microservices:
1. AccountManager - Should be able to manage user accounts
2. MuzixUI -
  - 1. User should be able to
      - search music
      - bookmark music
      - create playlists
      - should be able to see bookmarked music and playlists created by him
      - should be able to see recommended music
  - 2. UI should be responsive which can run smoothly on various devices.
3. MuzixManager - should be able to store all his
  - bookmarks
  - playlists
  - searches
4. MuzixRecommenderSystem - Based on the music bookmarked and playlisted, it should be able to recommend new music to the user

## Modules Required:
- Spring Boot
- MySQL, MongoDB
- API Gateway
- Eureka Server
- Message Broker (RabbitMQ)
- Angular
- CI (Gitlab Runner)
- Docker, Docker Compose


## Flow of Modules

### Building Frontend:
  1. Building Responsive Views:
    - Build a View to show all music
      - 1. Music - Populating from external api
      - 2. Recommended Music - Populating from MuzixRecommenderSystem
      - 3. Build a view to show created playlist
      - 4. A view to authenticate users
  2. Using Services to populate these data in views
  3. Stitching these views using Routes and Guards
  4. Making the UI responsive
  5. E2E and unit tests
  6. Write CI configuration file
  7. Dockerize the frontend

### Building the Account Manager
  1. Creating a server in Spring Boot to facilitate registration and login using JWT token and MySQL
  2. Writing Swagger Documentation
  3. Unit Testing
  4. Write CI Configuration
  5. Dockerize the application
  6. Write docker-compose file to build both frontend and backend application
  
### Create an API Gateway which can serve UI and API Request from same host

### Building the Muzix Manager
  1. Building a server in Spring Boot to facilitate CRUD operation over music, playlist and bookmarked resources stored in MongoDB
  2. Writing Swagger Documentation
  3. Build a Producer for RabbitMQ which:
      - Produces events like what user bookmarked
      - What music he added in playlists
  4. Write Test Cases
  5. Write CI Configuration
  6. Dockerize the application
  7. Update the docker-compose

### Building a MuzixRecommenderSystem
  1. Building a Consumer for RabbitMQ:
      - On a new event generated Update the recommendations in the system
  2. Build an API to get Recommendations
  3. Writing Swagger Documentation
  4. Write Test Cases
  5. Write CI Configuration
  6. Dockerize the application
  7. Update the docker-compose
  8. Update the API Gateway

### Demonstrate the entire application