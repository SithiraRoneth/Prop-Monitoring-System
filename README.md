# Prop Monitorin System

This is a comprehensive prop monitoring system developed using Spring Boot.The system provides functionalities for managing fields, crops, staff, monitoring logs, vehicles, and equipment. It incorporates JWT-based authentication and authorization to secure access to different roles.

## Features
* User Roles: MANAGER, ADMINISTRATIVE, and SCIENTIST with different levels of access to data.
* CRUD Operations: Allows creation, reading, updating, and deletion of data for crops, fields, staff, vehicles, and equipment.
* Data Analysis: Supports relational, spatial, and temporal analysis of crop and non-crop data.
* Field Management: Manage fields allocated for cultivation.
* Crop Management: Handle crop types, growth stages, and observations.
* Staff Management: Assign human resources to fields and operations.
* Log Monitoring: Track observations and activities related to crop growth.
* Vehicle Management: Allocate vehicles to staff for monitoring and operations.
* Equipment Management: Oversee agricultural equipment usage.

## Technologies Used
- Spring Boot: Backend framework for the system.
- JWT (JSON Web Tokens): For user authentication and role-based access control.
- JPA/Hibernate: To manage relational data in the database.
- Spring Security: To handle authentication and authorization.
- MySQL/PostgreSQL: Database for storing the data.
- Lombok: To reduce boilerplate code for model classes.
- Spring Data JPA: To simplify database operations.
- Spring Web: To expose RESTful APIs.

## Setup & Installation
 ### Prerequisites
 - Java 21 
 - Maven or Gradle 
 - MySQL or PostgreSQL Database

### Clone the Repository
 - Back End : https://github.com/SithiraRoneth/Prop-Monitoring-System.git
 - Front End : https://github.com/SithiraRoneth/PropMonitoring-FE.git
### License
This project is licensed under the MIT License - see the LICENSE file for details.
