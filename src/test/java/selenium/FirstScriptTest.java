package selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Maicon Fang
 * 
 */
public class FirstScriptTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void exampleTest() {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		String title = driver.getTitle();
		assertEquals("Web form", title);

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));

		textBox.sendKeys("Selenium");
		submitButton.click();

		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		assertEquals("Received!", value);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
