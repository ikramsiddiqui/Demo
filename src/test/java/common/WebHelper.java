package common;

import Variables.configProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.Instant;
import java.util.List;


public class WebHelper {

    //  public RemoteWebDriver driver ;
    public static WebDriver driver;
    public WebDriverWait wait;

    public String userEmail, parent;
    public long currentTimestamp;

    public void openBrowser() {
        configProperties.initializePropertyFile();
        if (configProperties.property.getProperty("BrowserType").equalsIgnoreCase("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            System.setProperty("webdriver.gecko.driver", "/Users/Pure-dev-ikram/Desktop/Repository/web-framework-automation/geckodriver");

            driver = new FirefoxDriver(options);


        } else if (configProperties.property.getProperty("BrowserType").equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver(); // Firefox driver
        } else {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            /// System.setProperty("webdriver.chrome.driver", "chromedriver");
            options.addArguments("--no-sandbox");
            options.addArguments("lang=en-GB");
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void openPage(String arg0) {
        driver.get(arg0);


    }

    public int time() {
        int time = Integer.parseInt(configProperties.property.getProperty("Timeout"));
        return time;
    }

    public long Random() throws InterruptedException {
        long random;
        random = System.currentTimeMillis();
        return random;
    }

    //******* this  function is use for click functionality *************// 
    public void click(String arg0, String arg1) throws InterruptedException {
        int time = Integer.parseInt(configProperties.property.getProperty("Timeout"));

        if (arg1.equalsIgnoreCase("xpath")) {


            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(arg0)));
            driver.findElement(By.xpath(arg0)).click();


        }
        if (arg1.equalsIgnoreCase("id")) {


            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(
                    ExpectedConditions.elementToBeClickable(By.id(arg0)));
            driver.findElement(By.id(arg0)).click();


        }


        if (arg1.equalsIgnoreCase("link")) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(arg0)));
            driver.findElement(By.partialLinkText(arg0)).click();
        }
        if (arg1.equalsIgnoreCase("css")) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(arg0)));
            driver.findElement(By.cssSelector(arg0)).click();
        }
        if (arg1.equalsIgnoreCase("classname")) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(ExpectedConditions.elementToBeClickable(By.className(arg0)));
            driver.findElement(By.className(arg0)).click();
        }
    }

    public void textField(String arg0, String arg1, String arg2) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
        if (arg2.equalsIgnoreCase("id")) {

            wait.until(ExpectedConditions.elementToBeClickable(By.id(arg1)));
            driver.findElement(By.id(arg1)).clear();
            driver.findElement(By.id(arg1)).sendKeys(arg0);
        }
        if (arg2.equalsIgnoreCase("xpath")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(arg1)));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(arg1)));
            driver.findElement(By.xpath(arg1)).clear();
            driver.findElement(By.xpath(arg1)).sendKeys(arg0);

        }
        if (arg2.equalsIgnoreCase("css")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(arg1)));

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(arg1)));
            driver.findElement(By.cssSelector(arg1)).clear();
            driver.findElement(By.cssSelector(arg1)).sendKeys(arg0);
        }
        if (arg2.equalsIgnoreCase("name")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(arg1)));

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(arg1)));
            driver.findElement(By.cssSelector(arg1)).clear();
            driver.findElement(By.cssSelector(arg1)).sendKeys(arg0);
        }
    }

    public String getTheText(String arg0, String arg1, String arg2) {
        String actual = "";

        if (arg2.equalsIgnoreCase("xpath")) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(arg1), arg0));
            actual = driver.findElement(By.xpath(arg1)).getText();
            System.out.println(actual);
            if (actual.contains("\n")) {
                String[] arrOfStr = actual.split("\n");
                for (String a : arrOfStr) {
                    actual = a;
                    System.out.println(a);
                    if (a.equalsIgnoreCase("Normal Affiliate")) {
                        break;
                    }
                }
            }
            return actual;
        }
        if (arg2.equalsIgnoreCase("id")) {

            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(arg1), arg0));
            actual = driver.findElement(By.id(arg1)).getText();
            /*if (actualcontains("http")) {
                String click = Keys.chord(Keys.CONTROL, "t");
                driver.get(click);
                driver.get(expected);
                return actual;
            }*/
            return actual;
        }
        if (arg2.equalsIgnoreCase("link")) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(
                    ExpectedConditions.elementToBeClickable(By.partialLinkText(arg1)));
            actual = driver.findElement(By.partialLinkText(arg1)).getText();

            if (actual.contains("?")) {
                String[] arrOfStr = actual.split("\\?", 2);
                String a = null;
                String[] arrOfStr1 = actual.split("=", 2);
                for (String actualCookie : arrOfStr1) {
                    actual = actualCookie;
                    break;
                }
                return actual;
            }
            if (actual.contains("#")) {
                actual = actual.startsWith("#") ? actual.substring(1) : actual;
                return actual;
            }
            return actual;
        }
        if (arg2.equalsIgnoreCase("css")) {

            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(
                    ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(arg1), arg0));
            actual = driver.findElement(By.cssSelector(arg1)).getText();
            /*if (actualcontains("http")) {
                String clickl = Keys.chord(Keys.CONTROL, "t");
                driver.get(clickl);
                driver.get(expected);
            }*/
            return actual;
        }
        if (arg2.equalsIgnoreCase("classname")) {

            wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
            wait.until(
                    ExpectedConditions.textToBePresentInElementLocated(By.className(arg1), arg0));
            actual = driver.findElement(By.className(arg1)).getText();
            /*if (actualcontains("http")) {
                String clickl = Keys.chord(Keys.CONTROL, "t");
                driver.get(clickl);
                driver.get(expected);
            }*/
            return actual;
        }
        return actual;
    }

    public void assertEqualText(String arg0, String arg1, String arg2) {
        String actual;
        String expected = arg0;
        SoftAssert softAssert = new SoftAssert();
        actual = getTheText(arg0, arg1, arg2);
        softAssert.assertEquals(actual, arg0, "Actual value is not same as Expected Value");
        softAssert.assertAll();
    }

    public String getTheTitle(String arg0) {
        String actualTitle = "";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
        wait.until(ExpectedConditions.titleIs(arg0));
        actualTitle = driver.getTitle();
        return actualTitle;
    }

    public void assertTitle(String arg0) {
        String expectedTitle = "";
        String actualTitle = "";
        expectedTitle = arg0;
        SoftAssert softAssert = new SoftAssert();
        actualTitle = getTheTitle(arg0);
        softAssert.assertEquals(actualTitle, expectedTitle, "Unble to see the expected title" + arg0 + "current page title" + actualTitle);
        softAssert.assertAll();

    }
 public  void quitBrowser(){
        driver.quit();
 }
 public Integer countofItem(String locator,String locatorType){
     int count = 0;
     if(locatorType.equalsIgnoreCase("classname")) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
              List<WebElement> elementsWithClassName = driver.findElements(By.className(locator));
              count =elementsWithClassName.size();

  }
  if(locatorType.equalsIgnoreCase("id")){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
          List<WebElement> elementsWithClassName = (List<WebElement>) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
      count =elementsWithClassName.size();
  }
  if(locatorType.equalsIgnoreCase("xpath")){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time()));
      List<WebElement> elementsWithClassName = (List<WebElement>) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
      count =elementsWithClassName.size();

  }
  return count;
 }

 public void verifyTheListCount(int count,String locator,String locatorType){
     int actual= 0;
     int expected =count;
     SoftAssert softAssert = new SoftAssert();
     actual =countofItem(locator, locatorType);
     softAssert.assertEquals(actual, expected, "Actual value= " +actual+ "is not same as Expected Value =" +expected);
     softAssert.assertAll();
 }
    public long getCurrentTimeStamp() {
        currentTimestamp = Instant.now().toEpochMilli();
        return currentTimestamp;
    }
 }





