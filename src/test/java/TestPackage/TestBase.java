package TestPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBase {
    public  WebDriver driver;

   public WebDriver getDriver(){
       return driver;
    }

    static final  Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    static void connect(){
        WebDriverManager.chromedriver().setup();
        logger.info(">>> Application starts  <<<<<<<");
    }

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Run Before each Test");
    }

    @AfterEach
    void teardown(){
        driver.quit();
        logger.info(">>>> Run After each Test <<<< ");
    }

}
