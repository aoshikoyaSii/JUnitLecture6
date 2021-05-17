package TestPackage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain extends TestBase {

    private Logger logger = LoggerFactory.getLogger(TestMain.class);


    String sii;
    String onet;
    String kotusz;
    String Selenium;
    String FilmWeb;


    //    test starts here
    @ParameterizedTest
    @ValueSource(strings="Kemp Login Screen")
    @Tag("Sii")
    @Tag("regression")
    void SiiPortal(String pageTitle) {
        logger.info(">>>>>> Start (SiiPortal) test <<<<<<");
        sii  = "https://siiportal.sii.pl";
        getDriver().get(sii);
        getDriver().manage().window().maximize();
        String actualTitle = getDriver().getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
        logger.debug("webpage url: {}", sii);
        logger.debug("expected Title: {}, Actual Title: {}", pageTitle,actualTitle);
        if(actualTitle.equals(pageTitle) && logger.isDebugEnabled()){
            logger.info("CORRECT - no error found");
        }

        String loginWelcomeMessage = "LOG IN TO SIIPORTAL";
        WebElement originalwelcomeMessage = getDriver().findElement(By.className("sip-login-header-title"));
        logger.debug("login original message: {} , login message: {}" , originalwelcomeMessage, loginWelcomeMessage);
        assertThat(loginWelcomeMessage,equalTo("LOG IN TO SIIPORTAL"));
        if(!(originalwelcomeMessage.equals(loginWelcomeMessage))){
            logger.error("ERROR report - found error");
        }
    }



    @ParameterizedTest
    @ValueSource(strings="Onet – Jesteś na bieżąco")
    @Tag("Onet")
    @Tag("regression")
    void Onet(String pageTitle){
        logger.info(">>>>>> Start (Onet Webpage) test <<<<<<");
        onet = "https://www.onet.pl/";
        getDriver().get(onet);
        getDriver().manage().window().maximize();
        String actualTitle = getDriver().getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
        logger.debug("webpage url: {}", onet);
        logger.debug("expected Title: {}, Actual Title: {}", pageTitle,actualTitle);
        if(actualTitle.equals(pageTitle)){
            logger.info("CORRECT - no error found");
        }
    }

    @ParameterizedTest
    @ValueSource(strings="Kotuszkowo- blog o kotach")
    @Tag("Kotusz")
    @Tag("regression")
    void Kotusz(String pageTitle){
        logger.info(">>>>>> Start (Kotusz Webpage) test <<<<<<");
        kotusz = "http://kotuszkowo.pl/";
        getDriver().get(kotusz);
        getDriver().manage().window().maximize();
        String actualTitle = getDriver().getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
        logger.debug("webpage url: {}", onet);
        logger.debug("expected Title: {}, Actual Title: {}", pageTitle,actualTitle);
        if(actualTitle.equals(pageTitle)){
            logger.info("CORRECT - no error found");
        }
    }

    @ParameterizedTest
    @ValueSource(strings="Filmweb - filmy takie jak Ty!")
    @Tag("FilmWeb")
    @Tag("regression")
    void FilmWeb(String pageTitle){
        logger.info(">>>>>> Start (Filmweb Webpage) test <<<<<<");
        FilmWeb = "https://www.filmweb.pl/";
        getDriver().get(FilmWeb);
        getDriver().manage().window().maximize();
        String actualTitle = getDriver().getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
        logger.debug("webpage url: {}", FilmWeb);
        logger.debug("expected Title: {}, Actual Title: {}", pageTitle,actualTitle);
        if(actualTitle.equals(pageTitle)){
            logger.info("CORRECT - no error found");
        }
    }

    @ParameterizedTest
    @ValueSource(strings="WebDriver :: Documentation for Selenium")
    @Tag("Selenium")
    @Tag("regression")
    void SeleniumWeb(String pageTitle){
        Selenium = "https://www.selenium.dev/documentation/en/webdriver/";
        getDriver().get(Selenium);
        getDriver().manage().window().maximize();
        String actualTitle = getDriver().getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
        logger.debug("webpage url: {}", Selenium);
        logger.debug("expected Title: {}, Actual Title: {}", pageTitle,actualTitle);
        if(actualTitle.equals(pageTitle)){
            logger.info("CORRECT - no error found");
        }
    }
}
