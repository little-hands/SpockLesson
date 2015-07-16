package test.java.sample;

import main.java.sample.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

public class CalculatorTest {

	@Test
	public void JUnitのテストケース() {
		Calculator calculator = new Calculator();
		assertThat(calculator.calcSum(1, 2),is(3));
		assertThat(calculator.calcSum(1, -3),is(-2));
//		assertThat(calculator.calcSum(1, 2),is(10));
//		assertThat(calculator.calcSum(1, -3),is(20));
	}
	

}
