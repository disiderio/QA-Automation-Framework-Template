import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {

        // Navigate to "https://qa.koel.app
        navigateToPage();

        // Login with credentials
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        // Click Play next song button
        playNextSongButton();

        // Click Play button
        clickPlayButton();

        // Validate Pause button is displayed
        Assert.assertTrue(pauseButtonDisplay());
    }

    public void playNextSongButton() throws InterruptedException {
        WebElement nextSongButton = driver.findElement(By.cssSelector("i[title='Play next song']"));
        nextSongButton.click();
        Thread.sleep(2000);
    }

    public void clickPlayButton() throws InterruptedException {
        WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(2000);
    }

    public boolean pauseButtonDisplay() {
        WebElement pauseButton = driver.findElement(By.cssSelector("span[data-testid='pause-btn'"));
        return pauseButton.isDisplayed();
    }

}
