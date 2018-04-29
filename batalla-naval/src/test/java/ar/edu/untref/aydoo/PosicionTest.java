package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PosicionTest {
    private Barco bote;
    private Barco crucero;
    private Posicion posicion;

    @Before
    public void setUp() {
        this.bote = new Bote();
        this.crucero = new Crucero();
        this.posicion = new Posicion(1,1);
    }

    @Test
    public void verificarUnaPosicionVaciaDevuelveQueEsAgua() {
        Posicion posicion = new Posicion(1,1);

        Assert.assertTrue(posicion.esAgua());
    }

    @Test
    public void ponerUnBoteEnUnaPosicionNoDevuelvaAguaYDevuelveElBote() {
        this.posicion.setBarco(this.bote);

        Assert.assertFalse(this.posicion.esAgua());
        Assert.assertEquals(this.bote, this.posicion.getBarco());
    }

    @Test
    public void ponerUnBoteEnPosicionYLuegoPonerAguaQuitaElBote() {
        this.posicion.setBarco(this.bote);
        this.posicion.setAgua();

        Assert.assertTrue(this.posicion.esAgua());
        Assert.assertNotEquals(this.bote, this.posicion.getBarco());
    }

    @Test
    public void ponerUnCruceroEnUnaPosicionNoDevuelvaAguaYDevuelveElCrucero() {
        this.posicion.setBarco(this.crucero);

        Assert.assertFalse(this.posicion.esAgua());
        Assert.assertEquals(this.crucero, this.posicion.getBarco());
    }

    @Test
    public void ponerUnCruceroEnPosicionYLuegoPonerAguaQuitaElCrucero() {
        this.posicion.setBarco(this.crucero);
        this.posicion.setAgua();

        Assert.assertTrue(this.posicion.esAgua());
        Assert.assertNotEquals(this.crucero, this.posicion.getBarco());
    }

    @Test
    public void dispararAPosicionVaciaDevuelveAgua() {
        ResultadoDisparo resultado = this.posicion.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.AGUA,resultado);
    }

    @Test
    public void dispararleAUnBoteDevuelveHundidoYLoQuita() {
        this.posicion.setBarco(this.bote);

        ResultadoDisparo resultado = this.posicion.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.HUNDIDO,resultado);
        Assert.assertTrue(this.posicion.esAgua());
    }

    @Test
    public void disparaleDosVecesAUnBoteDevuelveAgua() {
        this.posicion.setBarco(this.bote);
        this.posicion.recibirDisparo();

        ResultadoDisparo resultado = this.posicion.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.AGUA,resultado);
    }

    @Test
    public void dispararleAUnCruceroDevuelveTocado() {
        this.posicion.setBarco(this.crucero);

        ResultadoDisparo resultado = this.posicion.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.TOCADO,resultado);
    }

    @Test
    public void disparaleDosVecesAUnCruceroEnLaMismaPosicionDevuelveAgua() {
        this.posicion.setBarco(this.crucero);
        this.posicion.recibirDisparo();

        ResultadoDisparo resultado = this.posicion.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.AGUA,resultado);
    }

    @Test
    public void dispararPorSegundaVezAUnCruceroDevuelveHundido() {
        Posicion segundaPosicion = new Posicion(1,2);
        this.posicion.setBarco(this.crucero);
        segundaPosicion.setBarco(this.crucero);

        this.posicion.recibirDisparo();
        ResultadoDisparo resultado = segundaPosicion.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.HUNDIDO,resultado);
    }
}
