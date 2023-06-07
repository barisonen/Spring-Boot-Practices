# Json Subtypes

Maps VehicleDto to CarDto or PlaneDto for given vehicleType. <br/><br/>
Requests In order:<br/><br/>

GET: http://localhost:8080/api/get-vehicles <br/><br/>

POST: http://localhost:8080/api/add-vehicle <br/>
with body: {
"vehicleType": "PLANE",
"brand": "Airbus",
"numberOfWings": 4
} <br/><br/>

POST: http://localhost:8080/api/add-vehicle <br/>
with body: {
"vehicleType": "CAR",
"brand": "Mercedes Benz",
"numberOfDoors": 6
} <br/><br/>

GET: http://localhost:8080/api/get-vehicles <br/><br/>