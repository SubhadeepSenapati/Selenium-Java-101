package LambdaTest;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputFormSubmit {
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

		driver.findElement(By.linkText("Input Form Submit")).click();

		WebElement submitBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		submitBtn.click();

		WebElement nameField = driver.findElement(By.id("name"));
		String validationMsg = nameField.getAttribute("validationMessage");

		Assert.assertEquals(validationMsg, "Please fill out this field.");

		nameField.sendKeys("Subhadeep");
		driver.findElement(By.id("inputEmail4")).sendKeys("subhadeep@test.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("77358249");
		driver.findElement(By.id("company")).sendKeys("LambdaTest");
		driver.findElement(By.name("website")).sendKeys("https://www.linkedin.com/in/subhadeep003/");

		Select countryDrop = new Select(driver.findElement(By.name("country")));
		countryDrop.selectByVisibleText("India");

		driver.findElement(By.id("inputCity")).sendKeys("Banguluru");
		driver.findElement(By.id("inputAddress1")).sendKeys("BTM 2ndStage");
		driver.findElement(By.id("inputAddress2")).sendKeys("SVLNS PG2");
		driver.findElement(By.id("inputState")).sendKeys("Karnataka");
		driver.findElement(By.id("inputZip")).sendKeys("560076");

		submitBtn.click();

		WebElement successText = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us')]"));

		Assert.assertEquals(successText.getText().trim(), "Thanks for contacting us, we will get back to you shortly.");

		driver.quit();

	}
}