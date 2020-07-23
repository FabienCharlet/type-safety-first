package com.github.fabiencharlet.typesafetyfirst;

import org.junit.Test;

import com.google.common.truth.Truth;

public class SafeEqualsTest {

	public static final String NULL_OBJECT = null;

	public static final String NOT_NULL_OBJECT1 = "Test1";
	public static final String NOT_NULL_OBJECT2 = "Test2";

	public static final String NOT_NULL_OBJECT1_OTHER_INSTANCE = new String("Test1");

	@Test
	public void bothNullObjectsShallBeEqual() {

		Truth.assertThat(Safe.equals(NULL_OBJECT, NULL_OBJECT)).isTrue();
	}

	@Test
	public void onlyFirstObjectNullObjectsShallNotBeEqual() {

		Truth.assertThat(Safe.equals(NULL_OBJECT, NOT_NULL_OBJECT1)).isFalse();
	}

	@Test
	public void onlySecondObjectNullObjectsShallNotBeEqual() {

		Truth.assertThat(Safe.equals(NOT_NULL_OBJECT1, NULL_OBJECT)).isFalse();
	}

	@Test
	public void notNullAndNotEqualsObjectsShallNotBeEqual() {

		Truth.assertThat(Safe.equals(NOT_NULL_OBJECT1, NOT_NULL_OBJECT2)).isFalse();
	}

	@Test
	public void twoEqualsInstancesShallBeEqual() {

		Truth.assertThat(Safe.equals(NOT_NULL_OBJECT1, NOT_NULL_OBJECT1_OTHER_INSTANCE)).isTrue();
	}
}
