package com.softserve.edu.opencart.appl;

// TODO use builder
public class ApplicationSources {

	// Browser Data
	private String browserName;
	private String driverPath;
	//private List<String> browserOptions;
	// private String browserPath;
	// private String defaulProfile;
	//
	// Implicit and Explicit Waits
	private long implicitTimeOut;
	// private long explicitTimeOut;
	//
	// Localization Strategy
	// private String language;
	//
	// Search Strategy
	// private String searchStrategy;
	//
	// Logger Strategy
	// private String loggerStrategy;
	//
	// URLs
	private String homeUrl;
	//private String loginUrl;
	//private String logoutUrl;
	// private String serverUrl;
	//
	// Connect to DB

	public ApplicationSources(String browserName, String driverPath,
			long implicitTimeOut, String homeUrl) {
		this.browserName = browserName;
		this.driverPath = driverPath;
		this.implicitTimeOut = implicitTimeOut;
		this.homeUrl = homeUrl;
		//this.loginUrl = loginUrl;
		//this.logoutUrl = logoutUrl;
	}

	// getters

	public String getBrowserName() {
		return browserName;
	}

	public String getDriverPath() {
		return driverPath;
	}

	public long getImplicitTimeOut() {
		return implicitTimeOut;
	}

	public String getHomeUrl() {
		return homeUrl;
	}

//	public String getLoginUrl() {
//		return loginUrl;
//	}
//
//	public String getLogoutUrl() {
//		return logoutUrl;
//	}

}
