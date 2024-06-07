package lt.techin.nz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-quantity")
    WebElement fieldQuantity;
    @FindBy(id = "button-cart")
    WebElement buttonAdToCart;
    @FindBy(id = "alert")
    WebElement alertSuccess;
    @FindBy(css = ".price-new")
    WebElement fieldPrice;
    @FindBy(css = ".btn-inverse")
    WebElement buttonShoppingCart;

    public void setFieldQuantity(int quantityOfItems) {
        fieldQuantity.clear();
        fieldQuantity.sendKeys(String.valueOf(quantityOfItems));
    }

    public void setButtonAdToCart() {
        new Actions(driver).scrollToElement(buttonAdToCart).perform();
        buttonAdToCart.click();
    }

    public String getAlertText() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> alertSuccess.isDisplayed());
        return alertSuccess.getText();
    }

    public String getButtonShoppingCartText() {
        return buttonShoppingCart.getText();
    }

    public int getItemPrice() {
        return Integer.valueOf(fieldPrice.getText().substring(1, fieldPrice.getText().length() - 3));
    }

}
