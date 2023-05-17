# Welcome to the README file!

## Java Servlet CRUD Web Application_workshop

This is a simple CRUD (Create, Read, Update, Delete) web application built with Java Servlets. It's designed to manage
user data, offering functionalities such as listing all users, viewing individual user information, editing user data,
adding new users with frontend form validation, and deleting selected users.

## Technologies Used

- Java Servlets
- MySQL Database
- Docker
- Bootstrap SB Admin theme

## Getting Started

These instructions will get you a copy of the project up and running on
your local machine for development and testing purposes.

### Prerequisites

- Java JDK 8 or higher
- Docker
- Docker Compose
- MySQL Connector/J

### Installation

1. Clone the repository:

```bash
git clone https://github.com/bewpage/workshop-3
```

2. Navigate to the project directory:

```bash
cd your_project
```

3. Run Docker Compose to set up the MySQL database:

navigate to `db-docker` directory and run the following command:

```bash
docker-compose up -d
```

This will start a MySQL server on port 3306. The server will be populated with a database
and tables defined in the `schema.sql` file.

4. Configure your database connection in the `DBConnection.java` file. Remember to use the same username, password, and
   database name `workshop3` as specified in the docker-compose.

5. Run your application on a server of your choice (Tomcat, Jetty, etc.)

### Usage

- **User List:** Access the page `http://localhost:8080/user/list` to view the list of users.
- **View User:** Click the show button on the user list to view their information.
- **Edit User:** Click the edit button on the user list to modify a user's information. Make the necessary changes and
  click the `Save changes` button.
- **Add User:** Navigate to the page `http://localhost:8080/user/add`. Fill out the form and click the add button.
  Frontend form validation is implemented to ensure the data's correctness.
- **Delete User:** Click the delete button on the user list to remove a user from the database.

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/your_username/your_contributing.md) for details on our code of
conduct, and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.