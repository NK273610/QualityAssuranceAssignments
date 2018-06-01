# Quality Assurance Unit Test Assignment

In this assignment we have created methods and written unit test for all the methods. I have created two mock databases one in production which we should not and one in test folder. Usually in production we call the real database layer and we mock the database layer through Mockito for unit test. So that we don't call database when writing unit test case. Here I have implemented both when test case calls database it calls through Mockto and when main method calls database it calls actual database layer.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Put the xml file you want to read in resource folder and then type the name of file when it asks to enter the full file name.
For any file to be read externally please put it in resource folder and just give name of file. We have also included some xml for testing in resource folder. All the test cases are written in test folder for every class we have in controller of main method. I have created some redudancy in main method for generating the response but as this assignment primarily focused on test cases for methods, So I have mainly focused on all boundary and error cases.
```
Give examples
```

### Installing

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

To test the methods we have implemented test classes in test folder. Please run the classses in order to tests the methods impemented. 

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

## Deployment

Add additional notes about how to deploy this on a live system

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Dependencies
* Mockito version-1.9.5
* junit version-4.12
* org.wiztools version-0.2.1
* jaxb-api version-2.2.11
* XmlSchema version-1.4.7
 
## References

* Hat tip to anyone whose code was used
* Inspiration
* etc

