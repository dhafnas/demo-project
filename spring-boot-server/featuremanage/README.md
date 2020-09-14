# spring-boot-server
The purpose of the project is to develop open source, scalable, and loosely coupled application to handle customers 'feature-requests'. The client request will be processed by spring rest API. Two API is available to create and retrieve 'feature request'.
## Build an executable JAR
You can run the application from the command line with Gradle or Maven. You can also build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that. Building an executable jar makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

If you use Gradle, you can run the application by using ./gradlew bootRun. Alternatively, you can build the JAR file by using ./gradlew build and then run the JAR file, as follows:

```sh

java -jar build/libs/featuremanage-0.0.1-SNAPSHOT.jar

```
## Test the Service
-  Get API: To get all feature-requests available in the system.
 Example,
 
 ```sh
$ curl -v localhost:8080/demo/v1/feature/requests
 ```
response will be 

```sh
[
      {
      "id": 0,
      "title": "Feature 1",
      "description": "Feature 1 Description",
      "client": "Client 2",
      "priority": 2,
      "targetDate": "2020-01-02",
      "productArea": "Billing"
   }
]
```
- Post API: To create new feature-request in the system, example

```sh
$ curl -X POST localhost:8080/demo/v1/feature/requests -H 'Content-type:application/json' -d '{"title": "Feature 2","description":"Feature 2 Description","client": "Client 1","priority":"targetDate": "2020-02-03","productArea": "Reports"'}
```
response will be 

```sh
{
      "id": 1,
      "title": "Feature 2",
      "description": "Feature 2 Description",
      "client": "Client 1",
      "priority": 1,
      "targetDate": "2020-02-03",
      "productArea": "Reports"
}
```
