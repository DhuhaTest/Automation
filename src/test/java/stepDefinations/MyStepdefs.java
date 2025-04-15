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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Random random = new Random();


    private WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void initializeWait() {
        if (driver != null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    public String rndDOB() {
        int minYear = 1970;
        int maxYear = 2005;
        int year = minYear + random.nextInt(maxYear - minYear + 1);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return String.format("%02d/%02d/%d", month, day, year);
    }

    String RandomBirthDate = rndDOB();

    private final String[] firstNames = {"Johan", "Mattias", "Mike", "Sarah", "Veronica", "Victoria"};
    private final String[] lastNames = {"Joakim", "Jonas", "Jimmy", "Erik", "David", "Simon"};

    public String rndFirstName() {
        return firstNames[random.nextInt(firstNames.length)];
    }

    String RandomFirstName = rndFirstName();

    public String rndLastName() {
        return lastNames[random.nextInt(lastNames.length)];
    }

    String RandomLastName = rndLastName();


    public String RandomTestEmail() {
        return "TestUser" + System.currentTimeMillis() + "@provko.com";
    }

    String RandomEmail = RandomTestEmail();


    public String generateRandomPassword() {
        return "Test@" + random.nextInt(10000);
    }

    String Password = generateRandomPassword();


    @Given("I am on basketballengland page")
    public void iAmOnBasketballenglandPage() {
        driver = new ChromeDriver();
        initializeWait();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();
    }

    @Given("I am on basketballengland page using {string}")
    public void iAmOnBasketballEnglandPageUsing(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        initializeWait();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();
    }


    @When("I fill in the correct member details")
    public void iFillInTheCorrectMemberDetails() {

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys(RandomBirthDate + Keys.ENTER);
        FirstName.sendKeys(RandomFirstName);
        LastName.sendKeys(RandomLastName);
        Email.sendKeys(RandomEmail);
        ConfirmEmail.sendKeys(RandomEmail);
        Pass.sendKeys(Password);
        ConfirmPass.sendKeys(Password);

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();


    }

    @When("I fill in the correct member details but not filling on lastname")
    public void iFillInTheCorrectMemberDetailsButNotFillingOnLastname() {

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys(RandomBirthDate + Keys.ENTER);
        FirstName.sendKeys(RandomFirstName);
        Email.sendKeys(RandomEmail);
        ConfirmEmail.sendKeys(RandomEmail);
        Pass.sendKeys(Password);
        ConfirmPass.sendKeys(Password);

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();

    }


    @And("I press Confirm and join")
    public void iPressConfirmAndJoin() {
        WebElement Join = waitForClickableElement(By.name("join"));
        Join.click();
    }

    @Then("I successfully become a member")
    public void iSuccessfullyBecomeAMember() throws InterruptedException {
        Thread.sleep(2000);

        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/h2")).getText();
        assertEquals(expected, actual);
        System.out.println("User registered. " + actual);
        driver.quit();
    }


    @When("I fill in the correct member details but password don't match")
    public void iFillInTheCorrectMemberDetailsButPasswordDonTMatch() {

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys(RandomBirthDate + Keys.ENTER);
        FirstName.sendKeys(RandomFirstName);
        LastName.sendKeys(RandomLastName);
        Email.sendKeys(RandomEmail);
        ConfirmEmail.sendKeys(RandomEmail);
        Pass.sendKeys(Password);
        ConfirmPass.sendKeys(Password + "123");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();

    }

    @When("I fill in the correct member details but Term and conditions not selected")
    public void iFillInTheCorrectMemberDetailsButTermAndConditionsNotSelected() {

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        WebElement Pass = driver.findElement(By.id("signupunlicenced_password"));
        WebElement ConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));

        DOB.sendKeys(RandomBirthDate + Keys.ENTER);
        FirstName.sendKeys(RandomFirstName);
        LastName.sendKeys(RandomLastName);
        Email.sendKeys(RandomEmail);
        ConfirmEmail.sendKeys(RandomEmail);
        Pass.sendKeys(Password);
        ConfirmPass.sendKeys(Password);

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();


    }

    @Then("I see the error message for the lastname missing")
    public void iSeeTheErrorMessageForTheLastnameMissing() {
        String expected = "Last Name is required";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered. " + actual);
        driver.quit();
    }

    @Then("I see the error message for the passowrd")
    public void iSeeTheErrorMessageForThePassowrd() {
        String expected = "Password did not match";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered. " + actual);
        driver.quit();
    }


    @Then("I see the error message for the term and condition")
    public void iSeeTheErrorMessageForTheTermAndCondition() {
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered. " + actual);
        driver.quit();
    }
}


