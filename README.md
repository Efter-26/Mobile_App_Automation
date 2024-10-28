# Android Calculator App Automation Project

## Project Overview
This project involves the automation of an Android calculator app, designed to validate multiple arithmetic functions (addition, subtraction, multiplication, division) along with complex mathematical series provided through parameters and a CSV data file. The automation script is built using Java, Appium, and TestNG, with Gradle as the build tool. Allure reports are generated to visualize test execution results, and screenshots of summary and behavior reports are included.

## Tools and Technologies
- **Programming Language**: Java
- **Build Tool**: Gradle
- **Automation Framework**: TestNG
- **Mobile Automation**: Appium
- **Data Handling**: OpenCSV for reading test data from a CSV file
- **Reporting**: Allure for detailed test execution reporting
- **Inspector Tool**: Appium Inspector for UI element inspection

## Prerequisites
- **Java Development Kit (JDK)** - Install JDK 8 or later.
- **Android SDK** - Set up the Android Software Development Kit to run Android emulators or connect to real devices.
- **Appium** - Install Appium for mobile automation, compatible with your OS.
- **Gradle** - Install Gradle and set it up in your system path.
- **Appium Inspector** - Use Appium Inspector to locate and verify elements in the calculator app.

## Project Structure
- **src/test/java**: Contains the primary page objects and reusable methods.
  - `Setup.java`: This class initializes the configuration for the Appium test environment. It establishes the connection between the Android device or emulator and the test automation scripts by setting the desired capabilities and creating an `AndroidDriver` instance.
- **src/test/java**: Contains the primary page objects and reusable methods.
  - `CalcScreen.java`: Defines UI elements and methods for interacting with the calculator screen.
- **src/test/java**: Contains test cases.
  - `CalcTestRunner.java`: Test runner class that includes:
    - A parameterized method to pass and calculate various series.
    - A method to read arithmetic expressions from a CSV file and validate results.
- **src/test/resources**: Contains additional resources.
  - `data.csv`: Contains arithmetic expressions and expected outcomes for validation.
  - `suite.xml`: TestNG suite configuration file for organizing test execution.

## Running the Tests
1. Clone the repository and navigate to the project directory.
2. Ensure your Android device or emulator is connected and accessible via ADB.
3. Execute tests using the following command in your terminal:

   ```bash
   gradle clean test
   ```
## Generating Reports

Allure reports are generated after test execution to provide insights into test performance:

1. Run the following command to start a local server and view the Allure report:
   ```bash
   allure serve build/allure-results
   ```
2. Screenshots for the report summary and behavior view are included in the allure-reports directory.

## Test Cases
- **Basic Arithmetic Tests** - Validate addition, subtraction, multiplication, and division functions.
- **Parameterized Series Calculation** - Validate complex expressions passed as parameters to ensure accurate results.
- **CSV Data-Driven Tests** - Read expressions and expected results from `data.csv` and verify each calculation's accuracy.

## Screenshots and Recording
- The `allure-reports` directory contains screenshots of the Allure report's summary and behavior sections for reference.

- A recording of the automation is included to demonstrate the test execution in real-time.


