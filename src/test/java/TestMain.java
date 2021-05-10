import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMain {
    private  WebDriver driver;

    @BeforeAll
    static void connect(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
    }
    @AfterEach
    void teardown(){
        driver.quit();
    }
    @AfterAll
    static void close(){
    }

//    test starts here
    @ParameterizedTest
    @ValueSource(strings="Sii Poland")
    @Tag("Sii")
    @Tag("regression")
    void SiiPortal(String pageTitle){
       driver.get("https://sii.pl/en/");
       driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="Onet – Jesteś na bieżąco")
    @Tag("Onet")
    @Tag("regression")
    void Onet(String pageTitle){
        driver.get("https://www.onet.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="Kotuszkowo- blog o kotach")
    @Tag("Kotusz")
    @Tag("regression")
    void Kotusz(String pageTitle){
        driver.get("http://kotuszkowo.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="Filmweb - filmy takie jak Ty!")
    @Tag("FilmWeb")
    @Tag("regression")
    void FilmWeb(String pageTitle){
        driver.get("https://www.filmweb.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="WebDriver :: Documentation for Selenium")
    @Tag("Selnium")
    @Tag("regression")
    void SeleniumWeb(String pageTitle){
        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }
}
