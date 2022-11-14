package pagesobjects;

import org.openqa.selenium.WebDriver;

public class DecisionObject {
	private WebDriver driver;
	private String baseURL="http://localhost:8080/activiti-app/editor/#/decision-tables";
	public DecisionObject(WebDriver driver) {
		this.driver = driver;
		driver.get(baseURL);
	}
	
}
