import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework24 extends BaseTest {


    @Test
    // Test case name: renamePlaylist()
    public void renamePlaylist(){
        String newPlaylistName = "myNewPlaylist";
        // Verify that notification message says "Updated playlist myNewPlaylist."
        String renamedPlaylistNotification = "Updated playlist \"myNewPlaylist.\"";

        // Login with credentials
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        // Double-click the playlist you want to rename. "Playlist1"
        homePage.doubleClickPlaylist();

        // Enter new Playlist name. "myNewPlaylist"
        homePage.enterNewPlaylistName(newPlaylistName);

        // homePage.doubleClickPlaylist().enterNewPlaylistName(newPlaylistName);

        // Verify the notification message appears
        Assert.assertEquals(homePage.getRenamedPlaylistNotification(), renamedPlaylistNotification);

    }



}