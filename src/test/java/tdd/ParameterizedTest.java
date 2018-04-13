package tdd;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static tdd.Calc.*;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    @Parameterized.Parameters(name = "{index}: Numbers: {0} {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 3},
                {-5, -7},
                {0, 180},
                {-90, 90,},
                {180, 20001.6}
        });
    }

    private double num1;
    private double num2;

    public ParameterizedTest(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;

    }

    @Test
    public void multiplyShouldBeCorrect() {
        assertEquals(num1*num2, multiply(num1, num2) , 0.00001);
    }

    @Test
    public void divideShouldBeCorrect() {
        assertEquals(num1/num2, divide(num1, num2), 0.00001);
    }

    @Test
    public void addShouldBeCorrect() {
        assertEquals(num1+num2, add(num1, num2), 0.00001);
    }

    @Test
    public void subtractShouldBeCorrect() {
        assertEquals(num1-num2, subtract(num1, num2), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionShouldBeThrownOnNaN() {
        multiply(Double.NaN, 5);
    }

    @Test
    @Ignore
    public void proveHomomorphismOfInverseMapAndAnyEquivalenceClasses() {
        //Work In Progress
    }

}
