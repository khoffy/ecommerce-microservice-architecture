### LIST OF PRODUCTS
http://localhost:9001/produits    

### LIST OF PRODUCTS | SHIPPINGS THROUGH API GATEWAY
http://localhost:9103/microservice-produits/produits
http://localhost:9103/microservice-shippings/shippings

### LIST OF PRODUCTS THROUGH CLIENT-UI (and API GATEWAY)
http://locahost:8080

### EUREKA DASHBOARD
http://localhost:8761

# Documentation page for security API
http://localhost:8080/swagger-ui.html

# Documentation page for ADS Dental Surgeries API
http://localhost:8081/swagger-ui.html

# I implemented temporary an in-memory process with the following dummy data - update underway
username    | password | role
admin       | 1234     | ADMIN
customer    | 1234     | USER


#### PROCESS TO ACCESS AN ENDPOINT (check the docs folder to get Postman's usage)
Generate the jwt token from http://localhost:8081/token
parameters:
- username (string)
- password (string)
- withRefreshToken (boolean)    # allows to generate besides the jwt token, a refresh token
- grantType (string)            # password/refreshToken