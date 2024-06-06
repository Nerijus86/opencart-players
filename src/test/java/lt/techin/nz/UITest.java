package lt.techin.nz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UITest extends BaseTest {


    @Test
    void firstTest() {
        MainPage mainPage = new MainPage(driver);
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        mainPage.setButtonMP3Players();
        mainPage.setButtonShowAllMP3Players();
        mp3PlayersPage.setButtonShowItemsAsLis();

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/test-data.csv")
    void itemsCheck(String itemName) {
        MainPage mainPage = new MainPage(driver);
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        mainPage.setButtonMP3Players();
        mainPage.setButtonShowAllMP3Players();
        mp3PlayersPage.setButtonShowItemsAsLis();
        assertTrue(mp3PlayersPage.getResultIsElementDisplayed(itemName));
    }
}
