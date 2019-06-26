import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class I2{

    @Test
    public void Assertion_task()throws Exception{

        System.setProperty("webdriver.chrome.driver", "C:/Users/Akanksha/Selenium/exe file/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        driver.navigate().to("https://www.irctc.co.in");

        String title = driver.getTitle();
        System.out.println("Title :" + title);
        Assert.assertTrue(title.contains("IRCTC Next Generation eTicketing System"));
        String url = driver.getCurrentUrl();
        System.out.println("URL: " +url);
        Assert.assertNotEquals("https://www.irctc.co.in", url);
//Logo verification
        WebElement logo = driver.findElement(By.xpath("//div[@class=\"h_logo_right_div\"]//img[@class=\"h_logo\"]"));
        Assert.assertNotNull(logo);

        WebDriverWait wait= new WebDriverWait(driver,10);
//from web element
        driver.findElement(By.xpath("//input[@placeholder='From*']")).click();
        driver.findElement(By.xpath("//input[@placeholder='From*']")).sendKeys("NEW DELHI");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NEW DELHI - NDLS']"))).click();

//To web element
        driver.findElement(By.xpath("//input[@placeholder='To*']")).click();
        driver.findElement(By.xpath("//input[@placeholder='To*']")).sendKeys("CHANDIGARH");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='CHANDIGARH - CDG']"))).click();

//date web element
        driver.findElement(By.xpath("//span[text()=\"ui-btn\"]/..")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='fa fa-angle-right']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='30'])[2]/..")).click();
//finding train
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Find trains']")).click();
        Assert.assertEquals("Modify Search", "Modify Search");
        System.out.println("User is in the train list");

        Thread.sleep(5000);
        WebElement jc = driver.findElement(By.xpath("(//h4[text()='Journey Class ']//input[@name='jcAll'])[1]"));
        Assert.assertTrue(jc.isSelected());
        System.out.println("Verified 'Journey class' is selected");

        Thread.sleep(5000);
        WebElement nds = driver.findElement(By.xpath("(//label[text()='NEW DELHI(NDLS)']/..//input)[1]"));
        Assert.assertTrue(nds.isSelected());
        System.out.println("New delhi is selected");

        Thread.sleep(5000);
        WebElement c = driver.findElement(By.xpath("(//label[text()='CHANDIGARH(CDG)']/..//input)[1]"));
        Assert.assertTrue(c.isSelected());
        System.out.println("Chandigarh is selected");

        Thread.sleep(4000);
        WebElement Dd = driver.findElement(By.xpath("//span[text()='30 Jul']"));
        Assert.assertEquals("30 Jul", "30 Jul");
        System.out.println("Departure date is same as selected");
        Assert.assertFalse(Dd.isSelected());


        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
        System.out.println("The user is on flights page");


        Thread.sleep(5000);
        Set<String> SessionIds = driver.getWindowHandles();
        Iterator<String> iter = SessionIds.iterator();
        String childWindow = iter.next();
        driver.switchTo().window(childWindow);
        System.out.println("The title of the flight page is :" + driver.getTitle());
        Assert.assertEquals("Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air ","Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air " );

        try

        {



        }catch(Exception e){

            // Code for Handling the exception

        }
        //        Verifying number of trains
//        List<WebElement> number_of_trains= driver.findElements(By.className("train_avl_enq_box fromAndToStn"));
//int count1=0;
//        for(int i=0;i<number_of_trains.size();i++)
//        {
//            count1++;
//        }
//        System.out.println(count1);
//        int count=number_of_trains.size();
//        System.out.println(count);
//        Verifying number of trains
//        verifying pagination
//        WebElement verify=driver.findElement(By.xpath("//span[text()=\"  9 of 9 trains found\"]"));
//        Assert.assertEquals;
//        verifying pagination
//        exception handling

//        exception handling

        int iCount = 0;
        iCount = driver.findElements(By.xpath("//button[text()=\" Check availability & fare \"]")).size();
        String totallist = driver.findElement(By.xpath("//div[@class='col-md-12 hidden-xs']//b")).getText();
// Assert.assertTrue(title.contains("IRCTC Next Generation eTicketing System"));
// Assert.assertEquals(true, totallist.contains(iCount));
        String count=Integer.toString(iCount);
        Assert.assertEquals(totallist,count+" of "+count+" trains found");
        System.out.println(count);


    }
}
