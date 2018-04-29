package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class BarcoTest {

    @Test
    public void cadaBarcoDevuelveLasPosicionesQueOcupanRespectivamente() {
        Barco bote = new Bote();
        Barco crucero = new Crucero();

        Assert.assertEquals(1, bote.getCantidadDePosiciones());
        Assert.assertEquals(2, crucero.getCantidadDePosiciones());
    }

    @Test
    public void disparaleAUnBoteDevuelveHundido(){
        Barco bote = new Bote();

        ResultadoDisparo resultado = bote.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.HUNDIDO, resultado);
    }

    @Test
    public void disparaleAUnCruceroDevuelveTocado(){
        Barco crucero = new Crucero();

        ResultadoDisparo resultado = crucero.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.TOCADO, resultado);
        Assert.assertEquals(1, crucero.getDisparosRecividos());
    }

    @Test
    public void disparaleAUnCruceroDosVecesDevuelveHundido(){
        Barco crucero = new Crucero();
        crucero.recibirDisparo();

        ResultadoDisparo resultado = crucero.recibirDisparo();

        Assert.assertEquals(ResultadoDisparo.HUNDIDO, resultado);
    }

    @Test
    public void noDispararAUnBoteYVerificarDisparosRecividosDevuelveCero(){
        Barco bote = new Bote();

        int resultado = bote.getDisparosRecividos();

        Assert.assertEquals(0, resultado);
    }

    @Test
    public void dispararAUnBoteYVerificarDisparosRecividosDevuelveUno(){
        Barco bote = new Bote();
        bote.recibirDisparo();

        int resultado = bote.getDisparosRecividos();

        Assert.assertEquals(1, resultado);
    }

    @Test
    public void noDispararAUnCruceroYVerificarDisparosRecividosDevuelveCero(){
        Barco crucero = new Crucero();

        int resultado = crucero.getDisparosRecividos();

        Assert.assertEquals(0, resultado);
    }

    @Test
    public void dispararAUnCruceroYVerificarDisparosRecividosDevuelveUno(){
        Barco crucero = new Crucero();
        crucero.recibirDisparo();

        int resultado = crucero.getDisparosRecividos();

        Assert.assertEquals(1, resultado);
    }

    @Test
    public void dispararAUnCruceroDosVecesYVerificarDisparosRecividosDevuelveDos(){
        Barco crucero = new Crucero();
        crucero.recibirDisparo();
        crucero.recibirDisparo();

        int resultado = crucero.getDisparosRecividos();

        Assert.assertEquals(2, resultado);
    }

}
