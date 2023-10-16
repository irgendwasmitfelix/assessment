# Amazon Lowest Price Checkout Verification

## Pre-requisites
- IntelliJ IDEA (Community or Ultimate Edition)
- JAVA - JDK v17+ required (https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
- Maven (https://maven.apache.org/download.cgi)
- All dependencies need to satisfied from ```pom.xml```
- Required `Chrome` or `Firefox` browser to be installed in the system

## Technical Specification:
- Selenium BDD Framework with Cucumber
- Java - Programming Lanaguage
- Maven - Build Tool
- TestNG - For test cases management
- Page Object Model - maintain page wise objects

## Framework Structure
The framework is structured as follows:

`src/main/java`: Contains the Java source code for the framework.

`config`: General configuration can be setup from this file such as to setup browser and currency.

`pages`: Page Object Model (POM) classes.

`tests`: Test scripts using Cucumber BDD.

`Utils`: All common utilities usable for project declared in `common.java`

`src/test/resources`: Contains the Cucumber feature files.

`pom.xml`: Maven project configuration file.


## Run the Tests:
Run the Cucumber tests using Maven.
```bash
mvn clean test
```

#### or

Right click on `TestRunner.java` from `src/test/java/Runners/` directory

## Writing Cucumber Feature Files

- Write your BDD scenarios in the feature files located in src/test/resources.
- Use Gherkin syntax to define Given-When-Then steps.
- Creating Page Objects
  - Create Page Object classes in src/main/java/pages.
  - Encapsulate page-specific actions and elements.
- Writing Test Steps
  - Write step definitions in src/main/java/tests.
  - Map step definitions to feature file steps to execute actions and validations.

## Deliverables

- After execution, report of the executed tests can be available in `target/cucumber-reports` directory with file name `cucumber-pretty.html`

## Notes

Normally I wouldn't work with delays but because of the capture at the start of the test I had  to do 5 second  Timer (if capture Resolve appears)
And in my last job I used Node instead of Maven, so for me both is fine.