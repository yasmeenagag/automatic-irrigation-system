# Automatic-irrigation-system


## About the project 
This is a mini project for automatic irrgation system for land based on some configuration like soil type, agricultural crop, and time solts
<br/><br/>
## Technology used
Ppring boot application and in memory database h2 (contains preloaded data presented into /resources/data.sql <br/>
 <br/>
 
### Prerequisites<br/>
1- Install java 8<br/>
2- install maven to your local machine<br/><br/>

## Provided apis <br/>
1- create land<br/>
2- get all land and land details <br/>
3- update land <br/>
4- configure land<br/>
<br/>

 ## build project<br/>
 1- clone the project to your local machine or just download the jar and run it using java -jar "path to jar" <br/>
 2- if cloned the project use "mvn clean install" to create the package <br/>
 3- the package is expected to be target folder inside the application<br/>
 

## Running the application<br/>
After successful build for each project should run each jar " located in trget folder for each project " using java -jar "path_to_jar"

## Automatic scheduler to get the sensor device and alert if the sensor is not available after pre configured number of retrials 
once the sensor is available, automaict irrigation service wiil retrieve the lands that need to be irrgated on this time slot 

for simplisity there are 2 available slot for irrigation morning and evening  

## Testing
for simplisity please use the postman collection irrigation-system.postman_collection.json <br/>
