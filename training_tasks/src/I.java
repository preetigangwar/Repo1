import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class I {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Akanksha/Selenium/exe file/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).click();
        Actions act = new Actions(driver);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("Delhi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Delhi, India']")).click();
        //code for dedstination
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).sendKeys("Mumbai");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Mumbai, India']")).click();
        Thread.sleep(2000);
        //code for date
        driver.findElement(By.xpath("//div[@id='fare_20190626']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
        driver.findElement(By.xpath("//div[@id='fare_20190628']")).click();
        driver.findElement(By.xpath("//div[@id='pax_link_common']")).click();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//button[@id='adultPaxPlus']")).click();
            Thread.sleep(2000);
        }
        for (int j = 0; j < 3; j++) {
            driver.findElement(By.xpath("//button[@id='childPaxPlus']")).click();
        }
        driver.findElement(By.xpath("//select[@id='gi_class']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Business')]")).click();
        // Code for Search
        driver.findElement(By.xpath("//button[@id='gi_search_btn']")).click();
        Thread.sleep(2000);

        WebElement e = driver.findElement(By.xpath("//span[text()='Price']"));
        act.moveToElement(e).perform();
        WebElement slider = driver.findElement(By.xpath("//div[@id=\"sliderFO\"]//div[@class=\"fltSld-handle fltSld-handle-1 \"]"));
        act.clickAndHold(slider);
        act.dragAndDropBy(slider, -75, 0).perform();
        WebElement slider2 = driver.findElement(By.xpath("//div[@id=\"sliderFR\"]//div[@class=\"fltSld-handle fltSld-handle-1 \"]"));
        act.clickAndHold(slider2);
        act.dragAndDropBy(slider2, -55, 0).perform();



    }

}
