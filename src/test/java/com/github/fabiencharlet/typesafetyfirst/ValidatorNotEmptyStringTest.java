package com.github.fabiencharlet.typesafetyfirst;

import org.junit.Assert;
import org.junit.Test;

import com.github.fabiencharlet.typesafetyfirst.validation.InvalidValueException;
import com.google.common.truth.Truth;

public class ValidatorNotEmptyStringTest {

	public static final String NULL_STRING = null;
	public static final String EMPTY_STRING = "";
	public static final String NOT_EMPTY_STRING = "I'm not empty !";
	public static final String PARAM_NAME = "VeryUNLIKELYYouWouldNameSomethingWithSuchALongName";

	@Test
	public void emptyStringWithoutNameShallThrowException() {

		final InvalidValueException e = Assert.assertThrows(InvalidValueException.class,

				() -> Validator.notEmpty(EMPTY_STRING));

		Truth.assertThat(e).hasMessageThat().contains(Validator.NOT_AVALAIBLE);
	}

	@Test
	public void emptyStringWithNameShallThrowException() {

		final InvalidValueException e = Assert.assertThrows(InvalidValueException.class,

				() -> Validator.notEmpty(EMPTY_STRING, PARAM_NAME));

		Truth.assertThat(e).hasMessageThat().contains(PARAM_NAME);
	}

	@Test
	public void nullStringWithoutNameShallThrowException() {

		final InvalidValueException e = Assert.assertThrows(InvalidValueException.class,

				() -> Validator.notEmpty(NULL_STRING));

		Truth.assertThat(e).hasMessageThat().contains(Validator.NOT_AVALAIBLE);
	}

	@Test
	public void nullStringWithNameShallThrowException() {

		final InvalidValueException e = Assert.assertThrows(InvalidValueException.class,

				() -> Validator.notEmpty(NULL_STRING, PARAM_NAME));

		Truth.assertThat(e).hasMessageThat().contains(PARAM_NAME);
	}

	@Test
	public void notEmptyStringWithoutNameShallThrowException() {

		Truth.assertThat(Validator.notEmpty(NOT_EMPTY_STRING)).isEqualTo(NOT_EMPTY_STRING);
	}

	@Test
	public void notEmptyStringWithNameShallThrowException() {

		Truth.assertThat(Validator.notEmpty(NOT_EMPTY_STRING, PARAM_NAME)).isEqualTo(NOT_EMPTY_STRING);
	}
}
