# Backend_Traini8_AmeyGhatale

Note : I have used MySQL database for storing all the data.

SETUP INSTRUCTIONS : 
1. Before running the application create a database called traini8 in MySQL.
2. You do not have to create tables as it will generate automatically.
3. I have implemented swagger for easy user implementation (swagger link : "http://localhost:8080/swagger-ui/index.html#/"), you can use postman also if you like.


FUNCTIONALITIES DEVELOPED : 

POST APIs :
1. Add Training Center : (Path = "http://localhost:8080/trainingCentre/addCenter")
2. You can directly add this JSON Format in PostMan or Swagger

   {
        "centerName": "Center 1",
        "centerCode": "123456789abc",
        "address": {
          "detailedAddress": "Panvel",
          "city": "Mumbai",
          "state": "Maharashtra",
          "pincode": "400001"
        },
        "studentCapacity": 4500,
        "coursesOffered": [
          "Java", "Spring Boot", "C++"
        ],
        "contactEmail": "center1@gmail.com",
        "contactPhone": "1234567890"
   }

GET APIs :
1. Get All Centers : (Path = "http://localhost:8080/trainingCentre/getAllCenters")
2. Get Centers By State : (Path = "http://localhost:8080/trainingCentre/getCenterByState")
3. Get Centers By City : (Path = "http://localhost:8080/trainingCentre/getCenterByCity")
