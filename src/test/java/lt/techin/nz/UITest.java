package lt.techin.nz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

public class UITest extends BaseTest {


    @Test
    void firstTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.setButtonMP3Players();
        mainPage.setButtonShowAllMP3Players();
        mainPage.setButtonShowItemsAsLis();

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/test-data.csv")
    void itemsCheck(String itemName) {
        MainPage mainPage = new MainPage(driver);
        mainPage.setButtonMP3Players();
        mainPage.setButtonShowAllMP3Players();
        mainPage.setButtonShowItemsAsLis();
        Assertions.assertTrue(driver.findElement(By.linkText(itemName)).isDisplayed());
    }
}
