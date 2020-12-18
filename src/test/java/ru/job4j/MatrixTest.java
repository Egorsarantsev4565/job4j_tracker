package ru.job4j;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;

public class MatrixTest {
    @Test
    public void toList() {
        Integer[][] matrix = new Integer[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        List<Integer>result = Matrix.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expected));
    }
}

