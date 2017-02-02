package com.softserve.edu;

public class Appl {

	private String message = " World";

	private String hello(String text) {
		return "Hello " + text;
	}

	public static void main(String[] args) {
		Appl appl = new Appl();
		System.out.println(appl.hello(appl.message));
	}

}
