package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("I am on basketballengland page")
    public void iAmOnBasketballenglandPage() {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("I fill in the correct member details")
    public void iFillInTheCorrectMemberDetails() {
        String email = "TestUser" + System.currentTimeMillis() + "@provko.com";

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys("10/10/1992" + Keys.ENTER);
        FirstName.sendKeys("Test");
        LastName.sendKeys("Testy");
        Email.sendKeys(email);
        ConfirmEmail.sendKeys(email);
        Pass.sendKeys("1234@");
        ConfirmPass.sendKeys("1234@");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();


    }

    @When("I fill in the correct member details but not filling on lastname")
    public void iFillInTheCorrectMemberDetailsButNotFillingOnLastname() {
        String email = "TestUser" + System.currentTimeMillis() + "@provko.com";

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys("10/10/1992" + Keys.ENTER);
        FirstName.sendKeys("Test");
        Email.sendKeys(email);
        ConfirmEmail.sendKeys(email);
        Pass.sendKeys("1234@");
        ConfirmPass.sendKeys("1234@");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();

    }


    @And("I press Confirm and join")
    public void iPressConfirmAndJoin() {
        driver.findElement(By.name("join")).click();
    }

    @Then("I successfully become a member")
    public void iSuccessfullyBecomeAMember() throws InterruptedException {
        Thread.sleep(7000);

        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/h2")).getText();
        assertEquals(expected, actual);
        System.out.println("User registered");
        driver.quit();
    }


    @When("I fill in the correct member details but password don't match")
    public void iFillInTheCorrectMemberDetailsButPasswordDonTMatch() {
        String email = "TestUser" + System.currentTimeMillis() + "@provko.com";

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys("10/10/1992" + Keys.ENTER);
        FirstName.sendKeys("Test");
        LastName.sendKeys("Testy");
        Email.sendKeys(email);
        ConfirmEmail.sendKeys(email);
        Pass.sendKeys("1234@");
        ConfirmPass.sendKeys("1234@2");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();

    }
    @When("I fill in the correct member details but Term and conditions not selected")
    public void iFillInTheCorrectMemberDetailsButTermAndConditionsNotSelected() {
        String email = "TestUser" + System.currentTimeMillis() + "@provko.com";

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys("10/10/1992" + Keys.ENTER);
        FirstName.sendKeys("Test");
        LastName.sendKeys("Testy");
        Email.sendKeys(email);
        ConfirmEmail.sendKeys(email);
        Pass.sendKeys("1234@");
        ConfirmPass.sendKeys("1234@");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();


    }

    @Then("I see the error message for the lastname missing")
    public void iSeeTheErrorMessageForTheLastnameMissing() {
        String expected = "Last Name is required";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered, Last name is required");
        driver.quit();
    }

    @Then("I see the error message for the passowrd")
    public void iSeeTheErrorMessageForThePassowrd() {
        String expected = "Password did not match";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered, Password must be matched");
        driver.quit();
    }


    @Then("I see the error message for the term and condition")
    public void iSeeTheErrorMessageForTheTermAndCondition() {
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered, Term and conditions must be selected");
        driver.quit();
    }
}


