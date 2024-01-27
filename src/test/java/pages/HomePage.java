package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By firstPlaylist = By.cssSelector("a[href='#!/playlist/70755']");
    By playlistNameField = By.cssSelector("[name='name']");
    By renamedPlaylistNotification = By.cssSelector("div.success.show");

    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }

    public void enterNewPlaylistName(String newPlaylistName) {
        findElement(playlistNameField);
        doubleClick(playlistNameField);
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }


    public String getRenamedPlaylistNotification() {
        return findElement(renamedPlaylistNotification).getText();
    }

}





