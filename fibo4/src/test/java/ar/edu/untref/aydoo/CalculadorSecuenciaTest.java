package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CalculadorSecuenciaTest {

    @Test
    public void calcularUnFibonacciDevuelveLaSecuencia(){
        CalculadorSecuencia calculador = new CalculadorSecuencia();

        int[] fibo = {0, 1, 1, 2, 3};

        Assert.assertArrayEquals(fibo, calculador.getFibonacci(5));
    }

    @Test
    public void calcularFibonacciLargoDevuelveLaSecuenciaCorrecta(){
        CalculadorSecuencia calculador = new CalculadorSecuencia();

        int[] fibo = {0, 1, 1, 2, 3, 5, 8, 13};

        Assert.assertArrayEquals(fibo, calculador.getFibonacci(8));
    }
}
