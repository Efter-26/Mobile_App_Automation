# Android Calculator App Automation Project

## Project Overview
This project involves the automation of an Android Calculator app, designed to validate multiple arithmetic functions (addition, subtraction, multiplication, division) along with complex mathematical series provided through parameters and a CSV data file. The automation script is built using Java, Appium, and TestNG, with Gradle as the build tool. Allure reports are generated to visualize test execution results, and screenshots of summary and behavior reports are included.
### Expressions Used in Automation
1. `100/10*5-10+60` // Expected Result: 100
2. `50+40-30/2+20` // Expected Result: 95
3. `10*2/2+10-20` // Expected Result: 0
4. `4pi2^3` // Expected Result: 100.53

## Tools and Technologies
- **Programming Language**: Java
- **Build Tool**: Gradle
- **Automation Framework**: TestNG
- **Mobile Automation**: Appium
- **Data Handling**: OpenCSV for reading test data from a CSV file
- **Reporting**: Allure for detailed test execution reporting
- **Inspector Tool**: Appium Inspector for UI element inspection

## Prerequisites
- **Java Development Kit (JDK)** - Install JDK 17 or later.
- **Android SDK** - Set up the Android Software Development Kit to run Android emulators or connect to real devices.
- **Appium** - Install Appium for mobile automation, compatible with your OS.
- **Gradle** - Install Gradle and set it up in your system path.
- **Appium Inspector** - Use Appium Inspector to locate and verify elements in the calculator app.

## Project Structure

- **src/test/java**: Contains the primary page objects and reusable methods.
  - `Setup.java`: This class initializes the configuration for the Appium test environment. It establishes the connection between the Android device or emulator and the test automation scripts by setting the desired capabilities and creating an `AndroidDriver` instance.
  - `CalcScreen.java`: Defines UI elements and methods for interacting with the calculator screen.

- **src/test/java**: Contains test cases.
  - `CalcTestRunner.java`: Test runner class that includes:
    - `calculateSeries` method: A parameterized method to pass and calculate various arithmetic series expressions.
    - `calculateSeriesFromCsv` method: A data-driven test method to read arithmetic expressions from a CSV file, evaluate them, and verify results against expected outcomes.

- **src/test/resources**: Contains additional resources.
  - `data.csv`: Contains arithmetic expressions and expected results for validation in `calculateSeriesFromCsv`.
  - `suite.xml`: TestNG suite configuration file for organizing and executing test cases in a structured manner.

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
   allure generate allure-results --clean -output
   allure serve allure-results
   ```
2. Screenshots for the report summary and behavior view are included in the allure-reports directory.

## Test Cases
- **Basic Arithmetic Tests** - Validate addition, subtraction, multiplication, and division functions.
- **Parameterized Series Calculation** - Validate complex expressions passed as parameters to ensure accurate results.
- **CSV Data-Driven Tests** - Read expressions and expected results from `data.csv` and verify each calculation's accuracy.

## Screenshots and Recording
- The `allure-reports` directory contains screenshots of the Allure report's summary and behavior sections for reference.
![image](https://github.com/user-attachments/assets/4b957e5c-ab39-42f1-b7f4-f9796bfe19c1)
![image](https://github.com/user-attachments/assets/f61aa612-30e6-4d5c-b65f-529027b9ba60)
![image](https://github.com/user-attachments/assets/5a8e65d5-c2f3-4d05-a4b3-d84ec51d6fdf)
![image](https://github.com/user-attachments/assets/a7f78145-1341-447f-935f-6b50e2f44d16)
![image](https://github.com/user-attachments/assets/a2e72038-3e5c-45a1-903c-266250b06cdb)

- A recording of the automation is included to demonstrate the test execution in real-time. Watch the [demo video here](https://drive.google.com/drive/folders/1gomDLlmXNF3nh1m-8w90WxPtbI-vOk-t?usp=sharing).
