# POS_UI_Automation

# Description
This project contains automated tests for the POS Website using Selenium with Java and TestNG.

## Test Cases
1. Verify that POS Website offers to buy Insurance.
2. Verify that POS Website has links to create e-Consignment note.

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) installed 21
- Maven installed
- IDE (Eclipse, IntelliJ IDEA, etc.) installed

### Dependencies
- Selenium WebDriver
- TestNG
- WebDriverManager (for managing WebDriver binaries)

### Getting Started

1. **Clone the Repository:**
    - git clone https://github.com/lucky1993-hub/POS-Project-UI-Automation.git
2. Navigate to the project directory:
    - cd POS-System
3. Install the dependencies
   - mvn clean install

### Set Up Project:

Open the project in your preferred IDE.
Resolve dependencies using Maven (pom.xml).

### Running Tests:

1. Run tests using TestNG or used the following command
   - mvn test
2. Run all tests: select "Run".
   - ByInsuranceTest
   - eConsignmentTest
   
3. Run individual test classes.

### Reporting:
Allure Reporting:

Generate Allure reports:
- allure serve target/allure-results

## Project Structure:

- src/main/java: Contains main Java code.
- src/test/java: Contains test classes.

## Directory Structure
- src/
   - main/
  - java/
  - Pages/
    - HomePage.java
    - ParcelPage.java
    - EConsignmentNotePage.java
    - InsurancePage.java
  - utils/
    - JsonReader.java
 - Test/
     - java/
     - Test/
         - ByInsuranceTest
         - eConsignmentTest
 - resources/
   - Data/
   - locators.json
  
   

