package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void ponerBoteEnTablero() {

        Bote unBote = new Bote("Barco");
        Tablero unTablero = new Tablero();
        Posicion posicion = new Posicion(1, 1);

        unTablero.ponerBote(unBote, posicion);

        Assert.assertFalse(unTablero.estaDisponible(posicion));

    }

    @Test
    public void tableroVacioTodasLasPosicionesLibres() {

        Tablero unTablero = new Tablero();
        Posicion posicion = new Posicion(1, 1);

        Assert.assertTrue(unTablero.estaDisponible(posicion));

    }

    @Test
    public void intentarPoner2BotesEnLaMismaPosicionSoloPoneElPrimero() {
        Tablero unTablero = new Tablero();
        Posicion posicion = new Posicion(1,1);
        Bote bote1 = new Bote("Barquito");
        Bote bote2 = new Bote("Barco");

        unTablero.ponerBote(bote1, posicion);
        unTablero.ponerBote(bote2, posicion);

        Assert.assertEquals(bote1.getNombre(),unTablero.getBote(posicion));
    }
}
