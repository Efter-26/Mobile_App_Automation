import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CalcTestRunner extends Setup {
    @Test(priority = 1, description = "Calculate a series of arithmetic operations")
    public void testCalculateSeries() {
        CalcScreen calcScreen = new CalcScreen(driver);
        String series = "100/10*5-10+60";

        String result = calcScreen.calculateSeries(series);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(result, "100", "The calculated result does not match the expected value.");
        softAssert.assertAll();

        Allure.description("Series calculation completed successfully with result: " + result);
    }

    @DataProvider(name = "csvData")
    public Object[][] readCsvData() throws IOException, CsvException {
        String csvFilePath = "src/test/resources/data.csv";
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath))
                .withSkipLines(1)
                .build()) {
            List<String[]> allData = reader.readAll();

            Object[][] data = new Object[allData.size()][2];
            for (int i = 0; i < allData.size(); i++) {
                data[i][0] = allData.get(i)[0];
                data[i][1] = Double.parseDouble(allData.get(i)[1]);
            }
            return data;
        }
    }

    @Test(priority = 2, dataProvider = "csvData", description = "Calculate expression from CSV and verify result")
    public void calculateSeriesFromCsv(String expression, double expected) {
        CalcScreen calcScreen = new CalcScreen(driver);

        String result = calcScreen.calculateExpression(expression);
        double actual = Double.parseDouble(result);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected, 0.01, "Expression result does not match expected");
        softAssert.assertAll();

        Allure.description("Calculation from CSV for expression: " + expression);
    }


    @AfterMethod
    public void clearScreen(){
        CalcScreen calcScreen=new CalcScreen(driver);
        calcScreen.btnClear.click();
    }
}
