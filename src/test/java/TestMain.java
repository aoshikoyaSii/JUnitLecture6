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
    private  WebDriver  driver = new ChromeDriver();


    @BeforeAll
    static void connect(){
        WebDriverManager.chromedriver().setup();
        System.out.println("---> connect to DB");
    }
    @BeforeEach
    void setup(){
        System.out.println("---> Before Each Test");
    }
    @AfterEach
    void teardown(){
        driver.quit();
        System.out.println("----> Tear Down ---> ");
    }
    @AfterAll
    static void close(){
        System.out.println("----> close DB connection");
    }

//    test starts here
    @ParameterizedTest
    @ValueSource(strings="Sii Poland")
    @Tag("regression")
    @Order(1)
    void SiiPortal(String pageTitle){
       driver.get("https://sii.pl/en/");
       driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="Onet – Jesteś na bieżąco")
    @Tag("regression")
    @Order(2)
    void Onet(String pageTitle){
        driver.get("https://www.onet.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="Kotuszkowo- blog o kotach")
    @Tag("regression")
    @Order(3)
    void Kotusz(String pageTitle){
        driver.get("http://kotuszkowo.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="Filmweb - filmy takie jak Ty!")
    @Tag("regression")
    @Order(4)
    void FilmWeb(String pageTitle){
        driver.get("https://www.filmweb.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings="WebDriver :: Documentation for Selenium")
    @Tag("regression")
    @Order(5)
    void SeleniumWeb(String pageTitle){
        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(pageTitle, equalTo(actualTitle));
    }
}
