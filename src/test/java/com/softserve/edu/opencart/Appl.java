package com.softserve.edu.opencart;

import com.softserve.edu.opencart.tools.CountUtils;

public class Appl {
	public static void main(String[] args) {
		System.out.println("For: - (0) --; Number = "+CountUtils.getCountInBrackets("-  (0) --;"));
		System.out.println("For: (200); Number = "+CountUtils.getCountInBrackets("(200)"));
		System.out.println("For: (); Number = "+CountUtils.getCountInBrackets("()"));
	}
}
