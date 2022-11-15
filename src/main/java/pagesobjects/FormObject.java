package pagesobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormObject {
	private WebDriver driver;
	private String baseURL = "http://localhost:8080/activiti-app/editor/#/forms";

	public FormObject(WebDriver driver) {
		this.driver = driver;
		driver.get(baseURL);
	}
	public boolean createFormSucess() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("createform")).click();
		driver.findElement(By.id("newFormName")).sendKeys("Form1");
		driver.findElement(By.id("newFormKey")).sendKeys("Form1");
		driver.findElement(By.id("newFormDescription")).sendKeys("Modelo de formulário");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("editor-icon-save")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("formDescription")).sendKeys("Formulário alterado");
		driver.findElement(By.id("saveclose")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver.findElement(By.className("item-box")).isEnabled();
	}
	public boolean createFormSameKEY() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("createform")).click();
		driver.findElement(By.id("newFormName")).sendKeys("Form1");
		driver.findElement(By.id("newFormKey")).sendKeys("Form1");
		driver.findElement(By.id("newFormDescription")).sendKeys("Modelo de formulário");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver.findElement(By.className("popup-error")).isDisplayed();
		
	}
	public boolean deleteFormSucess() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("item-box")).click();
		driver.findElement(By.className("glyphicon-trash")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("btn-danger")).click();
		return driver.findElement(By.className("ng-hide")).isEnabled();
	}
	public void credenciais() {
		driver.get("localhost:8080/activiti-app/#/login");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
