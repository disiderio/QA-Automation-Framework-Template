import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "myNewPlaylist";
    @Test
    // Test case name: renamePlaylist()
    public void renamePlaylist() {

        // Verify that notification message says "Updated playlist myNewPlaylist."
        String renamedPlaylistNotification = "Updated playlist \"myNewPlaylist.\"";

        // Login with credentials
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        // Double-click the playlist you want to rename. "Playlist1"
        doubleClickPlaylist();

        // Enter new Playlist name. "myNewPlaylist"
        enterNewPlaylistName();

        // Verify the notification message appears
        Assert.assertEquals(getRenamedPlaylistNotification(), renamedPlaylistNotification);
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/70514']")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        // clear() does not work, element has an attribute of "required".
        // Workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name.
        // playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE)); using this code renames Playlist1 improperly.
        actions.doubleClick(playlistInputField).perform();

        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamedPlaylistNotification() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}