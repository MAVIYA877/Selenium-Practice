package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAutomationTest {

    @Test
    public void loginTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().window().maximize();

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement element =
                    wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                            By.name("username")
                        )
                    );

            Assert.assertTrue(
                element.isDisplayed(),
                "Username field was not displayed"
            );

        } finally {

            driver.quit();
        }
    }
}