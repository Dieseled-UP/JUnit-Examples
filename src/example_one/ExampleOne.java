package example_one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.*;

class ExampleOne {

	private static String string1;					
	private static String string2;					
	private static String string3;					
	private static String string4;					
	private static String string5;					
	private static int variable1;					
	private static int	variable2;
	private static double num1;
	private static double num2;
	private static int[] airethematicArrary1;					
	private static int[] airethematicArrary2;
    
	@BeforeAll
	static void setUpVariables() {

		string1 = "Junit";
        string2 = "Junit";
        string3 = "test";
        string4 = "test";
        string5 = null;
        variable1 = 1;
        variable2 = 2;
        num1 = 475;
        num2 = 23;
        airethematicArrary1 = new int[]{ 1, 2, 3 };
        airethematicArrary2 = new int[]{ 1, 2, 3 };
	}
	
	@BeforeEach
	void willRunBeforeEachTest() {
		System.out.println("Run this first");
	}
	
	@Test
	@DisplayName("Test 1: This test will compare the two variables using the Object class equals() method")
	void testTwoStrings() {
		System.out.println("Test 1: " + string1 + ", " + string2 + "\n");
		assertEquals(string1, string2);
	}
	
	@Test
	@DisplayName("Test 2: Functionality is to check that the two objects refer to the same object")
	void testTwoStringsAreTheSame() {
		System.out.println("Test 2: " + string3 + ", " + string4 + "\n");
		assertSame(string3, string4);
	}
	
	@Test
	@DisplayName("Test 3: Functionality is to check that the two objects do not refer to the same object")
	void testTwoStringsAreNotTheSame() {
		assertNotSame("Test 3: " + string1, string3 + "\n");
	}
	
	@Test
	@DisplayName("Test 4: Functionality is to check that an object is not null")
	void testObjectNotNull() {
		System.out.println("Test 4: " + string1 + "\n");
		assertNotNull(string1);
	}
	
	@Test
	@DisplayName("Test 5: Functionality is to check that an object is null")
	void testObjectIsNull() {
		System.out.println("Test 5: " + string5 + "\n");
		assertNull(string5);
	}
	
	@Test
	@DisplayName("Test 6: Functionality is to check that a condition is true")
	void testConditionReturnsTrue() {
		System.out.println("Test 6: " + (variable1 < variable2) + "\n");
		assertTrue(variable1 < variable2);
	}
	
	@Test
	@DisplayName("Test 7: Functionality is to check that a condition is false")
	void testConditionReturnsFalse() {
		System.out.println("Test 7: " + (variable1 > variable2) + "\n");
		assertFalse(variable1 > variable2);
	}
	
	@Test
	@DisplayName("Test 8: Functionality is to check that the expected array and the resulted array are equa")
	void testArraysAreTheSame() {
		
		System.out.print("Test 8: Array One = ");
		for (int i = 0; i < airethematicArrary1.length; i++) {
			System.out.print(airethematicArrary1[i] + ", ");
		}
		System.out.print(" Array Two = ");
		for (int i = 0; i < airethematicArrary2.length; i++) {
			System.out.print(airethematicArrary2[i] + ", ");
		}
		System.out.println("\n");
		assertArrayEquals(airethematicArrary1, airethematicArrary2);
	}

	@Test
	@DisplayName("Test 9: This test adds two numbers together and check the result")
	void testAddingNumbers() {
		System.out.println("Test 9: " + (variable1 + variable2) + "\n");
		assertEquals(3, variable1 + variable2);
	}
	
	@Test
	@DisplayName("Test 10: This test will check floating point numbers")
	void testFloatingPoints() {
		System.out.println("Test 10: " + (num1 / num2) + "\n");
		assertEquals(20.652, num1 / num2, 0.001);
	}
	
	@Test
	@Disabled("For demo purposes only")
	@DisplayName("Test 11: This check the value of two numbers multiplied")
	void testDisabledForExample() {
		System.out.println("Test 11: " + (num1 * num2) + "\n");
		assertEquals(2, num1 * num2);
	}
	/*
	@Test
	@DisplayName("Run all tests at one time, if one fails test will end")
    public void testAllAssertCouldEnd() {
		
        //Assert statements
        assertEquals(string1, string2);
        assertSame(string3, string4);
        assertNotSame(string1, string3);
        assertNotNull(string1);
        assertNull(string5);
        assertTrue(variable1 < variable2);
        assertFalse(variable1 > variable2);
        assertArrayEquals(airethematicArrary1, airethematicArrary2);
	}
	*/
	/*
	@Test
	@DisplayName("Run all tests at one time, if one fails the rest complete")
    public void testAllAssert() {
		
        //Assert statements
        assertAll("Check all conditions",
        () -> assertEquals(string1, string2),
        () -> assertSame(string3, string4),
        () -> assertNotSame(string1, string3),
        () -> assertNotNull(string1),
        () -> assertNull(string5),
        () -> assertTrue(variable1 < variable2),
        () -> assertFalse(variable1 > variable2),
        () -> assertArrayEquals(airethematicArrary1, airethematicArrary2)
        );
	}
	*/
}
