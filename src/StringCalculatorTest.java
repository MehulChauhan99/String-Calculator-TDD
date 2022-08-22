package src;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

  
    @Test
	public void returnZeroIfEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void retrunOneNumber() {
		assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public void returnSumIfTwoNumbers(){
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
    public void returnSumIfThreeNumbers(){
    	assertEquals(6, StringCalculator.add("1,2,3"));
    }

    @Test
    public void testNegativeNumver(){
    	try {
			StringCalculator.add("-1,2,3");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			StringCalculator.add("2,-3,4,-5,-6");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -3,-5,-6");
		}
    }

    @Test
    public void testOverThousand(){
    	assertEquals(2, StringCalculator.add("2,1001"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testOtherDelimiter(){
    	assertEquals(3, StringCalculator.add("//;\n1;2"));
    }
}

