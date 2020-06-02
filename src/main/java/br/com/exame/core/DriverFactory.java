package br.com.exame.core;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.exame.pages.PageGenerator;

public class DriverFactory {

	public DriverFactory() {
		// TODO Auto-generated constructor stub
	}
	

	private static WebDriver driver;
	private static WebDriverWait wait;
	public static PageGenerator page;

	// private static Capabilities chromeCapabilities =
	// DesiredCapabilities.chrome();
	// private static Capabilities firefoxCapabilities =
	// DesiredCapabilities.firefox();

	public static WebDriver getDriver(TipoDriver tipo) throws MalformedURLException {
		switch (tipo) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "./src/main/drivers/geckodriver.exe");
			if (driver == null) {

				// = new RemoteWebDriver(new URL("http://10.11.173.190:4444/wd/hub"),
				// firefoxCapabilities);
				// driver= new WebDriver();
				FirefoxOptions opcoes = new FirefoxOptions();
				// opcoes.addArguments("--headless");
				driver = new FirefoxDriver(opcoes);
				page = new PageGenerator(driver);
			}
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "./src/main/drivers/chromedriver.exe");
			// System.getProperty("//home//runner//work//exame-automacao-testes-front//exame-automacao-testes-front//src//main//resources//chromedriver");
			// System.getProperty(("")
			// +"/home/runner/work/_actions/nanasess/setup-chromedriver/v1.0.1/lib/setup-chromedriver.sh"));

			if (driver == null) {
				// driver= new RemoteWebDriver(new URL("http://10.11.173.190:4444/wd/hub"),
				// chromeCapabilities);
				// driver= new WebDriver();
				ChromeOptions opcoes = new ChromeOptions();
				// opcoes.addArguments("--headless");
				driver = new ChromeDriver(opcoes);

				page = new PageGenerator(driver);
			}
			break;
		default:
			break;
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;

	}

	

	public static Boolean webDriverNaoNulo() {
		return driver != null;
	}

	public static WebDriver encerraDriver() {
		if (driver != null) {
			driver.quit();
		}
		return driver;
	}

	public static WebDriver closeDriver() {
		if (driver != null) {
			driver.close();
		}
		return driver;
	}

}
