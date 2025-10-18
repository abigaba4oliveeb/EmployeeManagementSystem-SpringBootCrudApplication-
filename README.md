**Description of System**

This is a system where an Employer of a company can manage employees in a system by either viewing all, viewing details of a particular employee by id, adding a new employee, updating an existing employee and deleting any employee by id.
Within this system I have also used a Service layer which enables to deligate the work across different parts of a system through a single interface. The use of a service layer denoted by @service aligns well with the Software design pattern called Facade with which complexities of a system are hidden away from a user or client therefore making the system easy to use and fast processing.

**To get started**

1. Clone the project by git clone <repo-url>;
2. Within the project there is a .sql file with employee details to work with
3. Have mysql work bench on your local system to import that file and run execute the sql file with it to create the employee-directory database and employee table
4. Check for the connection details to database in application.properties within the resources folder in the cloned project.
5. Make sure your IDE is listening well to the mysql database,
6. Then run the spring boot application
7. All the different** CRUD** routes to run are in the rest controller.

   forexample **http://localhost:8080/api/employees**
