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
import pagesobjects.DecisionObject;
import pagesobjects.FormObject;
import pagesobjects.ModelObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {
	
	private static WebDriver driver;
	private AppObject appObject;
	private DecisionObject decisionObject;
	private FormObject formObject;
	private ModelObject modelObject;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.modelObject = new ModelObject(driver);
		this.formObject = new FormObject(driver);
		this.decisionObject = new DecisionObject(driver);
		this.appObject = new AppObject(driver);
	}
	
	/**
	 * Funcionalidades da Modelagem de modelos
	 */
	@Test
	public void Processo2Sucesso() {
		assertTrue(this.modelObject.createProcessSucess());
	}
	@Test
	public void Processo1Fail() {
		assert(this.modelObject.createProcessFail());
	}
	@Test
	public void Processo3SameKEY() {
		assert(this.modelObject.createProcessSameKEY());
	}
	/**
	 * Funcionalidades da Formularios
	 */
	@Test
	public void FormSucess() {
		
	}
	/**
	 * Funcionalidades da Tabelas de decisão
	 */
	@Test
	public void test3() {
		
	}
	/**
	 * Funcionalidades da Apps
	 */
	@Test
	public void test4() {
		
	}
	@After
	public void tearDown() {
		driver.close();
	}
}
