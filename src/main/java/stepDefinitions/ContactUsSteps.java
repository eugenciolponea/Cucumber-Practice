package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ContactUsSteps {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "/src/main/java/drivers/chromedriver2.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the University Contact Us Page")
    public void i_access_the_university_contact_us_page() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");

    }
    @When("I enter a first name")
    public void i_enter_a_first_name() throws InterruptedException {
        driver.findElement(By.name("first_name")).sendKeys("Eugen");
        Thread.sleep(3000);
    }
    @When("I enter a last name")
    public void i_enter_a_last_name() throws InterruptedException {
        driver.findElement(By.name("last_name")).sendKeys("Test");
        Thread.sleep(3000);
    }

    @When("I enter an email address")
    public void i_enter_an_email_address() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("eugen@test.com");
        Thread.sleep(3000);
    }
    @When("I enter a comment")
    public void i_enter_a_comment() throws InterruptedException {
        driver.findElement(By.name("message")).sendKeys("A comment");
        Thread.sleep(3000);
    }
    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click();

    }
    @Then("I should be  presented with a successful Contact Us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"contact_reply\"]/h1"));
        Assert.assertEquals(successMessage.getText(),"Thank You for your Message!");
    }


}
