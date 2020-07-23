package com.github.fabiencharlet.typesafetyfirst.validation;

public class InvalidValueException extends RuntimeException {

	private static final long serialVersionUID = 5258767135657839428L;

	public InvalidValueException(String name, String currentValue, String message) {
		super("The value " + name + " was received with value " + currentValue + ". " + message);
	}
}
