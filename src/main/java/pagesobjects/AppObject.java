package pagesobjects;

import org.openqa.selenium.WebDriver;

public class AppObject {

	private WebDriver driver;
	private String baseURL="http://localhost:8080/activiti-app/editor/#/apps";
	public AppObject(WebDriver driver) {
		super();
		this.driver = driver;
		driver.get(baseURL);
	}
	
}
