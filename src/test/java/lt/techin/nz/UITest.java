package lt.techin.nz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class UITest extends BaseTest {

    void baseForTests() {
        MainPage mainPage = new MainPage(driver);
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        mainPage.setButtonMP3Players();
        mainPage.setButtonShowAllMP3Players();
        mp3PlayersPage.setButtonShowItemsAsLis();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/test-data.csv")
    void isProductDisplayedOnTheScreenAndNameMatches(String itemName) {
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        baseForTests();
        assertTrue(mp3PlayersPage.getResultIsElementDisplayed(itemName), "Product is not displayed on the screen or name is not matches!");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/test-data.csv")
    void isInfoMessageContainingExpectedText(String itemName) {
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        ItemPage itemPage = new ItemPage(driver);
        baseForTests();
        mp3PlayersPage.setLinkItem(itemName);
        int quantityOfItems = (int) (Math.random() * 20 + 1);
        itemPage.setFieldQuantity(quantityOfItems);
        itemPage.setButtonAdToCart();
        assertTrue(itemPage.getAlertText().contains("You have added " + itemName + " to your shopping cart!"), "Info message is not containing expected text!");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/test-data.csv")
    void isItemSuccessfullyAddedIntoShoppingCart(String itemName) throws InterruptedException {
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        ItemPage itemPage = new ItemPage(driver);
        baseForTests();
        mp3PlayersPage.setLinkItem(itemName);
        int quantityOfItems = (int) (Math.random() * 20 + 1);
        itemPage.setFieldQuantity(quantityOfItems);
        itemPage.setButtonAdToCart();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String total = numberFormat.format((long) itemPage.getItemPrice() * quantityOfItems);
        assertEquals(quantityOfItems + " item(s) - $" + total + ".00", itemPage.getButtonShoppingCartText(), "Item is not successfully added into shopping cart!");
    }

}
