# Selenium Assessment Automation Framework

This is a Selenium automation framework built using Java, Maven, and Cucumber with TestNG and ExtentReports.

---

## Tools & Technologies Used

- **Java** - for writing the test scripts  
- **Maven** - for managing dependencies and build  
- **Selenium WebDriver** - for browser automation  
- **Cucumber (BDD)** - to write readable test cases using Gherkin  
- **TestNG** - for test execution and assertions  
- **ExtentReports** - to generate detailed HTML reports  
- **Log4j** - for logging  
- **Git & GitHub** - version control  
- **Picocontainer** - for dependency injection between step definitions

---

## Project Structure (Simplified)

- `src/main/java` – contains main code such as:
  - **utilities** – WebDriver setup, driver manager, waits, and logging
  - **interactions** – business logic like login actions
  - **models** – page object models using PageFactory

- `src/test/java` – contains:
  - **stepdefinitions** – glue code for Cucumber steps
  - **runners** – TestRunner files
  - **hooks** – setup and teardown logic before/after scenarios

- `src/test/resources` – contains:
  - **features** – all `.feature` files
  - **config** – environment properties etc.

- `test-output` – generated reports and screenshots

---

## How to Run Tests

### Run all tests in a specific feature file
```bash
mvn clean test "-Dcucumber.features=src/test/resources/features/login.feature"
```

### Run all tests with a specific tag
```bash
mvn test "-Dcucumber.filter.tags=@FE"
```

### Run multiple feature files
```bash
mvn test "-Dcucumber.features=src/test/resources/features/login.feature,src/test/resources/features/checkout.feature"
```

### Run a specific tagged test from a specific feature file
```bash
mvn test "-Dcucumber.features=src/test/resources/features/login.feature" "-Dcucumber.filter.tags=@LoginTest-1"
```

### Run via testng.xml with tag filter
```bash
mvn test "-DsuiteXmlFile=testng.xml" "-Dcucumber.filter.tags=@TagName"
```

---

## Reports

After test execution, open the report file located at:
```
test-output/SparkReport/Spark.html
```