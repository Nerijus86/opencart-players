package lt.techin.nz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "MP3 Players")
    WebElement buttonMP3Players;
    @FindBy(linkText = "Show All MP3 Players")
    WebElement buttonShowAllMP3Players;
    @FindBy(css = ".fa-table-list")
    WebElement buttonShowItemsAsLis;

    public void setButtonMP3Players() {
        buttonMP3Players.click();
    }

    public void setButtonShowAllMP3Players() {
        buttonShowAllMP3Players.click();
    }

    public void setButtonShowItemsAsLis() {

        new Actions(driver).scrollToElement(buttonShowItemsAsLis).perform();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(buttonShowItemsAsLis));
        buttonShowItemsAsLis.click();
    }

}
