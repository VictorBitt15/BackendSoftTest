package pagesobjects;

import org.openqa.selenium.WebDriver;

public class FormObject {
	private WebDriver driver;
	private String baseURL = "http://localhost:8080/activiti-app/editor/#/forms";

	public FormObject(WebDriver driver) {
		this.driver = driver;
		driver.get(baseURL);
	}
	
}
