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
        driver.get("https://www.saucedemo.com/"); // Replace with actual URL
        System.out.println("Navigated to login page");
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // Replace with actual locators
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Entered credentials and clicked login");
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        boolean isDashboardDisplayed = driver.findElement(By.className("app_logo")).isDisplayed(); // Replace with actual locator
        System.out.println("Verifying dashboard visibility");
        if (isDashboardDisplayed) {
            System.out.println("User successfully redirected to the dashboard");
        } else {
            throw new AssertionError("Dashboard not displayed");
        }
    }
}
