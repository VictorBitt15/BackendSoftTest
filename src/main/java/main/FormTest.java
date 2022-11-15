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
import pagesobjects.FormObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormTest {
	
	private static WebDriver driver;
	private FormObject formObject;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.formObject = new FormObject(driver);

	}
	/**
	 * Funcionalidades da Formularios
	 */
	@Test
	public void Test7FormSucess() {
		assertTrue(this.formObject.createFormSucess());
	}
	@Test
	public void Test8FormSucessSame() {
		assertTrue(this.formObject.createFormSameKEY());
	}
	@Test
	public void Test9FormDelete() {
		assertTrue(this.formObject.deleteFormSucess());
	}
	@After
	public void tearDown() {
		driver.close();
	}
}
