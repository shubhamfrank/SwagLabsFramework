/**
 * 
 */
package com.SwagLabs.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SwagLabs.qa.utilities.TestUtil;

/**
 * @author sshukla This is the Base Class for Swag Labs module testing
 */
public class SwagLabsBaseClass {

	static WebDriver driver;
	static Properties prop;

	public SwagLabsBaseClass() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/SwagLabsTest/src/main/java/com/SwagLabs/qa/config/config.properties");
			prop.load(ip);
		}

		catch (IOException f) {
			// TODO: handle exception
		}
	}

	public static int initializeParameters() {

		String browserName = prop.getProperty("browser");
		String urlDirect = prop.getProperty("url");
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");

		System.out.println(browserName);
		System.out.println(urlDirect);
		System.out.println("Logged in as user : " + uname);

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\QA Dumps\\Testing_Training\\Automation\\Utilities\\chromedriver_win32");
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(urlDirect);

		return 0;

	}

}
