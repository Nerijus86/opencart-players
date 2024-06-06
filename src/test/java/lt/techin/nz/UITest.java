package lt.techin.nz;

import org.junit.jupiter.api.Test;

import java.time.Duration;

public class UITest extends BaseTest {


    @Test
    void firstTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.setButtonMP3Players();
        mainPage.setButtonShowAllMP3Players();
        mainPage.setButtonShowItemsAsLis();
        Thread.sleep(Duration.ofSeconds(5));//ištrinti
    }
}
