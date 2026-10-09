# Online Cab Booking System (Basic)
Spring Boot + MySQL + React (Vite)

## Run
1. Install JDK 17, Maven, MySQL, Node.js.
2. Backend: edit `backend/src/main/resources/application.properties` (set your MySQL password), then:
   `cd backend && mvn spring-boot:run`  (http://localhost:8080; database and tables are created automatically)
3. Frontend: `cd frontend && npm install && npm run dev`  (http://localhost:5173)

## Default admin
admin@cab.com / admin123

## Flow to test
1. Register a Passenger and a Driver.
2. Passenger logs in and books a cab (PENDING).
3. Driver logs in, accepts (ACCEPTED), then completes (COMPLETED).
4. Passenger can cancel before completion.
5. Admin sees all bookings.

## API
POST /api/auth/register, POST /api/auth/login
POST /api/bookings, GET /api/bookings, GET /api/bookings/pending
GET /api/bookings/user/{id}, GET /api/bookings/driver/{id}
PUT /api/bookings/{id}/cancel, PUT /api/bookings/{id}/accept?driverId=, PUT /api/bookings/{id}/complete
GET /api/admin/stats
