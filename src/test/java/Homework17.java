import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        // Verify that notification message says "Added 1 song into" {unique name playlist}
        String newSongAddedNotification = "Added 1 song into";

        // Navigate to "https://qa.koel.app
        navigateToPage();

        // Login with credentials
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        // Search for a song
        searchSong("Algorithms");

        // Click "View All" to display the search result
        clickViewAllButton();

        // Click the first song in the search results
        selectFirstSong();

        // Click "ADD TO"
        clickAddTo();

        // Chose a playlist to add it to (crease one with unique name)
        choosePlaylist();

        // Verify the notification message appears
        Assert.assertTrue(getAddToPlaylistSuccessMsg().contains(newSongAddedNotification));
    }

    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAllButton() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddTo() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addTo.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {
        //created a playlist named "dcsPlaylist"
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Edited Playlist 10')]"));
        playlist.click();
        Thread.sleep(2000);
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }


}
