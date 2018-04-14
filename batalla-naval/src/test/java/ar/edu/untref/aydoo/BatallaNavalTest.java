package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BatallaNavalTest {
    private Tablero unTablero;

    @Before
    public void setUp() {
        this.unTablero = new Tablero();
    }

    @Test
    public void ponerBoteEnTableroYDevolverQueNoEstaDisponible() {

        Bote unBote = new Bote("Barco");
        Posicion posicion = new Posicion(1, 1);

        this.unTablero.ponerBote(unBote, posicion);

        Assert.assertFalse(this.unTablero.estaDisponible(posicion));

    }

    @Test
    public void tableroVacioTodasLasPosicionesLibres() {

        Posicion posicion = new Posicion(1, 1);

        Assert.assertTrue(this.unTablero.estaDisponible(posicion));

    }

    @Test
    public void intentarPoner2BotesEnLaMismaPosicionSoloPoneElPrimero() {
        Posicion posicion = new Posicion(1,1);
        Bote bote1 = new Bote("Barquito");
        Bote bote2 = new Bote("Barco");

        this.unTablero.ponerBote(bote1, posicion);
        this.unTablero.ponerBote(bote2, posicion);

        Assert.assertEquals(bote1.getNombre(), this.unTablero.getBote(posicion));
    }

    @Test
    public void dispararEnPosicionVaciaDevuelveAgua(){
        Posicion posicion = new Posicion(1,1);

        Disparo resultado = this.unTablero.disparar(posicion);

        Assert.assertEquals(Disparo.AGUA, resultado);
    }

    @Test
    public void dispararEnPosicionOcupadaDevuelveHundido(){
        Posicion posicion = new Posicion(1,1);
        Bote bote = new Bote("Bote");

        this.unTablero.ponerBote(bote, posicion);
        Disparo resultado = this.unTablero.disparar(posicion);

        Assert.assertEquals(Disparo.HUNDIDO, resultado);

    }

    @Test
    public void dispararAUnBoteLoQuitaDelTablero(){
        Posicion posicion = new Posicion(1,1);
        Bote bote = new Bote("Bote");

        this.unTablero.ponerBote(bote,posicion);
        this.unTablero.disparar(posicion);

        Assert.assertTrue(this.unTablero.estaDisponible(posicion));
    }

}
