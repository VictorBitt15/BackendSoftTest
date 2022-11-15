package pagesobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ModelObject {
	private WebDriver driver;
	private String baseURL = "http://localhost:8080/activiti-app/editor/#/processes";

	public ModelObject(WebDriver driver) {
		this.driver = driver;
		driver.get(baseURL);
	}

	/*
	 * Criação normal do modelo
	 */
	public boolean createProcessSucess() {
		this.credenciais();
		driver.get("http://localhost:8080/activiti-app/#/");
		driver.findElement(By.id("kickstart")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("create")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("newProcessName")).sendKeys("BPMN 1");
		driver.findElement(By.id("newProcessKey")).sendKeys("BPMN1");
		driver.findElement(By.id("newProcessDescription")).sendKeys("Modelo de négocios BPMN");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver.findElement(By.className("editor-icon-save")).isDisplayed();
	}

	/*
	 * Tentativa de criar modelo com mesma key
	 * 
	 */
	public boolean createProcessSameKEY() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("create")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("newProcessName")).sendKeys("BPMN 1");
		driver.findElement(By.id("newProcessKey")).sendKeys("BPMN1");
		driver.findElement(By.id("newProcessDescription")).sendKeys("Modelo de négocios BPMN");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver.findElement(By.className("popup-error")).isDisplayed();
	}

	/*
	 * Tentativa de criar modelo sem dados
	 * 
	 */
	public boolean createProcessFail() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("create")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("newProcessName")).sendKeys("");
		driver.findElement(By.id("newProcessKey")).sendKeys("");
		driver.findElement(By.id("newProcessDescription")).sendKeys("");
		try {
			driver.findElement(By.id("confirm")).click();
		} catch (ElementClickInterceptedException e) {
			driver.findElement(By.id("cancel")).click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver.findElement(By.className("help-text")).isDisplayed();
	}

	/*
	 * Após salvar modelo verificar.
	 **/
	public boolean saveModelSucess() {
		this.credenciais();
		driver.get(baseURL);
		int qtdinicial = driver.findElements(By.className("item-wrapper")).size();
		System.out.println(qtdinicial);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("create")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("newProcessName")).sendKeys("BPMN");
		driver.findElement(By.id("newProcessKey")).sendKeys("BPMN");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("save")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.id("save")).click();
		driver.findElement(By.id("docTextArea")).sendKeys("Modelo de négocios BPMN1");
		driver.findElement(By.className("saveclose")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		return driver.findElement(By.className("item-box")).isEnabled();

	}

	/*
	 * Após salvar modelo verificar erro.
	 **/
	public boolean saveModelFail() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("item-box")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("edit")).click();
		driver.findElement(By.id("editProcessKey")).sendKeys("1");
		driver.findElement(By.id("save")).click();
		return driver.findElement(By.className("popup-error")).isDisplayed();

	}

	/*
	 * Vinculando um model a um app, e tentando deletar
	 */
	public boolean deleteModelFail() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("item-box")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("trash")).click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return !driver.findElement(By.className("btn-danger")).isEnabled();
	}

	/*
	 * Deletando modelo após criação
	 */
	public boolean deleteModelSucess() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("item-box")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("trash")).click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("btn-danger")).click();
		return !driver.findElement(By.className("item-box")).isDisplayed();
	}

	public void credenciais() {
		driver.get("localhost:8080/activiti-app/#/login");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
