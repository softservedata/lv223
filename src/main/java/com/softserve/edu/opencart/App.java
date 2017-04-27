package com.softserve.edu.opencart;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String MAVEN_DIRECTORY = "surefire.reports.directory";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    	System.out.println("login = " + System.getenv("login"));
		String outputDirectory = System.getProperty(MAVEN_DIRECTORY);
		System.out.println("\t+++MAVEN_DIRECTORY outputDirectory = " + outputDirectory);
    }
}
