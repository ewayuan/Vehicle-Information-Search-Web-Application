# cs348-project

Backend Setup:
1. Clone the project from github: https://github.com/ewayuan/cs348-vehicle-info
2. Make sure Eclipse is installed on you computer
3. install Sping Tools 4 by using Eclipse Marketplace
4. import the project as a maven project
5. run Maven Install for the project
6. run the Project as a Springboot Boot App

Frontend Setup:
7. the front end in on: localhost:8080/html/logIn.html 

   username: x558li 

   password: nancy

(Optional) Database setup:
hostname: 35.222.149.109
user: root
password: 348



## 1. How to generate the “production” dataset and load it into your database. 
####Sample dataset: 
select part of data from production dataset and insert them to test database manually.

####Production dataset: 

download the open source vehicle data and preprocess the useful attributes, such as Year, Model, Make and fuel consumption to database. Find vehicles’ official information from authorized parties like governments, academic  organizations, etc. Our team is also responsible for filtering the data, as only some particular information is needed. For example, we need to delete repeated rows, and useless attributes in the table we obtained.
Data source:

1. Fuel Consumption ratings (https://open.canada.ca/data/en/dataset/98f1a129-f628-4ce4-b24d-6f16bf24dd64)
2. Car Picture Dataset:
   (https://ai.stanford.edu/~jkrause/cars/car_dataset.html)

####Preprocess of Fuel Consumption Ratings:
There are more than desired columns in this dataset than our application supports.  For current features, only Make, Model, Year, Combined_consumptions are needed.  We only use this subset of the whole dataset for production.

####Preprocess of Picture Dataset:
There are two files ”cars_train_annos.mat” for annotation of each picture, and “cars_meat.mat” including pictures of cars.  Each annotation can be scraped into Make, Model and Year of each car corresponding to attributes of the relation VehicleInfo.


#### Upload data to database:
   We use MySQL database supported on GCP: 
 -	To upload data into database:
 -	Download the xlsx file from the link.
 -	Upload the xlsx file to Cloud SQL bucket.
 -	Import data in data bucket to MySQL instance through Import API provided by GCP.



## 2. The features have been implemented
### a. User Login
- cs348-vehicleinfo/cs348_fullstack_work/src/main/java/org/Info/Vehicle/controller/UserController.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/UserDao.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/UserDaoImpl.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/service/UserService.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/webapp/html/logIn.html
### b. User Register
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/controller/UserController.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/UserDao.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/UserDaoImpl.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/service/UserService.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/webapp/html/sighUp.html
### c. Delete user account
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/controller/UserController.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/UserDao.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/UserDaoImpl.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/service/UserService.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/webapp/html/search.html
### d. Search Bar
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/service/VehicleInfoService.java

- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/model/VehicleInfo.java
-  cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/VehicleInfoDao.java

- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/VehicleInfoDaoImpl.java

- cs348-vehicle-info/cs348_fullstack_work/src/main/webapp/html/search.html
### e. Search Bar results
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/service/VehicleInfoService.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/model/VehicleInfo.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/VehicleInfoDao.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/java/org/Info/Vehicle/dao/VehicleInfoDaoImpl.java
- cs348-vehicle-info/cs348_fullstack_work/src/main/webapp/html/search.html