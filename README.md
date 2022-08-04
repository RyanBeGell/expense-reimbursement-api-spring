# Expense Reimbursement API
This is a REST API for an expense reimbursement system.   

# Technologies Used
<img src=https://seeklogo.com/images/J/java-logo-7F8B35BAB3-seeklogo.com.png alt="Java logo" width="60">  <img src="https://spring.io/images/spring-initializr-4291cc0115eb104348717b82161a81de.svg" alt="Spring logo" width="60"> <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/1985px-Postgresql_elephant.svg.png" alt="PostgreSQL logo" width="60"> <img src="https://code.benco.io/icon-collection/logos/docker-whale.svg" alt="PostgreSQL logo" height="80" width="80"> <img src="https://i.imgur.com/o4WReCd.png" alt="AWS EC2 LOGO" width="65"> <img src="https://i.imgur.com/AJEdGsf.png" alt="AWS RDS logo" width="65">

## Routes

### Employee Routes
- POST /employees
    - returns a 201
- GET /employees
- GET /employees/120
    - returns a 404 if employee not found
- DELETE /employees/190
    - returns a 404 if employee not found

### Expenses routes
- POST /expenses
    - returns a 201
- GET /expenses
- GET /expenses?status=pending
    - also can get status approved or denied
- GET /expenses/12
    - returns a 404 if expense not found
- PATCH /expenses/20/approve
    - returns a 404 if expense not found
    - returns a 400 if already approved/denied
- PATCH /expenses/20/deny
    - returns a 404 if expense not found
    - returns a 400 if already approved/denied
- DELETE /expenses/19
    - returns a 404 if car not found
    - returns a 400 if already approved/denied
- GET /employees/120/expenses
    - returns expenses for employee 120