package com.github.aha.poc.junit5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Basic tests in JUnit5")
public class BasicTests {
	
	@Test
	  void testExpectedException() {
	 
	    assertThrows(NumberFormatException.class, () -> {
	      Integer.parseInt("One");
	    });
	  }
	 
	  @Test
	  void testExpectedExceptionWithSuperType() {
	 
	    assertThrows(IllegalArgumentException.class, () -> {
	      Integer.parseInt("One");
	    });
	  }
	   
	  @Test
	  void testExpectedExceptionFail() {
	 
	    assertThrows(IllegalArgumentException.class, () -> {
	      Integer.parseInt("1");
	    });
	  }

	@Test
	@DisplayName("show simple assert via JUnit")
	void simpleJUnitAssert() {
		assertEquals(2, 1 + 1, () -> "Error message");
	}

	@Test
	@DisplayName("validate tags existence via JUnit")
	void allJUnitAssert(TestInfo testInfo) {
		Set<String> tags = testInfo.getTags();
		assertAll(() -> assertNotNull(tags), () -> assertEquals(0, tags.size()));
	}

	@Test
	@DisplayName("show simple assert via AssertJ")
	public void simpleAssertJAssert() {
		assertThat(true).isTrue();
		assertThat(1 + 1).isEqualTo(2);
		assertThat("hello").isNotEqualTo("hi");
		assertThat(LocalDate.of(2018, 06, 13)).isEqualTo("2018-06-13");
		assertThat(new ClassCastException()).isInstanceOf(RuntimeException.class);
	}

	 @Test
	 public void testschool1()
	 {
	 assertThrows(NumberFormatException.class, () -> {
	 Integer.parseInt("gg");
	 });
	 }
	@Test
	@DisplayName("check TestInfo feature")
	void checkMethodName(TestInfo testInfo) {
		Optional<Method> testMethod = testInfo.getTestMethod();
		assertThat(testMethod.isPresent()).isTrue();
		assertThat(testMethod.get().getName()).isEqualTo("checkMethodName");
	}

	@Test
	@DisplayName("check @Tag feature")
	@Tag("JUnit5")
	void checkTag(TestInfo testInfo) {
		Set<String> tags = testInfo.getTags();
		assertThat(tags).isNotNull();
		assertThat(tags.size()).isEqualTo(1);
		Optional<String> firstTag = tags.stream().findFirst();
		assertThat(firstTag.isPresent()).isTrue();
		assertThat(firstTag.get()).isEqualTo("JUnit5");
	}
	
	@Test
	void testsada() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Integer.parseInt("one"));
		assertEquals("For input string: \"one\"", exception.getMessage());
		
	}
	
	@Test
	public void shouldFailBecauseTheNumbersAreNotEqual_lazyEvaluation() {
	    assertTrue(
	      2 == 3, 
	      () -> "Numbers " + 2 + " and " + 3 + " are not equal!");
	}
	
	@Test
	public void testAssertTrue()
	{
		boolean newBool= false;
		assertFalse(newBool);
		assertEquals(4, 5,
                "The optional failure message is now the last parameter");
	}
	
	

}
