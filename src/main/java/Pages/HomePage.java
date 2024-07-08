package Pages;

import Base.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JsonReader;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    private WebElement insuranceButton;
    private WebElement sendMenu;
    private List<WebElement> adCloseButtons;
    private JsonReader jsonReader;

    public HomePage(WebDriver driver) {
        super(driver);
        jsonReader = new JsonReader("Data/locators.json");
        initLocators();
    }

    private void initLocators() {
        insuranceButton = driver.findElement(By.xpath(jsonReader.getLocator("HomePage", "insuranceButton")));
        sendMenu = driver.findElement(By.xpath(jsonReader.getLocator("HomePage", "sendMenu")));
        adCloseButtons = driver.findElements(By.xpath(jsonReader.getLocator("HomePage", "adCloseButtons")));

    }

    @Step("Close advertisement if present")
    public void closeAdvertisementIfPresent() {
        if (!adCloseButtons.isEmpty()) {
            scrollIntoView(adCloseButtons.get(0));
            waitAndClick(adCloseButtons.get(0));
            Allure.addAttachment("Advertisement Status", "Advertisement closed");
        } else {
            Allure.addAttachment("Advertisement Status", "No advertisement present");
        }
    }

    @Step("Click on 'Buy Insurance' button")
    public InsurancePage clickByInsuranceButton(){
        click(insuranceButton);
        Allure.addAttachment("Button Clicked", "Insurance Button");
        return new InsurancePage(driver);
    }

    public void scrollToTargetText(String targetText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", targetText);
    }

    @Step("Navigate to Parcel page")
    public void navigateToParcelpage() throws InterruptedException {

        new WebDriverWait(driver, Duration.ofSeconds(10));

        // Hover over the "Send" menu
        wait.until(ExpectedConditions.visibilityOf(sendMenu));
        Actions actions = new Actions(driver);
        actions.moveToElement(sendMenu).perform();

        // Click the "Parcel" submenu
        sendMenu.click();
        Allure.addAttachment("Navigation", "Navigated to Parcel page");

    }

}
