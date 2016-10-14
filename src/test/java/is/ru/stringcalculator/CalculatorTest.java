package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testWithNewLine(){
    	assertEquals(3, Calculator.add("1\n2"));
    }

    @Test
    public void testNewLineAndComma(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test(expected = IllegalArgumentException.class)
	public void teststringWithNegativeNumbers(){
		Calculator.add("1,-1");
	}
	
	@Test
	public void testNegativ(){
		try{
			Calculator.add("-1,2");
		}
		catch(final IllegalArgumentException ex){
			final String s = "Negativ not allowed: [-1]";
			assertEquals(s, ex.getMessage());
		}
	}

	@Test
 	public void TestStringWithManyNegativeNumberMessages()
 	{
 	  try
 	  {
 		Calculator.add("2,-4,3,-5");
 	  }
 	  catch( final IllegalArgumentException ex )
 	  {
 	    final String s = "Negatives not allowed: [-4,-5]";
 	    assertEquals(s, ex.getMessage());
  	  }
  	}
}