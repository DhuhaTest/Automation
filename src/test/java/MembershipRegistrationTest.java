import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MembershipRegistrationTest {
    @Test
    public void RegistrationTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        Thread.sleep(2000);

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
        Thread.sleep(2000);

        driver.findElement(By.name("join")).click();
        try {
            WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/h2")));
            System.out.println("Test passed: " + resultMessage.getText());
        } catch (Exception e) {
            System.out.println("Test failed: An error occurred.");
        }
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void RegistrationMissingLastNameTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        Thread.sleep(2000);

        String email = "TestUser" + System.currentTimeMillis() + "@provko.com";

        WebElement DOB = driver.findElement(By.id("dp"));
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
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

        driver.findElement(By.name("join")).click();

        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span")));
            if (errorMessage != null && errorMessage.isDisplayed()) {
                System.out.println("Test passed " + errorMessage.getText());
            } else {
                System.out.println("Test failed: No error message for missing last name.");
            }
        } catch (Exception e) {
            System.out.println("Test failed: Error message did not appear as expected.");
        }
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void PasswordDidNotMatch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        Thread.sleep(2000);

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
        ConfirmPass.sendKeys("12344");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']")).click();

        driver.findElement(By.cssSelector(".btn")).click();
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span")));
            if (errorMessage != null && errorMessage.isDisplayed()) {
                System.out.println("Test passed " + errorMessage.getText());
            } else {
                System.out.println("Test failed: No error message for password did not match.");
            }
        } catch (Exception e) {
            System.out.println("Test failed: Error message did not appear as expected.");
        }
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void TermAndConditionNotSelected() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

        Thread.sleep(2000);

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

        driver.findElement(By.name("join")).click();

        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span")));
            if (errorMessage != null && errorMessage.isDisplayed()) {
                System.out.println("Test passed " + errorMessage.getText());
            } else {
                System.out.println("Test failed: No error message for missing for term and condition.");
            }
        } catch (Exception e) {
            System.out.println("Test failed: Error message did not appear as expected.");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}