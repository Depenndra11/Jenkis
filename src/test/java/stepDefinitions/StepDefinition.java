package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class StepDefinition extends BaseClass {
    WebDriver driver;

    @Before
    public void setUp() {
        initializeDriver(); // Initialize WebDriver from BaseClass
        driver = BaseClass.driver;
    }

    @After
    public void tearDown() {
        quitDriver(); // Quit WebDriver from BaseClass
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://example.com/login"); // Replace with actual URL
        System.out.println("Navigated to login page");
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("testuser"); // Replace with actual locators
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginButton")).click();
        System.out.println("Entered credentials and clicked login");
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        boolean isDashboardDisplayed = driver.findElement(By.id("dashboard")).isDisplayed(); // Replace with actual locator
        System.out.println("Verifying dashboard visibility");
        if (isDashboardDisplayed) {
            System.out.println("User successfully redirected to the dashboard");
        } else {
            throw new AssertionError("Dashboard not displayed");
        }
    }
}
