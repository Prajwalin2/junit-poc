package com.github.aha.poc.junit5.np;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.github.aha.poc.junit5.Calculator;

@DisplayName("A calculator component")
public class ClassTests {

	@Test
	@DisplayName("sum 2 positive numbers")
	void addTwoPositiveNumbers() {

		assertThat(Calculator.add(3, 5)).isEqualTo(8);
	}
}
