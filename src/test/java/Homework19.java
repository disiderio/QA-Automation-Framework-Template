import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



public class Homework19 extends BaseTest {
    @Test
    // Test case name: deletePlaylist()
    public void deletePlaylist() throws InterruptedException {

        // Verify that notification message says "Added 1 song into" {unique name playlist}
        String deletedPlaylistNotification = "Deleted playlist \"Playlist1.\"";

        // Login with credentials
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        // Click the playlist you want to delete. "Playlist1"
        clickPlaylistButton();

        // click on red X button to delete
        clickXButton();

        // Verify the notification message appears
        Assert.assertTrue(getDeletedPlaylistNotification().contains(deletedPlaylistNotification));
    }

    public void clickPlaylistButton() throws InterruptedException {
        WebElement nextSongButton = driver.findElement(By.cssSelector("a[href='#!/playlist/70332']"));
        nextSongButton.click();
    }

    public void clickXButton() throws InterruptedException {
        WebElement playButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        playButton.click();
        Thread.sleep(1000);
    }

    public String getDeletedPlaylistNotification() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}