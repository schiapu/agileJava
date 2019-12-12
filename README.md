# agileJava

Backend built using [Spring]
Frontend built with [AngularJS]

In order to generate a local exceutable you'll need to run the following commands from within the agileJava folder:
```sh
$ mvn clean package spring-boot:repackage
```
This will clean and repackage the project into a jar on the target folder.

```sh
$ java -jar target/agileJava-0.0.1-SNAPSHOT.jar
```
This will excute the jar and set up the website on http://localhost:8080/

#### API Example for CREDIT/DEBIT operations:
```sh
$ curl -X POST \
  http://localhost:8080/transaction/ \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 61d53538-3155-4335-8a95-e2eb23db6073' \
  -H 'cache-control: no-cache' \
  -d '{
	"amount":"300",
	"type":"CREDIT"
}'
```

- The amount variable determines the value of the transaction
- The type variable can be DEBIT or CREDIT, which determines the type of transaction


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [AngularJS]: <http://angularjs.org>
   [Spring]: <https://spring.io/>
