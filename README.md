# DataDrivenFramework
A Selenium-Java based Data Driven Framework using Jenkins
In the Selenium Project we are using Java language
In the above mentioned project we are using Data Driven Framework
DataDrivenFramework :- Test Data  + Test Script

Create Base Class :-
Inheritance enables you to create new classes that reuse,extend and modify the behaviour defined in other classes.
Class whose members are inherited is called Base Class.
Class is responsible for loading the configuration from properties file,initializing Webdriver,implici waits,Extent Reports and also to create the object of FileInputStream responsible for pointing towards the file from which data is read.
Single Package : Purushartha including web relatedand test related classes.
Properties : Config, OR, Log4j keeping all details in seprate file makes it easy to maintain.
Initializing Logs : Application log, Selenium log
Screenshots : Screenshots will be captured and storedin a seprate folderand the screenshots of a failed test cases will be added in the extent reports.
Test Data : All the historical test data will be kept in excel sheet.By using 'controller.xlsx' we pass test data and handle data driven testing.We use ApachePOI to handle excel sheets.
TESTNG : Using TESTNG for Assertions,Grouping and parallel execution
DDD Framework : Datadriven development is a software development approach that Seprates the test data from test Script.
Maven : Using Maven for build,execution,and dependency purpose.Integrating the TestNG dependency in POM.xml file and running this POM.xml file using Jenkins.
Version control Tool: We use GIT as a repository to store our test scripts.
Jenkins : By using Jenkins CI(Continuous Integration) Tool,we execute test cases on daily basis and for nightly execution based on the schedule.Test Result will be sent to the peers using jenkins
Extent Reports : For the reporting purpose, we are using extent reports.It generates beautiful HTML reports. We use the extent reports for maintaining logs and to include the screenshots of failed test cases in the extent reports.
