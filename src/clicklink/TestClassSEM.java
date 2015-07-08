/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicklink;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
/**
 *
 * @author shahrear.iqbal
 */
public class TestClassSEM {
    
        public static WebDriverWait wait;
        public static WebDriver driver;
        public PrintWriter writer;
        public TestClassSEM()
        {
            System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"); 

        driver = new ChromeDriver();  
        }

        public void testMethod() throws InterruptedException
        {
        
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.ca/#q=running+shoes");
        By by = By.id("main");
        WebElement e = waitForElementVisible(by);
        
        
        
       // driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
        try
        {
          writer = new PrintWriter("linksg.txt", "UTF-8");
        //domTraverse(e);       
            printDomTraverse(e);
         
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
        finally
        {
         writer.close();
        }
        driver.quit();
            
        }
        
        protected void printDomTraverse(WebElement e)
        {
            
            try
        {
          PrintWriter writerDom = new PrintWriter("domfull.txt", "UTF-8");
          String contents = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", e);
          writerDom.print(contents);
          writerDom.flush();
          writerDom.println("-------------------------------------------------------------------------------------------");
          writerDom.println("-------------------------------------------------------------------------------------------");
          contents = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].outerHTML;", e);
          writerDom.print(contents);
          writerDom.flush();
          writerDom.close();
        
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
       
         
        
        }
        
        protected void domTraverse(WebElement element)
        {
            List<WebElement> alldivs = element.findElements(By.xpath("./*"));
            
            if(alldivs.size()>0)
            {
                
        
                for (WebElement ele :alldivs)
                {
                    System.out.println(ele.getTagName()+" jumping insdie "+ele.getAttribute("id")==null?"":ele.getAttribute("id")+" "+ele.getAttribute("class")==null?"":ele.getAttribute("class"));  
                         domTraverse(ele);     
                }
                
                   
            }
            
            
            
            String s = element.getTagName()+" ";
                    if(element.getAttribute("id") != null)  
                        s+="Id: "+element.getAttribute("id")+"  ";
                    if(element.getAttribute("class") != null)  
                        s+="Class: "+element.getAttribute("class")+"  ";
                    if(element.getAttribute("href") != null)  
                        s+="href: "+element.getAttribute("href")+" ";


                    System.out.println(s);  
                    if(element.getTagName()=="a") 
                        writer.println(s);
            
          
            
        }

        protected WebElement waitForElementVisible(By by) {
            wait = new WebDriverWait(driver,20);
            WebElement element = null;

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                    element = driver.findElement(By.xpath("//div[1]/div[4]/div[3]"));
//element = driver.findElement(By.id("rhs"));
            } catch (Exception e) {
                //method logging an error
                System.out.println("Timeout : element " + by.toString() + " is not visible");
            }
            return element;
        }
    
}
