# JAVAEE POS System Backend

## API DOcumentation :

## JAVAEE POS System Frontend :
https://github.com/DilshanHF/POS_FrontEnd_JavaEE.git

## Description
This project is built using Jakarta EE for the backend, MySQL as the database, and AJAX (or Fetch API) for handling asynchronous communication between the client and server. The application leverages native SQL for database operations to ensure efficient query handling. Proper logging is implemented across the application, following best practices for logging levels to ensure maintainability and traceability.


## Tech Stack

* Jakarta EE: Provides a robust enterprise platform for developing web applications.
* MySQL: A widely used relational database management system.
* AJAX: For asynchronous communication between the client and server.
* JNDI: Used for database configuration to keep database connections manageable and secure.


## Features

JNDI-based database configuration. AJAX/Fetch API for dynamic content loading. Comprehensive logging strategy with appropriate logging levels.

## Set Up & Installation

* Clone the repository: git clone https://github.com/DilshanHF/BackEnd_PosSystem_JavaEE.git
* Configure the Database: Set up your MySQL database.
* Update the JNDI configuration in your application server's context file to point to your MySQL database.
* Build & Deploy: Build the project using your preferred Jakarta EE tool (e.g., Maven). Deploy the application to your Jakarta EE application server (e.g., Tomcat).
* Access the Application: Once deployed, access the frontend application via your web browser.
* Frontend : https://github.com/DilshanHF/POS_FrontEnd_JavaEE.git


## Logging Configuration
* INFO: General application flow.
* DEBUG: Detailed debugging information.
* ERROR: Error events of considerable importance that might still allow the application to continue running.
* WARN: Potentially harmful situations.

