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
import pagesobjects.ModelObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {
	
	private static WebDriver driver;
	private ModelObject modelObject;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.modelObject = new ModelObject(driver);
	}
	
	/**
	 * Funcionalidades da Modelagem de modelos
	 */
	@Test
	public void Test2ModelSucesso() {
		assertTrue(this.modelObject.createProcessSucess());
	}
	@Test
	public void Test1ModelFail() {
		assert(this.modelObject.createProcessFail());
	}
	@Test
	public void Test3ModelSameKEY() {
		assertTrue(this.modelObject.createProcessSameKEY());
	}
	@Test
	public void Test4ModelSucess() {
		assertTrue(this.modelObject.saveModelSucess());
	}
	@Test
	public void Test5ModelFail() {
		assertTrue(this.modelObject.saveModelFail());
	}
	@Test
	public void Test6DeleteSucess() {
		assertTrue(this.modelObject.deleteModelSucess());
	}
	public void TestDeleteFail() {
		assertTrue(this.modelObject.deleteModelFail());
	}
	
	
	
	
	
	@After
	public void tearDown() {
		driver.close();
	}
}
