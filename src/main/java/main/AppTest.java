package main;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pagesobjects.AppObject;
import pagesobjects.ModelObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
	
	
	private static WebDriver driver;
	private AppObject appObject;
	private ModelObject modelObject;
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.appObject = new AppObject(driver);
		this.modelObject= new ModelObject(driver);
	}
	/**
	 * Funcionalidades da Apps
	 */
	@Test
	public void TestAppSucess() {
		assertTrue(this.appObject.createAppSucess());
	}
	@Test
	public void TestDeleteModelFromAppFail() {
		assertTrue(this.modelObject.deleteModelFail());
	}
	@After
	public void tearDown() {
		driver.close();
	}
}
