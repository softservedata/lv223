package com.softserve.edu.opencart.appl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.softserve.edu.opencart.pages.HomePage;

public class Application {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private interface IBrowser {
		WebDriver getBrowser(Application application);
	}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static class Firefox5xxTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			System.setProperty("webdriver.gecko.driver",
					application.applicationSources.getDriverPath());
			return new FirefoxDriver();
		}
	}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static class ChromeTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			System.setProperty("webdriver.chrome.driver",
					application.applicationSources.getDriverPath());
			return new ChromeDriver();
		}
	}
	
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public static enum Browsers {
		DEFAULT_TEMPORARY("ChromeTemporary",
				new ChromeTemporary()),
		FIREFOX50XX_TEMPORARY("Firefox5xxTemporary",
				new Firefox5xxTemporary()),
		CHROME_TEMPORARY("ChromeTemporary",
				new ChromeTemporary());
		//
		private String browserName;
		private IBrowser browser;

		private Browsers(String browserName, IBrowser browser) {
			this.browserName = browserName;
			this.browser = browser;
		}

		public WebDriver runBrowser(Application application) {
			return browser.getBrowser(application);
		}

		@Override
		public String toString() {
			return browserName;
		}
	}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	// Use Singleton, Repository
	private static volatile Application instance;
	//
	// Fields
	//
	private WebDriver driver;
	private ApplicationSources applicationSources;
	// etc.

	private Application(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
	}

	public static Application get() {
		return get(null);
	}

	public static Application get(ApplicationSources applicationSources) {
		if (instance == null) {
			synchronized (Application.class) {
				if (instance == null) {
					if (applicationSources == null) {
						applicationSources = ApplicationSourcesRepository.getDefault();
					}
					instance = new Application(applicationSources);
					instance.init();
				}
			}
		}
		return instance;
	}

	public static void remove() {
		if (instance != null) {
			instance.quit();
		}
		instance = null;
	}

	public void init() {
		initWebDriver();
		// TODO
		// Init Strategy from applicationSources
		// Init DB access, etc.
	}

	public HomePage load() {
		driver.get(applicationSources.getHomeUrl());
		return new HomePage(driver);
	}

//	public LoginPage login() {
//		logout();
//		driver.get(applicationSources.getLoginUrl());
//		return new LoginPage(driver);
//	}

//	public LoginPage logout() {
//		driver.get(applicationSources.getLogoutUrl());
//		return new LoginPage(driver);
//	}

	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	private void initWebDriver() {
		Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
		for (Browsers browser : Browsers.values()) {
			if (browser.toString().toLowerCase()
					.contains(applicationSources.getBrowserName().toLowerCase())) {
				currentBrowser = browser;
				break;
			}
		}
		driver = currentBrowser.runBrowser(this);
		//
		// Move to Search Strategy Class
		driver.manage().timeouts()
			.implicitlyWait(applicationSources.getImplicitTimeOut(),
				TimeUnit.SECONDS);
	}

}
