# Expense Reimbursement API
This is a REST API for an expense reimbursement system.   

#Technologies Used
<img src=https://seeklogo.com/images/J/java-logo-7F8B35BAB3-seeklogo.com.png width="60">  <img src="https://spring-petclinic.github.io/images/logo-spring.png" width="60"> <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/1985px-Postgresql_elephant.svg.png" width="60"> <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Amazon_Web_Services_Logo.svg/768px-Amazon_Web_Services_Logo.svg.png?20170912170050" width="60">

## Routes

### Employee Routes
- POST /employees
    - returns a 201
- GET /employees
- GET /employees/120
    - returns a 404 if employee not found
- PUT /employees/150
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
- PUT /expenses/15
    - returns a 404 if expense not found
- PATCH /expenses/20/approve
    - returns a 404 if expense not found
- PATCH /expenses/20/deny
    - returns a 404 if expense not found
- DELETE /expenses/19
    - returns a 404 if car not found
- GET /employees/120/expenses
    - returns expenses for employee 120
- POST /employees/120/expenses
    - adds an expense to employee 120