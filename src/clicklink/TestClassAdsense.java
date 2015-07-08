/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicklink;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
/**
 *
 * @author shahrear.iqbal
 */
public class TestClassAdsense {
    
        public static WebDriverWait wait;
        public static WebDriver driver;
           public PrintWriter writer;
        
        public TestClassAdsense()
        {
            System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");

        driver = new ChromeDriver();  
        }

    
        public void testMethod() throws InterruptedException
        {
        
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.amadershomoys.com/newsite/");
        
        By by = By.className("adsbygoogle");
        WebElement e = waitForElementVisible(by);
        //driver.switchTo().frame(e);
        //System.out.println(e.getAttribute("class"));
        //e= e.findElement(By.className("content-secondary"));
        
//        driver.switchTo().frame(e);
//        System.out.println("google_ads_frame1 visible");
        wait = new WebDriverWait(driver,10);
        try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[9]/ins[1]/ins[1]/ins[1]/iframe[1]")));

            } catch (Exception ec) {
                //method logging an error
                System.out.println("Timeout : element aswift_3 is not visible");
            }

        System.out.println(e.getAttribute("href"));
        
//        try
//        {
//          writer = new PrintWriter("domfull.txt", "UTF-8");
//          String contents = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", e);
//          writer.print(contents);
//          writer.flush();
//          writer.println("-------------------------------------------------------------------------------------------");
//          writer.println("-------------------------------------------------------------------------------------------");
//          contents = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].outerHTML;", e);
//          writer.print(contents);
//          writer.flush();
//
//
//        }
//        catch(IOException ex)
//        {
//            System.out.println(ex.toString());
//        }
//        finally
//        {
//         writer.close();
//        }
//       // driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
         //System.out.println("ad_iframe visible");
       // e= driver.findElement(By.xpath("//div[1]"));
       //WebElement e = driver.findElement(By.xpath("//div/div[7]/ins"));
        new Actions(driver).moveToElement(e, 10, 10).clickAndHold().click().build().perform();
        //String att = driver.findElement(By.xpath("//div[1]/a[1]")).getAttribute("href");
        //String att = driver.findElement(By.id("ad_iframe")).getAttribute("style");
       
//        List<WebElement> el = driver.findElements(By.cssSelector("*"));
//
//        for(WebElement ele:el)
//        {
//             System.out.println(ele.getText());
//        } 
           //System.out.println(att);
            //driver.get(att); 
            driver.quit();
        }
        

        protected WebElement waitForElementVisible(By by) {
            wait = new WebDriverWait(driver,30);
            WebElement element = null;
                wait.ignoring(org.openqa.selenium.NoSuchElementException.class);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                element = driver.findElement(By.xpath("//div[1]/div[9]/ins[1]"));
            } catch (Exception e) {
                //method logging an error
                System.out.println("Timeout : element " + by.toString() + " is not visible");
            }
            return element;
        }
    
}
