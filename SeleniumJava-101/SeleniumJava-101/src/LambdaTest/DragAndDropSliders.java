package LambdaTest;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropSliders {
	@Test
	public void setUp() throws MalformedURLException {
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "subhadeepsenapati2003");
		ltOptions.put("accessKey", "LT_TloUaXebyVXxucwl0AazBEvsc2IiuRs4qEX3PfW3HSBD3da");
		ltOptions.put("geoLocation", "IN");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("resolution", "1024x768");
		ltOptions.put("network", true);
		ltOptions.put("build", "Seleniumjava Test");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("accessibility", true);
		browserOptions.setCapability("LT:Options", ltOptions);


		WebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);

		driver.get("https://www.lambdatest.com/selenium-playground");

		driver.findElement(By.linkText("Drag & Drop Sliders")).click();

		WebElement slider = driver.findElement(By.xpath("(//input[@type='range'])[3]"));

		Actions action = new Actions(driver);

		action.dragAndDropBy(slider, 200, 0).perform();

		WebElement rangeValue = driver.findElement(By.id("rangeSuccess"));
		Assert.assertEquals(rangeValue.getText(), "100");

		driver.quit();

	}
}
