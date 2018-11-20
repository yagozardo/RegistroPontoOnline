![Logo](https://github.com/mgoalves/RegistroPontoOnline/blob/master/src/main/resources/static/img/logo/logo_pontu_145x48.png)
# Developer's Guide
Nowadays, there are many solutions for digital time card management in the market, but there is a lack of a better solution for micro and medium-sized companies located in the region of Goiânia area.

Pontu exists to solve this issue, improving the relationship between HR and employees of different companies, which faces difficulties with the control of working hours using extremely complex systems.

As far as the market is concerned, Pontu aims to ensure small and medium-sized companies, offering a reliable and accessible time card management system.
## Getting Started
This document describes how to configure the system deploy and how to open it in any IDE for any modifications that involve configuring the project.
### Prerequisites
To deploy the system, you must install:
* Tomcat 7+ (to deploy in production).
* JDK8+.
* MySQL
* Any IDE (The IDE used in this project was Netbeans).

### Running in DEV mode

#### Configuring the Database
* All the DB configuration can be found and configured in a file called **datasource.properties**, if you don't have this file, you can create by your own.

* By default, a properties file in a specific directory on your computer:
	* If you choosed to keep the default configuration, you must create a directory named **pontu** with **datasource file** in it.
```
WINDOWS: C:\\Pontu\\datasource.properties
LINUX DIST.: /usr/local/pontu/datasource.properties
```
  * To change the default directory open the file data **dataSource.java** in *src/main/java/com/br/pontu/config*. Change the directory path on the operating system you want, follow the example below:
 
**WINDOWS**
```java
      
 if(so.equalsIgnoreCase("windows 10") || so.equalsIgnoreCase("windows 7")) {
					
	  arquivo = new FileInputStream("C:\\Pontu\\datasource.properties");
}
```
**LINUX**
```java
 if (so.equalsIgnoreCase("linux")) {

	   arquivo = new FileInputStream("/usr/local/pontu/datasource.properties");
}
```
* You also can change the datasouce file to any name you want here!



<!-- ### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```
-->

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
