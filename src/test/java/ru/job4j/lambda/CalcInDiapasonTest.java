package ru.job4j.lambda;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CalcInDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CalcInDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = CalcInDiapason.diapason(1, 3, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenExponentialFunction() {
        List<Double> result = CalcInDiapason.diapason(2, 5, x -> Math.pow(2,x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expected));
    }

}