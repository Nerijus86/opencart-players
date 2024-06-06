package lt.techin.nz;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MP3PlayersPage extends BasePage {
    public MP3PlayersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".fa-table-list")
    WebElement buttonShowItemsAsLis;

    public void setButtonShowItemsAsLis() {

        new Actions(driver).scrollToElement(buttonShowItemsAsLis).perform();
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(buttonShowItemsAsLis));
//        wait.until(ExpectedConditions.elementToBeClickable(buttonShowItemsAsLis));
//        wait.until(d -> buttonShowItemsAsLis.isDisplayed());
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    buttonShowItemsAsLis.click();
                    return true;
                });

        buttonShowItemsAsLis.click();
    }

    public boolean getResultIsElementDisplayed(String itemName) {
        return driver.findElement(By.linkText(itemName)).isDisplayed();
    }

}
