package com.softserve.edu.opencart.appl;

public final class ApplicationSourcesRepository {

	private ApplicationSourcesRepository() {
	}
	
	public static ApplicationSources getDefault() {
		return getChromeCloud();
	}
	
	public static ApplicationSources getFirefox5xxCloud() {
		System.out.println("+++++ PATH = "
				+ ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath());
		return new ApplicationSources("FireFox50x",
				ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1), 5L,
				"http://atqc-shop.epizy.com/");
	}

	public static ApplicationSources getChromeCloud() {
		System.out.println("+++++ PATH = "
				+ ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath());
		return new ApplicationSources("Chrome",
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1), 5L,
				"http://atqc-shop.epizy.com/");
	}

}
