# Fitness Tracking Application

Fitness Tracking Application is a web application that allows users to track their workouts, daily macros, and calories. Users can create an account, log in, and utilize various features to monitor their fitness progress.

## Features

- User Registration: Users can create an account by providing their details such as name, email, and password.
- Authentication and Authorization: JWT-based authentication is implemented to secure user access. HttpOnly cookies are used to store the JWT token for enhanced security.
- Role-Based Access Control: Two roles are defined: Admin and User. Admins have additional privileges such as adding new products to the system and managing user accounts.
- Workout Tracking: Users can track their workouts by recording the intensity, burned calories, and exercise type.
- Daily Macros and Calorie Tracking: Users can monitor their daily macros and calorie intake to maintain a healthy diet.
- Food Catalog: Users can search for food items and add them to their daily food catalog, enabling them to track their nutrition accurately.
- Product Management: Admins have the ability to add new products to the system, ensuring a comprehensive food catalog for users.

## Technologies Used

The project is built using the following technologies:

- Spring Boot: Provides the foundation for developing the application.
- Spring Security: Ensures secure authentication and authorization using JWT tokens stored in HttpOnly cookies.
- Spring Data: Simplifies database interactions with MongoDB.
- MongoDB: A NoSQL database used for storing user accounts, workouts, and food items.
- Docker: Used to containerize the MongoDB database for easy deployment and scalability.
- Hibernate: An Object-Relational Mapping (ORM) framework for managing the database entities.


## API Endpoints

The application exposes the following RESTful API endpoints:

- `/api/register` - Register a new user account.
- `/api/login` - User login to obtain JWT token.
- `/api/workouts` - CRUD operations for managing workouts.
- `/api/foods` - CRUD operations for managing food items.
- `/api/admin/users` - Admin-only endpoint for managing user accounts.
- `/api/admin/products` - Admin-only endpoint for managing products.

