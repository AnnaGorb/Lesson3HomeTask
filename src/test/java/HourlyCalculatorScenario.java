import com.thoughtworks.selenium.condition.Not;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Shelty on 14.08.2016.
 */
public class HourlyCalculatorScenario {

    @DataProvider(name = "hourlyData")
    public static Object[][] hourlyData() {
        return new Object[][]{{"50","160","80","8","8640"},{"40","150","70","5","6350"}};

    }

    @Test (groups = {"P1","regression"} , dataProvider = "hourlyData")

    public void hourly(String payRate, String hours, String payRate1, String hours1, String result)throws Exception {

        StartTest.driver.get("http://www.paycheckcity.com/calculator/hourly/");
        /*StartTest.driver.findElement(By.id("addRate")).click();*/
        if (StartTest.driver.findElements(By.id("calcType.rates1.payRate")).isEmpty())
                {StartTest.driver.findElement(By.id("addRate")).click();}
        StartTest.driver.findElement(By.id("calcType.rates0.payRate")).clear();
        StartTest.driver.findElement(By.id("calcType.rates0.payRate")).sendKeys(payRate);
        StartTest.driver.findElement(By.id("calcType.rates0.hours")).clear();
        StartTest.driver.findElement(By.id("calcType.rates0.hours")).sendKeys(hours);
        StartTest.driver.findElement(By.id("calcType.rates1.payRate")).clear();
        StartTest.driver.findElement(By.id("calcType.rates1.payRate")).sendKeys(payRate1);
        StartTest.driver.findElement(By.id("calcType.rates1.hours")).clear();
        StartTest.driver.findElement(By.id("calcType.rates1.hours")).sendKeys(hours1);
        StartTest.driver.findElement(By.id("generalInformation.grossPayAmount")).click();


        Assert.assertEquals(StartTest.driver.findElement(By.id("generalInformation.grossPayAmount")).getAttribute("value"), result);

    }
}


