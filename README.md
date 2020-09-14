
# Demo-project
The purpose of the project is to develop open source, scalable, and loosely coupled application to handle customers 'feature-requests'. This has two part,ie.
- angularapp(front-end app)
- spring-boot-server(backend-server)

## Angular App
The UI part of the application build using Angular 8 developed by Google , One of the most used library available in the market.[click here ](https://github.com/dhafnas/demo-project/blob/master/angularapp/feature-management-app/README.md)to view instruction to start the application

Currently two screen are available in the app. [Click](https://github.com/dhafnas/demo-project/tree/master/screenshots) to view screenshot

## spring-boot-server
The client request will be processed by spring rest API. Two API is available to create and retrieve 'feature request'.
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
[click here](https://github.com/dhafnas/demo-project/tree/master/spring-boot-server/featuremanage) to see server setup related documentation