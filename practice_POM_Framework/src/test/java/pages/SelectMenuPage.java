package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverUtils;

public class SelectMenuPage {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver;

    public SelectMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By selectValueMenu = By.xpath("//div[contains(@class,'css-1hwfws3')]");
    By selectOneMenu = By.xpath("//div[@id='selectOne']//div[contains(@class, '-control')]");
    By oldStyleMenu = By.xpath("//select[@id='oldSelectMenu']");
    By multiSelectMenu = By.xpath("//div[@id='selectMenuContainer']//div[@class='row']//div[contains(@class,'css-1hwfws3')]");
    By standardMultiSelectMenu = By.xpath("//select[@name='cars']");
    By reactDropdownMenu = By.className("css-26l3qy-menu"); // Common dropdown menu class for React dropdowns

    // Select Value Menu
    public void selectValueMenu() {
        logger.info("Select Value Menu Clicked");
        driver.findElement(selectValueMenu).click();

        By option = By.xpath("//div[text()='Group 1, option 1']");
        WebDriverUtils.waitForElementVisible(driver, option, 5).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(reactDropdownMenu));

        logger.info("First dropdown closed successfully.");
    }

    // Select One Menu
    public void selectOneMenu() {
        logger.info("Select One Menu Clicked");

        driver.findElement(selectOneMenu).click();

        By option = By.xpath("//div[text()='Other']");
        WebElement element = WebDriverUtils.waitForElementVisible(driver, option, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(reactDropdownMenu));

        logger.info("Second dropdown closed successfully.");
    }


    // Old Style Select Menu
    public void oldStyleSelectMenu() {
        logger.info("Old Style Select Menu Clicked");
        Select select = new Select(driver.findElement(oldStyleMenu));
        select.selectByVisibleText("Voilet");
        logger.info("Third dropdown closed successfully.");
    }

    public void multiSelectMenu() {
        logger.info("Multi Select Menu Clicked");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Scroll page bottom slowly to force lazy rendering
        js.executeScript("window.scrollBy(0, 500);");
        WebDriverUtils.sleep(1000); // Give time for dropdown to render

        // 2. Locate dropdown via known working XPath
        WebElement dropdown = driver.findElement(By.xpath("//div[@id='selectMenuContainer']//div[@class='row']//div[contains(@class,'css-1hwfws3')]"));

        // 3. Scroll into view (again just to be sure)
        js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
        WebDriverUtils.sleep(500);

        // 4. Click the dropdown
        js.executeScript("arguments[0].click();", dropdown);

        // 5. Select "Blue"
        By optionBlue = By.xpath("//div[contains(@class,'option') and text()='Blue']");
        WebElement blue = WebDriverUtils.waitForElementVisible(driver, optionBlue, 10);
        js.executeScript("arguments[0].click();", blue);

        // 6. Select "Red"
        By optionRed = By.xpath("//div[contains(@class,'option') and text()='Red']");
        WebElement red = WebDriverUtils.waitForElementVisible(driver, optionRed, 10);
        js.executeScript("arguments[0].click();", red);

        // 7. Log and done
        logger.info("Multi-select dropdown actions completed.");
    }




    public void standardMultiSelectMenu() {
        logger.info("Standard Multi Select Menu Clicked");

        WebElement dropdown = driver.findElement(standardMultiSelectMenu);

        // Scroll dropdown into view before working with it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);

        Select select = new Select(dropdown);

        if (select.isMultiple()) {
            select.selectByVisibleText("Volvo");
            select.selectByVisibleText("Saab");
        } else {
            logger.warn("Dropdown does not support multi-select");
        }
        
     // Wait for dropdown to close if needed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(reactDropdownMenu));

        logger.info("5th dropdown closed.");
    }
    
    

 
}
