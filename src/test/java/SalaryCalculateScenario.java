import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Shelty on 14.08.2016.
 */
public class SalaryCalculateScenario {
    



    @Test (groups = {"P1","regression"})
    public void salary() throws Exception {

        StartTest.driver.get("http://www.paycheckcity.com/calculator/salary/");
        StartTest.driver.findElement(By.id("calcDate")).clear();
        StartTest.driver.findElement(By.id("calcDate")).sendKeys("08/31/2016");
        StartTest.driver.findElement(By.id("state")).clear();
        StartTest.driver.findElement(By.id("state")).sendKeys("California");
        StartTest.driver.findElement(By.id("generalInformation.grossPayMethodType")).clear();
        StartTest.driver.findElement(By.id("generalInformation.grossPayMethodType")).sendKeys("Pay Per Period");
        StartTest.driver.findElement(By.id("generalInformation.payFrequencyType")).clear();
        StartTest.driver.findElement(By.id("generalInformation.payFrequencyType")).sendKeys("monthly");
        StartTest.driver.findElement(By.id("generalInformation.grossPayAmount")).clear();
        StartTest.driver.findElement(By.id("generalInformation.grossPayAmount")).sendKeys("10000");

        if (StartTest.driver.findElement(By.id("generalInformation.exemptFederal1")).getAttribute("value")!="true")
             { StartTest.driver.findElement(By.id("generalInformation.exemptFederal1")).click();}


        StartTest.driver.findElement(By.id("calculate")).click();
        WebDriverWait wait = new WebDriverWait(StartTest.driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(StartTest.driver.findElement(By.xpath(".//h1[text()='Calculator Results']"))));

        Assert.assertEquals(StartTest.driver.findElement(By.xpath(".//span[text()='Net Pay' and @class='resultDef']/following-sibling::*[@class='resultData']")).getText(),"$8,387.79");


    }




}
