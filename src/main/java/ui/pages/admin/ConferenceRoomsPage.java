package ui.pages.admin;
import entities.ResourceEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.common.CommonMethods;
/**
 * Created by ArielWagner on 07/12/2015.
 */
public class ConferenceRoomsPage extends MainAdminPage {
    @FindBy(xpath = "//div[@id = 'roomsGrid']")
    WebElement roomsGridContainer;
    @FindBy(xpath = "//div[contains(text(), 'Room successfully Modified')]")
    WebElement roomModifiedMessagePopUp;
    By roomNameLbl;
    /**
     * This method is the constructor
     */
    public ConferenceRoomsPage() {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(roomsGridContainer));
    }
    /**
     * This method allows selectRoom for edit
     * @param room
     * @return the RoomInfo page
     */
    public RoomInfoPage selectRoom(String room){
        roomNameLbl = By.xpath("//span[2][contains(text(), '"+ room +"')]");
        CommonMethods.doubleClick(driver.findElement(roomNameLbl));
        return new RoomInfoPage();
    }
    /**
     * This method allows get the message displayed after of edit a room
     * @return a String
     */
    public String getRoomModifiedMessagePopUp() {
        return roomModifiedMessagePopUp.getText();
    }

    public boolean isResourceButtonPresent(ResourceEntity resource)
    {
        return isPresent(By.xpath("//div[@class='row']//span[text()='" + resource.getDisplayName() + "']"));
    }
}