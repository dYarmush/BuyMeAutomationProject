package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSingleton;
import java.time.Duration;

/**
 * RegistrationPage extends BasePage
 * Clicks on register/Signin and can either login or register new account.
 */

public class RegistrationPage extends BasePage {

    private WebDriver driver= DriverSingleton.getDriverInstance();

    /**
     * Method that calls all the other functionalities.
     */
    public void register(){
        beginRegistration();
        login();
        //signup();
    }

    /**
     * Login method to login using the given username.
     */
    private void login(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        sendKeys(By.cssSelector("input[placeholder='מייל'"),"UN");
        sendKeys(By.cssSelector("input[placeholder='סיסמה'"),"PW");
        clickOnElement(By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg']"));
        clickOnElement(By.cssSelector("button[type='submit']"));

    }

    /**
     *Clicks on the register/sign-in button.
     */
    public void beginRegistration() {
        clickOnElement(By.cssSelector("li[class='notSigned']"));
    }

    /**
     * Creates a new user using given details. Fails since user is already in the system.
     * Therefore, it is not called upon.
     */
    private void signup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickOnElement(By.cssSelector("span[class='text-link theme']"));

        //name
        sendKeys(By.cssSelector("input[placeholder='שם פרטי'"),"Ozzy");
        Assert.assertEquals(getWebElement(By.cssSelector("input[placeholder='שם פרטי'")).getAttribute("value"),"Ozzy");
        //email
        sendKeys(By.cssSelector("input[placeholder='מייל'"),"EMAIL");
          Assert.assertEquals(getWebElement(By.cssSelector("input[placeholder='מייל'")).getAttribute("value"),"EMAIL");
//        //password
       sendKeys(By.id("valPass"),"PW");

//        //verify PW
       sendKeys(By.cssSelector("input[placeholder='אימות סיסמה'"),"PW");
//        //Agreement
        clickOnElement(By.className("fill"));

//        //signup button
        clickOnElement(By.cssSelector("button[type='submit']"));
    }
}
