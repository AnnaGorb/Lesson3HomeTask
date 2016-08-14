import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Shelty on 14.08.2016.
 */
public class HourlyCalculatorScenario {

    @Test (groups = {"P1","regression"})

    public void hourly()throws Exception {

        StartTest.driver.get("http://www.paycheckcity.com/calculator/hourly/");
        StartTest.driver.findElement(By.id("addRate")).click();
     /*   if (Assert.assertFalse(StartTest.driver.))
        {StartTest.driver.findElement(By.id("addRate")).click();}*/
        StartTest.driver.findElement(By.id("calcType.rates0.payRate")).clear();
        StartTest.driver.findElement(By.id("calcType.rates0.payRate")).sendKeys("50");
        StartTest.driver.findElement(By.id("calcType.rates0.hours")).clear();
        StartTest.driver.findElement(By.id("calcType.rates0.hours")).sendKeys("160");
        StartTest.driver.findElement(By.id("calcType.rates1.payRate")).clear();
        StartTest.driver.findElement(By.id("calcType.rates1.payRate")).sendKeys("80");
        StartTest.driver.findElement(By.id("calcType.rates1.hours")).clear();
        StartTest.driver.findElement(By.id("calcType.rates1.hours")).sendKeys("8");
        StartTest.driver.findElement(By.id("generalInformation.grossPayAmount")).click();


        Assert.assertEquals(StartTest.driver.findElement(By.id("generalInformation.grossPayAmount")).getAttribute("value"),"8640");

    }
}


