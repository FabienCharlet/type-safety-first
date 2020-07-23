package com.github.fabiencharlet.typesafetyfirst;

import com.github.fabiencharlet.typesafetyfirst.validation.InvalidValueException;
import com.google.common.base.Strings;

public class Validator {

	public static final String NOT_AVALAIBLE = "Name not available (hope for stacktrace)";

	public static <T> T notNull(T o) {

		return notNull(o, NOT_AVALAIBLE);
	}

	public static <T> T notNull(T o, String name) {

		if (o == null) {

			throw new InvalidValueException(name, null, "This argument can't be null");
		}

		return o;
	}

	/**
	 * Ensure the string in parameter contains something
	 *
	 * @param s the string to test
	 *
	 * @throws InvalidValueException if s is null or empty
	 *
	 * @return s if it's valid
	 */
	public static String notEmpty(String s) {

		return notEmpty(s, NOT_AVALAIBLE);
	}


	/**
	 * Ensure the string in parameter contains something
	 *
	 * @param s the string to test
	 * @param name the name of the parameter/variable to display in the exception
	 *
	 * @throws InvalidValueException if s is null or empty
	 *
	 * @return s if it's valid
	 */
	public static String notEmpty(String s, String name) {

		if (Strings.isNullOrEmpty(s)) {

			throw new InvalidValueException(name, s, "This argument can't be empty");
		}

		return s;
	}

	public static long strictlyPositive(long l) {

		return strictlyPositive(l, NOT_AVALAIBLE);
	}

	public static long strictlyPositive(long l, String name) {

		if (l < 1) {

			throw new InvalidValueException(name, String.valueOf(l), "This argument must be at least 1");
		}

		return l;
	}
}
