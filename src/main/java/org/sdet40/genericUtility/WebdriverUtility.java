package org.sdet40.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the WebDriver operations
 * @author Harish
 *
 */
public class WebdriverUtility {
	private JavascriptExecutor js;
	private Actions actions;
	WebDriver driver;
	
	/**
	 * This method is used to launch the browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchingBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Please enter valid browser key");
			break;
		}
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 * 
	 * @param driver
	 * @return
	 */
	public WebDriver maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		return driver;
	}
	
	
	/**
	 * This method is used to specify implicit wait in seconds
	 */
	public void implicitwaitForElement() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstantpath.Implicitly_TIMEOUT));
	}

	
	/**
	 * This method is used to specify explicit wait in seconds until the page is
	 * loaded
	 */
	public void waitForPage(WebDriver driver, String partialPageURL, int timeouts) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.urlContains(partialPageURL));
	}

	/**
	 * This method is always wait for Page to be loaded and till element to be
	 * present
	 */
	public void waitForElement(WebDriver driver, WebElement element, int timeouts) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to open the application using URL
	 * 
	 * @return
	 */
	public WebDriver openApplication(WebDriver driver, String url) {

		driver.get(url);
		return driver;
	}

	/**
	 * This method is used to close the browser
	 */
	public void closeTheBrowser() {
		driver.close();
	}

	/**
	 * This method is used to close all the browsers
	 */
	public void closeAllBrowsers() {
		driver.quit();
	}

	
	/**
	 * This method is used to perform common operation from launching the specified
	 * browser Maximize browser and navigate to the application
	 * 
	 * @param browser
	 * @param url
	 * @return
	 */
	public WebDriver commonForAll(String browser, String url) {
		driver = launchingBrowser(browser);
		maximizeWindow(driver);
		openApplication(driver, url);
		return driver;
	}
	
	
	/**
	 * This method is used to initialize Actions class
	 * @param driver
	 */
	public void initializeAction(WebDriver driver) {
		actions=new Actions(driver);
	}
	
	
	/**
	 * This method is used to place mouse cursor on specified element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		actions.moveToElement(element).perform();
	}

	/**
	 * This method is used to right click on specified element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		actions.contextClick(element).perform();
	}
	
	
	
	
	/**
	 * This method is used to mouse hover to a particular element when horizontal axis and vertical axis is specified
	 */
	public void mouseHoverAction(WebElement element, int horizontalAxis, int verticalAxis) {
		actions.moveToElement(element,horizontalAxis,verticalAxis).perform();
	}

	
	/**
	 * This method is used to Switch to Any Window based on Window Title
	 */
	public void swithToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	
	/**
	 * This method is used to Switch to Alert Window & click on accept button
	 * 
	 * @param driver
	 */
	public void swithToAlertWindowAndAccept(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}


	/**
	 * This method is used to Switch to Alert Window & click on Cancel button
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	/**
	 * This method is used to Switch to Frame Window based on index
	 */
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 *This method is used to Switch to Frame Window based on id or name attribute
	 */
	public void swithToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from the dropDwon based on index
	 */
	public void selectClass(WebElement webelement, int index) {
		Select sel = new Select(webelement);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to select the value from the dropDwon based on value /
	 * option available in GUI
	 */
	public void select(WebElement element, int i) {
		Select sel = new Select(element);
		sel.selectByIndex(i);
	}

	

	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void executeJavaScript(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}

	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * pass enter Key appertain in to Browser
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * 
	 */
	public void impliWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstantpath.Implicitly_TIMEOUT));
	}

	/**
	 * This method is used to take screenshot of failed test scripts along with
	 * date, time,seconds
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	public void screenShot(WebDriver driver,JavaUtility javaUtil,  String className) throws IOException {
		String currentTime = javaUtil.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./SCREENSHOT/" + getClass().getSimpleName() + "_" + currentTime + ".png");
		
			FileUtils.copyFile(src, dst);
		
	}
		
	

	/**
	 * 
	 * @param driver
	 * @return
	 */
//	public String screenShot(WebDriver driver) {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
//		return tempPath;
//	}

	/**
	 * This method is used to convert Dynamic string to WebElement
	 * 
	 * @return
	 */
	public WebElement convertStringToWebElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredPath = String.format(dynamicXpath, replaceData);
		WebElement dynamicElement = driver.findElement(By.xpath(requiredPath));
		return dynamicElement;
	}
	
	/**
	 * This method is used to initialize the javaScriptExecutor
	 */
	public void initializeJSE(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}
	
	/**
	 * This method is used to perform click action using javaScriptExecutor
	 */
	public void clickUsingJSE(WebElement element) {
		js.executeScript("argument[0].click()",element);
	}
	
	/**
	 * This method is used to sendKeys using javaScriptExecutor
	 */
	public void sendKeysUsingJSE(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	
	/**
	 * This method is used to scroll to a particular element using javaScriptExecutor
	 */
	public void scrollUsingJSE(WebElement elementPath) {
		js.executeScript("arguments[0].scrollIntoView()", elementPath);
	}
	
	
	
	
	
	
	/**
	 * This method is used to fetch text from a dynamic element
	 * 
	 * @return
	 */
	public String getTextFromDynamicElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredPath = String.format(dynamicXpath, replaceData);
		String dynamicElement = driver.findElement(By.xpath(requiredPath)).getText();
		return dynamicElement;
	}

	/**
	 * 
	 */
	public void toPerformVerficationByAssertEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	/**
	 * 
	 * @param actual
	 * @param expected
	 */
	public void toperformVerificationByAssertNotEquals(String actual, String expected) {
		Assert.assertNotEquals(actual, expected);
	}

	/**
	 * 
	 * @param element
	 * @param expectedText
	 * @param driver
	 * @param element1
	 */
	public void verifyWebPage(WebElement element, String expectedText, WebDriver driver, WebElement element1) {
		for (;;) {
			try {
				Assert.assertEquals(element.getText(), expectedText);
				break;
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(element1));
			}
		}
	}

	/**
	 * 
	 * @param soft
	 */
	public void softAssertIntiallize(SoftAssert soft) {
		soft = new SoftAssert();
	}

	/**
	 * 
	 * @param soft
	 * @param actual
	 * @param expected
	 */
	public void compareBySoftAssert(SoftAssert soft, String actual, String expected) {
		soft.assertEquals(actual, expected);
	}
	/**
	 * 
	 * @param soft
	 */
	public void softAssertAll(SoftAssert soft) {
		soft.assertAll();
	}

	
}