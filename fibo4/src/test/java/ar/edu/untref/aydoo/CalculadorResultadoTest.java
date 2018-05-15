package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CalculadorResultadoTest {

    @Test
    public void ejercicioFibonacciConOpcionHorizontalDirectaDevuelveRespuestaCorrecta() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = " 0 1 1 2 3 5 8 13";
        Assert.assertEquals(expected, calculador.getResultado('h','-',8,'d','-'));
    }

    @Test
    public void ejercicioFibonacciConOpcionHorizontalInversaDevuelveRespuestaCorrecta() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = " 13 8 5 3 2 1 1 0";
        Assert.assertEquals(expected, calculador.getResultado('h','-',8,'i','-'));
    }

    @Test
    public void ejercicioFibonacciHorizontalConOpcionSumaDevuelveLaSumaDeLaSecuencia() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = " 33";
        Assert.assertEquals(expected, calculador.getResultado('h','s',8,'d','-'));
    }

    @Test
    public void ejercicioFibonacciHorizontalConOpcionParDevuelveSoloLosNumeroPares() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = " 2 8";
        Assert.assertEquals(expected, calculador.getResultado('h','-',8,'d','p'));
    }

    @Test
    public void ejercicioFibonacciHorizontalConOpcionSumaDevuelveSoloLaSumaDeLosPares() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = " 10";
        Assert.assertEquals(expected, calculador.getResultado('h','s',8,'d','p'));
    }

    @Test
    public void ejercicioFibonacciConOpcionVerticalDirectaDevuelveRespuestaCorrecta() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = "\n0\n1\n1\n2\n3\n5\n8\n13";
        Assert.assertEquals(expected, calculador.getResultado('v','-',8,'d','-'));
    }

    @Test
    public void ejercicioFibonacciConOpcionVerticalInversaDevuelveRespuestaCorrecta() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = "\n13\n8\n5\n3\n2\n1\n1\n0";
        Assert.assertEquals(expected, calculador.getResultado('v','-',8,'i','-'));
    }

    @Test
    public void ejercicioFibonacciVerticalConOpcionSumaDevuelveLaSumaDeLaSecuencia() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = "\n33";
        Assert.assertEquals(expected, calculador.getResultado('v','s',8,'d','-'));
    }

    @Test
    public void ejercicioFibonacciVerticalConOpcionParDevuelveSoloLosNumeroPares() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = "\n2\n8";
        Assert.assertEquals(expected, calculador.getResultado('v','-',8,'d','p'));
    }

    @Test
    public void ejercicioFibonacciVerticalConOpcionSumaDevuelveSoloLaSumaDeLosPares() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = "\n10";
        Assert.assertEquals(expected, calculador.getResultado('v','s',8,'d','p'));
    }

    @Test
    public void ejercicioFibonacciConOpcionPiramideDevuelveResultadoCorrecto() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = "\n0\n0 1\n0 1 1\n0 1 1 2";
        Assert.assertEquals(expected, calculador.getResultado('p','-',4,'d','-'));
    }

    @Test
    public void ejercicioFibonacciConOpcionPiramideYParDevuelveSoloNumeroParesEnFormatoCorrecto() {
        CalculadorResultado calculador = new CalculadorResultado();
        String expected = "\n2\n2 8";
        Assert.assertEquals(expected, calculador.getResultado('p','-',8,'d','p'));
    }
}