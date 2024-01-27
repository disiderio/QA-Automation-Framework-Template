package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
  
    @FindBy(css = "a[href='#!/playlist/74151']")
    WebElement firstPlaylist;
    // By firstPlaylist = By.cssSelector("a[href='#!/playlist/74151']");

    @FindBy(css = "[name='name']")
    WebElement playlistNameField;
    //By playlistNameField = By.cssSelector("[name='name']");

    @FindBy(css = "div.success.show")
    WebElement renamedPlaylistNotification;
    //By renamedPlaylistNotification = By.cssSelector("div.success.show");

    public void doubleClickPlaylist() {
        //actions.doubleClick(firstPlaylist);
        doubleClick(firstPlaylist);
    }

    public void enterNewPlaylistName(String newPlaylistName) {
        // playlistNameField.findElement(null);
        findElement(playlistNameField);
        //actions.doubleClick(playlistNameField);
        doubleClick(playlistNameField);

        playlistNameField.sendKeys(newPlaylistName);
        //findElement(playlistNameField).sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
        // findElement(playlistNameField).sendKeys(Keys.ENTER);
    }


    public String getRenamedPlaylistNotification() {
        return findElement(renamedPlaylistNotification).getText();
    }

}





