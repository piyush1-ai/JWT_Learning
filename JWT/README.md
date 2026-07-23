JWT Authentication with Spring Security

A backend demo showing stateless JWT-based authentication and role-based access control using Spring Boot and Spring Security.

Features
Stateless authentication using JSON Web Tokens (jjwt)
Custom JwtAuthenticationFilter that validates the Authorization: Bearer <token> header on every request
Role-based access control (USER vs ADMIN) via Spring Security's authorization rules
Passwords hashed with BCrypt
SecurityFilterChain configuration (no WebSecurityConfigurerAdapter)
Tech Stack
Java 17
Spring Boot
Spring Security
jjwt 0.12.x
Maven
Project Structure
src/main/java/com/cfs/JWT/
├── Config/SecurityConfig.java        # security rules, in-memory users, beans
├── controller/
│   ├── AuthController.java           # POST /api/auth/login
│   ├── PublicController.java         # open endpoints
│   ├── UserController.java           # USER-role endpoints
│   └── AdminController.java          # ADMIN-role endpoints
├── Dto/LoginRequest.java             # login request payload
├── filter/JwtAuthenticationFilter.java  # validates JWT per request
└── service/JwtService.java           # generate/parse/validate tokens
Endpoints
Method	Endpoint	Access
GET	/api/public/Hello	Public
GET	/api/public/info	Public
POST	/api/auth/login	Public
GET	/api/user/test	Authenticated
GET	/api/user/info	Authenticated
GET	/api/admin/dashboard	ADMIN role
GET	/api/admin/user	ADMIN role
Getting Started
1. Clone the repo
   bash
   git clone https://github.com/piyush1-ai/JWT_Learning.git
   cd JWT_Learning
2. Configure the JWT secret

Set an environment variable (recommended) or edit src/main/resources/application.properties directly.

The key must be at least 256 bits (32+ characters) for HMAC-SHA256:

bash
# generate a secure random key
openssl rand -base64 32
properties
jwt.secret=${JWT_SECRET:your-generated-key-here}
jwt.expiration=3600000
3. Run the app
   bash
   ./mvnw spring-boot:run
4. Test login

Default in-memory users:

Username	Password	Role
root	root	USER
admin	admin	ADMIN, USER
bash
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"admin","password":"admin"}'

Use the returned token in subsequent requests:

bash
curl http://localhost:8080/api/admin/dashboard \
-H "Authorization: Bearer <token>"
What I Learned

This project was built to understand Spring Security's filter chain, stateless authentication with JWTs, and how to implement role-based authorization cleanly without session state.