# Practice 05

## Intro
Several goals for this practice:
* Create a SOA architecture in order to make 2 JEE apps communicate.
* You will reuse, once again, the core of PW03
* A webapp (war) will communicate with a shell app (jar)

## DB 
* Reuse the schema named `yncrea_pw03`
* We assume that your DB credentials are `root:root`

## pw05-server
Create a new Maven module called **pw05-server**. Its packaging is `war`

For this module, you have to declare, in the `pom.xml` file, the following dependencies.

|groupId   |artifactId      |  version | scope|
|----------|-------------|------|---|
| ${project.groupId} | pw05-core | ${project.version}||
| ${project.groupId} | pw05-contract | ${project.version}||
| javax.servlet | javax.servlet-api | 3.1.0 | provided |
| ch.qos.logback | logback-classic | 1.1.8 ||
| org.springframework | spring-webmvc | 4.2.9.RELEASE || 
| org.apache.cxf | cxf-rt-frontend-jaxws | 3.1.9 ||
| org.apache.cxf | cxf-rt-transports-http | 3.1.9 ||

## pw05-client
Create a new Maven module called **pw05-client**.

For this module, you have to declare, in the `pom.xml` file, the following dependencies.

|groupId   |artifactId      |  version | scope|
|----------|-------------|------|---|
| ${project.groupId} | pw05-contract | ${project.version}||
| ch.qos.logback | logback-classic | 1.1.8 ||
| org.springframework | spring-context | 4.2.9.RELEASE ||
| org.apache.cxf | cxf-rt-frontend-jaxws | 3.1.9 ||
| org.apache.cxf | cxf-rt-transports-http | 3.1.9 ||

## pw05-contract
Create a new Maven module called **pw05-contract**.

No dependency for this module.

Create 2 packages:
* `yncrea.pw05.contract.dto`
* `yncrea.pw05.contract.facade`

You will declare `StudentDTO`, a simple POJO with a lastname and a firstname attributes. Don't forget to add all the boilerplate (getters, setters, empty constructor, ...)

For the facade, declare a `StudentWS` interface, annotated with `@WebService`and defining 2 methods:
* `getAllStudents` which returns a collection of `StudentDTO`
* `saveStudent` which takes a `StudentDTO` parameter.

That's it for the contract, it is already finished!

## Back to the server
### The main service
In the `yncrea.pw05.web.service.impl`, create a new class `StudentWSImpl` which implements an interface you have to guess :P

Annotate this new class with `@Named("studentWS")` and `@WebService(endpointInterface = "yncrea.pw05.contract.facade.StudentWS")`

You now have to implement the methods of this service. The `StudentService` will help you because it provides all the necessary code to fetch the DB.

Be smart, the `StudentService` handles `Student` entities while your methods should handle DTO's! Write the translation between entities and DTO's.

### The Initializer
In `yncrea.pw05.web`, create an `Initializer` class inspired by the Initializer of PW04.
* an additional root config class should be declared : `WSConfig`
* No servlet config class
* Override the `onStartup` method
  * call the inherited `onStartup`
  * call the `addServlet` method on the `servletContext`
    * The new servlet is named `cxfServlet`
    * The new servlet is an implementation of `CXFServlet`
    * The new servlet will be mapped to the `/services/*` URL pattern
    
Here is a [tip](https://stackoverflow.com/questions/21244066/spring-javaconfig-add-mapping-for-custom-servlet)

### Configuration
In `yncrea.pw05.web.config` create `WSConfig`
* Add the usual configuration annotations to let Spring detect that it is a configuration class and to specify which package should be scanned.
* Add `@ImportResource` which will import the `classpath:META-INF/cxf/cxf.xml` file.
* Inject a CXF `Bus` bean and the `StudentWS` bean as well
* Declare a `Endpoint` bean
   * instanciate an `EndpointImpl` object with the two injected beans passed in the constructor.
   * its address will be `"/student"`
   * publish the bean
   
## Deployment
Deploy you webapp then test the `/services/` URL, you should see something magic!

## Back to the client
### Configuration
In `yncrea.pw05.client.config`  package, declare `AppConfig`. Guess its annotation ;)

Declare a bean of type `StudentWS`.
* Instanciates a `JaxWsProxyFactoryBean`
* its "service class" is the `StudentWS` one.
* its address is the adress of your student endpoint in the server (guess it!)
* call the `create method` of this object in order to get a generated implementation of `StudentWS`. Return this new implementation.

### The client app
In `yncrea.pw05.client`, create the `ClientApp` class.
It creates a Spring context, get the bean for `StudentWS` then list in the console all the students of the remote server.

Try to save a new student, you won't realize that there are network communication! It's SOAP magic!

 ## Logs
 A good developer write some logs ;)

