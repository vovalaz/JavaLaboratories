package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.Main;

@SuppressWarnings("ALL")
public class test {
    @Test(dataProvider = "intProvider")
    public void intTest(int K, int[] res) {
        assertEquals(new Main().int_func(K), res);
    }

    @DataProvider
    public Object[][] intProvider() {
        return new Object[][]{{31, new int[] {4, 3}}, {59, new int[] {14, 45}}, {365, new int[] {14, 90}}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "boolProvider")
    public void boolTest(int A, int B, int C, boolean res) {
        assertEquals(new Main().bool_func(A, B, C), res);
    }

    @DataProvider
    public Object[][] boolProvider() {
        return new Object[][]{{4, 2, 7, false}, {-8, 10, 7, false}, {-8, 10, 25, true}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "ifProvider")
    public void ifTest(int a, int b, int res) {
        assertEquals(new Main().if_func(a, b), res);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][]{{25, 3, 1}, {7, 12, 0}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "switchProvider")
    public void switchTest(int mode, double mass, double res) {
        assertEquals(new Main().switch_func(mode, mass), res);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][]{{1, 25.5, 25.5}, {2, 25000.5, 0.0250005}, {3, 36500, 36.5}, {4, 3.2, 3200.0}, {5, 12.0, 1200.0}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "forProvider")
    public void forTest(int a, int b, int res) {
        assertEquals(new Main().for_func(a, b), res);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{15, 25, 220}, {12, 15, 54}, {3, 9, 42}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "whileProvider")
    public void whileTest(int N, int res) {
        assertEquals(new Main().while_func(N), res);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{21, 5}, {38, 7}, {352, 19}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "minmaxProvider")
    public void min_maxTest(int[] arr, int[] res) {
        assertEquals(new Main().minmax_func(arr), res);
    }

    @DataProvider
    public Object[][] minmaxProvider() {
        return new Object[][]{{new int[]{8, 3, 5, 8, 6, 3, 4}, new int[]{0, 5}}, {new int[]{5, 28, 13, 22, 9, 3, 25, 3, 28}, new int[]{1, 7}}, {new int[]{5, 0, 3, -2, 15, 6}, new int[]{4, 3}}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] arr, double[] res) {
        assertEquals(new Main().array_func(arr), res);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{{new double[]{8, 3, 5, 8, 6, 3, 4}, new double[]{4, 3, 6, 8, 5, 3, 8}}, {new double[]{5, 28, 13, 22, 9, 3}, new double[]{3, 9, 22, 13, 28, 5}}, {new double[]{5, 0, 3, -2, 15, 6}, new double[]{6, 15, -2, 3, 0, 5}}};
    }

    //-----------------------------------------------------------------------------

    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int K, double[][] arr, double[] res) {
        assertEquals(new Main().matrix_func(K, arr), res);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        return new Object[][]{{2, new double[][]{
                {16.99, 72.83, 77.61},
                {34.93, 65.85, 24.74},
                {49.46, 34.6, 9.98},
                {98.73, 49.19, 96.89}}, new double[]{49.46, 34.6, 9.98}}};
    }

    //-----------------------------------------------------------------------------
}
