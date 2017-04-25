package com.softserve.edu.opencart.tools;

public class GeneralException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String GENERAL_OPENCARD_EXCEPTION = "GeneralOpenCardException";

	// Classic constructor with a message of error.
	public GeneralException(String message) {
		super(message);
		performLogging(message);
	}

	public GeneralException(String message, Throwable e) {
		super(message, e);
		performLogging(message);
	}

	private void performLogging(String message) {
		// LoggerWrapper.get().errorLog(GENERAL_REGRES_EXCEPTION + ": " +
		// message);
	}

}
