package pagesobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppObject {

	private WebDriver driver;
	private String baseURL="http://localhost:8080/activiti-app/editor/#/apps";
	public AppObject(WebDriver driver) {
		super();
		this.driver = driver;
		driver.get(baseURL);
	}
	public boolean createAppSucess() {
		this.credenciais();
		driver.get(this.baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("create")).click();
		driver.findElement(By.id("newAppName")).sendKeys("App");
		driver.findElement(By.id("newAppKey")).sendKeys("App");
		driver.findElement(By.id("newAppDescription")).sendKeys("App de gerenciamento");
		driver.findElement(By.id("confirm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("addmodel")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("item-box")).click();
		driver.findElement(By.id("close")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("editor-icon-save")).click();
		driver.findElement(By.id("saveclose")).click();
		return driver.findElement(By.className("app")).isEnabled();
	}
	public void credenciais() {
		driver.get("localhost:8080/activiti-app/#/login");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
}
