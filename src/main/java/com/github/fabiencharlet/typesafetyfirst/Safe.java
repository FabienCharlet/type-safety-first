package com.github.fabiencharlet.typesafetyfirst;

import java.util.Map;
import java.util.Optional;

public class Safe {

	public static <T> boolean equals(T o1, T o2) {

		if (o1 != null) {
			return o1.equals(o2);
		}

		return o2 == null;
	}

	public <T, U> Optional<U> get(Map<T, U> map, T key) {

		Validator.notNull(map, "map");
		Validator.notNull(key, "key");

		return Optional.of(map.get(key));
	}
}
