package pagesobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DecisionObject {
	private WebDriver driver;
	private String baseURL="http://localhost:8080/activiti-app/editor/#/decision-tables";
	public DecisionObject(WebDriver driver) {
		this.driver = driver;
		driver.get(baseURL);
	}
	public boolean createDecisionSucess() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("create")).click();
		driver.findElement(By.id("newDecisionTableName")).sendKeys("Decision");
		driver.findElement(By.id("newDecisionTableKey")).sendKeys("Decision");
		driver.findElement(By.id("newDecisionTableDescription")).sendKeys("Tabela de decisão");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("editor-icon-save")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("decisiontableDescription")).sendKeys("Decision alterado");
		driver.findElement(By.id("saveclose")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver.findElement(By.className("item-box")).isEnabled();
	}
	public boolean alterDecisionSucess() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("create")).click();
		driver.findElement(By.id("newDecisionTableName")).sendKeys("Decision1");
		driver.findElement(By.id("newDecisionTableKey")).sendKeys("Decision1");
		driver.findElement(By.id("newDecisionTableDescription")).sendKeys("Tabela de decisão");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("createinput")).click();
		driver.findElement(By.id("createoutput")).click();
		driver.findElement(By.id("addRule")).click();
		driver.findElement(By.id("save")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("saveclose")).click();
		
		return driver.findElement(By.className("item-box")).isEnabled();
		
	}
	public boolean deleteDecisonSucess() throws InterruptedException {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("item-box")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("trash")).click();
		driver.findElement(By.className("btn-danger")).click();
		
		Thread.sleep(2500);
		
		driver.findElement(By.className("item-box")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("trash")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("btn-danger")).click();
		return driver.findElement(By.id("createDecision")).isDisplayed();
	}
	public void credenciais() {
		driver.get("localhost:8080/activiti-app/#/login");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
}
