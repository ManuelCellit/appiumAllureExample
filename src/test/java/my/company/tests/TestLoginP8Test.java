package my.company.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import io.appium.java_client.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.junit4.DisplayName;



public class TestLoginP8Test {
	
	static AppiumDriver driver;
	public WebDriverWait wait;
	
	@DisplayName("Prueba de Appium ")
	@Test
	public  void test()  throws Exception  {
		
		
		/*Aqu� empieza la lectura de archivo*/
		/* ******************************************************* */
		String filename = "csv/archivo.csv";
		String line = "prueba";
		String splitcoma= ",";
		String[] datos=null;	
		
				
		try {
			FileReader lecturaarchivo = new FileReader(filename);			
			
		    BufferedReader bufferedReader =  new BufferedReader(lecturaarchivo);	   
	
	        while((line = bufferedReader.readLine()) != null) {
	        	
	        	 datos = line.split(splitcoma); // Se utiliza el criterio de separacion
	        }   
	
	        bufferedReader.close(); 
		}
		
		catch (IOException e) {
			 e.printStackTrace();
		
		}
		
		String usuario = datos[6];
		String password = datos[7];
		
		
		/*Aqu� termina la lectura de archivo */
		/* ******************************************************************** */
		
				
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "P8Lite");
		caps.setCapability("udid", "QLF7N16513006153"); //Give Device ID of your mobile phone  Huawei P8Lite: QLF7N16513006153  //  Xiaomi: d72f97630204
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("unlockType","pattern");
		caps.setCapability("unlockKey", "1532");
		caps.setCapability("app", System.getProperty("user.dir")+"/apk/login.apk");
		caps.setCapability("appPackage", "com.example.login");
		caps.setCapability("appActivity", "com.example.login.LoginActivity");
		caps.setCapability("noReset", "true");
		
		
		// Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
						
		driver.findElement(By.id("com.example.login:id/email")).sendKeys(usuario);
		
		driver.findElement(By.id("com.example.login:id/email_login_form")).sendKeys(password);
		
		driver.findElement(By.id("com.example.login:id/email_sign_in_button")).click();
		
		driver.findElement(By.id("com.example.login:id/fab")).click();
		
	 	driver.findElement(By.id("com.example.login:id/fab")).click();
		
		
		
		
		/*Thread.sleep(3000);*/
		driver.quit();
	}

	
	
}
