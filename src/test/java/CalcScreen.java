import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id ="com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement btnMultiply;
    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement btnDivide;
    @FindBy(id="com.google.android.calculator:id/clr")
    WebElement btnClear;
    @FindBy(id="com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id="com.google.android.calculator:id/result_final")
    WebElement txtResult;
    AndroidDriver driver;

    public CalcScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void clickNumber(int number) {
        for (char digit : String.valueOf(number).toCharArray()) {
            driver.findElement(By.id("com.google.android.calculator:id/digit_" + digit)).click();
        }
    }

    public String calculateSeries(String series) {
        for (char ch : series.toCharArray()) {
            if (Character.isDigit(ch)) {
                clickNumber(Character.getNumericValue(ch));
            } else {
                switch (ch) {
                    case '+':
                        btnPlus.click();
                        break;
                    case '-':
                        btnMinus.click();
                        break;
                    case '*':
                        btnMultiply.click();
                        break;
                    case '/':
                        btnDivide.click();
                        break;
                }
            }
        }
        btnEqual.click();
        return txtResult.getText();
    }

    public String calculateExpression(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {

                StringBuilder number = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number.append(expression.charAt(i++));
                }
                i--;
                clickNumber(Integer.parseInt(number.toString()));
            } else if (expression.startsWith("pi", i)) {
                driver.findElement(By.id("com.google.android.calculator:id/const_pi")).click();
                i++;
            } else {
                switch (ch) {
                    case '+':
                        btnPlus.click();
                        break;
                    case '-':
                        btnMinus.click();
                        break;
                    case '*':
                        btnMultiply.click();
                        break;
                    case '/':
                        btnDivide.click();
                        break;
                    case '^':
                        clickExponent();
                        break;
                    default:
                        break;
                }
            }
        }
        btnEqual.click();
        return txtResult.getText();
    }

    public void clickExponent() {
        driver.findElement(By.id("com.google.android.calculator:id/op_pow")).click();
    }

}
