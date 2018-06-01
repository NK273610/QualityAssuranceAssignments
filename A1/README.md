# Quality Assurance Unit Test Assignment

In this assignment we have created methods and written unit test for all the methods. I have created two mock databases one in production which we should not and one in test folder. Usually in production we call the real database layer and we mock the database layer through Mockito for unit test. So that we don't call database when writing unit test case. Here I have implemented both when test case calls database it calls through Mockto and when main method calls database it calls actual database layer.

### Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
From terminal first compile all the files then run the MainClass.class file, which will prompt you to type filename. You will get response.xml in outer folder i.e QualityssurnaceAssignment1_B00775542 folder. 
Put the xml file you want to read in resource folder and then type the name of file when it asks to enter the full file name.
For any file to be read externally please put it in resource folder and just give name of file. We have also included some xml for testing in resource folder. All the test cases are written in test folder for every class we have in controller of main method. I have created some redudancy in main method for generating the response but as this assignment primarily focused on test cases for methods, So I have mainly focused on all boundary and error cases.

### Mock Data For dealer id and dealer access 
        data.put("XXX-1234-ABCD-1234","kkklas8882kk23nllfjj88290");
        data.put("XXX-1235-DEFG-1235","kkklas8882kk23nllfjj88291");
        data.put("XXX-1237-ACDC-1237","kkklas8882kk23nllfjj88292");
        data.put("XXX-1238-BAND-1238","kkklas8882kk23nllfjj88293");
        data.put("XXX-1239-LTTF-1239","kkklas8882kk23nllfjj88294");
        data.put("XXX-1230-KBDC-1230","kkklas8882kk23nllfjj88295");
        
### Mock Data For part no and quantity
        data2.put(1234,123);
        data2.put(5678,100);
        data2.put(2254,20);
        data2.put(1200,8);
        data2.put(1987,4);
        data2.put(1377,23);
        data2.put(1900,2);
       
## Please make sure I am using these data as mock data so please test with values in this data for daaler and part number.

### Running the tests
To test the methods we have implemented test classes in test folder. Please run the classses in order to tests the methods impemented. 

### Break down class mthods of Controller
There are in total five classes in controller which handles the logic having it's interfaces in interface folder.

1.secure class:- checks if dealer id and dealer access key is not null and it is valid i.e. present in mock database.

2. validPart class:-checks if partnumber is valid i.e. it is present in database and quantity demanded is less than or equal to quantity present in database for that part number.

3. XMLReader class:- It has methods to check null values in xml that we are reading, validate it's schema, get data from xml and convert xml to xsd.

4. ValidateData:- We validate the dealerid that we get from xml mathces the pattern and check the values are not null for every specific entry in xml. We have given implementation of check null values method in this class.

5. partmanager class:- Here we verify if partno and quantity is valid and check that delivery address is not null. 

### Test classes
Explain what these tests test and why
Test case to check if dealer id has correct pattern. Here we have changed the pattern and tried testing the method.
```
@Test
    @DisplayName("DealerAuthorizedTest for dealerid for regular expression")
    public void IsDealerAuthorizedRegex() throws JAXBException {


        assertFalse(sc.IsDealerAuthorized("XXX-1234-ABD-1234", "kkklas8882kk23nllfjj88290"));

    }
```
Test case to check if part number is valid having quantity in order less than that in database.
```
@Test
    @DisplayName("Part quantity validity")
    public void IsPartQuantityNoValid() throws JAXBException {


       assertFalse(vp.check_valid_part(1234,25));

    }
```

### File Deployment and output response.xml
Put the file in resource folder under src/main/resource and enter the file name and you will get response.xml under QualityssurnaceAssignment1_B00775542 folder. 

### Built With
* [Maven](https://maven.apache.org/) - Dependency Management

### Dependencies
* Mockito version-1.9.5
* junit version-4.12
* org.wiztools version-0.2.1
* jaxb-api version-2.2.11
* XmlSchema version-1.4.7
 
 ### Note
 * We have used org.wiztools library to convert xml to xsd. We have created xsd required to validate schema using this library.

