# Go Rentals - Full Stack Microservices Project

This is a full-stack web application built using Spring Boot and Java for the backend and React for the frontend. The project follows a microservices architecture to provide a scalable and maintainable system.

## Architecture Overview

The system is divided into five microservices, each responsible for a specific area of functionality

- User Service - manages user registration, login, and profile management  
- Car Service - handles car inventory with create, read, update, delete, and filtering capabilities  
- Booking Service - enables users to make and manage bookings  
- Payment Service - processes payments and keeps track of transactions  
- Frontend Service - built using React, communicates with backend services using REST APIs  

## Technologies Used

- Backend - Spring Boot and Java  
- Frontend - React  
- Communication - REST APIs  
- Testing - Postman used to validate all API endpoints  
- Architecture - Microservices, each focusing on separate responsibilities  

## Features

- Full CRUD operations implemented in all microservices  
- User login validation through an action-based endpoint in User Service  
- Search and filtering supported in relevant services such as cars and bookings  
- APIs thoroughly tested with Postman to ensure reliability  

## Getting Started

To run this project locally, make sure you have Java, Spring Boot, Node.js and npm installed. Clone the repository and follow the setup instructions for each microservice and frontend.

## Testing

All REST endpoints were tested using Postman to confirm correct functionality, proper response codes, and data accuracy.

