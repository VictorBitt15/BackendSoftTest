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
import pagesobjects.DecisionObject;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DecisionTest {
	private static WebDriver driver;
	private DecisionObject decisionObject;

	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.decisionObject = new DecisionObject(driver);
	}
	/**
	 * Funcionalidades da Tabelas de decisão
	 */
	@Test
	public void TestDecision1Sucess() {
		assertTrue(this.decisionObject.createDecisionSucess());
	}
	@Test
	public void TestDecision2Alter() {
		assertTrue(this.decisionObject.alterDecisionSucess());
	}
	@Test
	public void TestDecision3Delete() throws InterruptedException {
		assertTrue(this.decisionObject.deleteDecisonSucess());
	}
	@After
	public void tearDown() {
		driver.close();
	}
}
