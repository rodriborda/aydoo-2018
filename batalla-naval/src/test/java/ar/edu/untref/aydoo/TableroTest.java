package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TableroTest {
    private Tablero unTablero;
    private Posicion posicionInicial;

    @Before
    public void setUp() {
        this.unTablero = new Tablero(10, 10);
        this.posicionInicial = new Posicion(1, 1);
    }

    @Test
    public void unaPosicionSinBarcoDeberiaEstarDisponible() {

        Assert.assertTrue(this.unTablero.estaDisponible(this.posicionInicial));
    }

    @Test
    public void ponerBoteEnTableroYDevolverQueNoEstaDisponible() {
        Bote unBote = new Bote();

        this.unTablero.ponerBote(unBote, this.posicionInicial);

        Assert.assertFalse(this.unTablero.estaDisponible(this.posicionInicial));
    }

    @Test
    public void intentarPoner2BotesEnLaMismaPosicionSoloPoneElPrimero() {
        Bote bote1 = new Bote();
        Bote bote2 = new Bote();

        this.unTablero.ponerBote(bote1, this.posicionInicial);
        this.unTablero.ponerBote(bote2, this.posicionInicial);

        Assert.assertEquals(bote1, this.unTablero.getBarco(this.posicionInicial));
        Assert.assertNotEquals(bote2, this.unTablero.getBarco(this.posicionInicial));
    }

    @Test
    public void ponerUnCruceroYVerQueAmbasPosicionesEstanOcupadas(){
        Posicion segundaPosicion = new Posicion(1,2);
        Posicion posicionLibre = new Posicion(2,1);
        Crucero crucero = new Crucero();

        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.HORIZONTAL);

        Assert.assertFalse(this.unTablero.estaDisponible(this.posicionInicial));
        Assert.assertFalse(this.unTablero.estaDisponible(segundaPosicion));
        Assert.assertTrue(this.unTablero.estaDisponible(posicionLibre));
    }

    @Test
    public void ponerUnCruceroEnPosicionVertical(){
        Posicion segundaPosicion = new Posicion(2,1);
        Posicion posicionLibre = new Posicion(1,2);
        Crucero crucero = new Crucero();

        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.VERTICAL);

        Assert.assertFalse(this.unTablero.estaDisponible(this.posicionInicial));
        Assert.assertFalse(this.unTablero.estaDisponible(segundaPosicion));
        Assert.assertTrue(this.unTablero.estaDisponible(posicionLibre));
    }


    @Test
    public void dispararEnPosicionVaciaDevuelveAgua(){

        ResultadoDisparo resultado = this.unTablero.disparar(this.posicionInicial);

        Assert.assertEquals(ResultadoDisparo.AGUA, resultado);
    }

    @Test
    public void dispararEnPosicionOcupadaDevuelveHundido(){
        Bote bote = new Bote();

        this.unTablero.ponerBote(bote, this.posicionInicial);
        ResultadoDisparo resultado = this.unTablero.disparar(this.posicionInicial);

        Assert.assertEquals(ResultadoDisparo.HUNDIDO, resultado);
    }

    @Test
    public void dispararAUnBoteLoQuitaDelTablero(){
        Bote bote = new Bote();

        this.unTablero.ponerBote(bote, this.posicionInicial);
        this.unTablero.disparar(this.posicionInicial);

        Assert.assertTrue(this.unTablero.estaDisponible(this.posicionInicial));
    }

    @Test
    public void dispararUnaVezAUnCruceroDevuelveTocado(){
        Crucero crucero = new Crucero();
        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.HORIZONTAL);

        ResultadoDisparo resultado = this.unTablero.disparar(this.posicionInicial);

        Assert.assertEquals(ResultadoDisparo.TOCADO, resultado);
    }

    @Test
    public void dispararDosVecesUnCruceroEnLaMismaPosicionDevuelveAgua(){
        Crucero crucero = new Crucero();
        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.HORIZONTAL);

        this.unTablero.disparar(this.posicionInicial);
        ResultadoDisparo resultado = this.unTablero.disparar(this.posicionInicial);

        Assert.assertEquals(ResultadoDisparo.AGUA, resultado);
    }

    @Test
    public void dispararDosVecesAUnCruceroDevuelveHundido(){
        Posicion segundaPosicion = new Posicion(1,2);
        Crucero crucero = new Crucero();
        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.HORIZONTAL);

        this.unTablero.disparar(this.posicionInicial);
        ResultadoDisparo resultado = this.unTablero.disparar(segundaPosicion);

        Assert.assertEquals(ResultadoDisparo.HUNDIDO, resultado);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void intentarPonerBarcoEnPosicionInvalidaDevuelveExcepcion() throws ArrayIndexOutOfBoundsException{
        Posicion posicionInvalida = new Posicion(11,2);
        Bote bote = new Bote();

        this.unTablero.ponerBote(bote, posicionInvalida);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void intentarPonerUnCruceroHorizontalmenteContraElBordeDerechoDevuelveExcepcion() throws ArrayIndexOutOfBoundsException{
        Posicion posicionInvalida = new Posicion(1,10);
        Crucero crucero = new Crucero();

        this.unTablero.ponerCrucero(crucero, posicionInvalida, Orientacion.HORIZONTAL);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void intentarPonerUnCruceroVerticalmenteContraElBordeInferiorDevuelveExcepcion() throws ArrayIndexOutOfBoundsException{
        Posicion posicionInvalida = new Posicion(10,1);
        Crucero crucero = new Crucero();

        this.unTablero.ponerCrucero(crucero, posicionInvalida, Orientacion.VERTICAL);
    }

    @Test
    public void intentarPonerUnCruceroSobreUnBoteNoColocaElCrucero(){
        Bote bote = new Bote();
        Crucero crucero = new Crucero();

        this.unTablero.ponerBote(bote, this.posicionInicial);
        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.VERTICAL);

        Assert.assertEquals(bote, this.unTablero.getBarco(this.posicionInicial));
        Assert.assertNotEquals(crucero, this.unTablero.getBarco(this.posicionInicial));
    }

    @Test
    public void colocarUnCruceroCuyaSegundaPosicionEstaOcupadaNoLoColoca(){
        Bote bote = new Bote();
        Crucero crucero = new Crucero();
        Posicion posicionBote = new Posicion(1,2);

        this.unTablero.ponerBote(bote, posicionBote);
        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.HORIZONTAL);

        Assert.assertEquals(bote, this.unTablero.getBarco(posicionBote));
        Assert.assertNotEquals(crucero, this.unTablero.getBarco(posicionBote));
        Assert.assertTrue(this.unTablero.estaDisponible(this.posicionInicial));
    }

    @Test
    public void intentarPonerUnBoteenLaSegundaPosicionDeUnCruceroNoColocaElBote(){
        Bote bote = new Bote();
        Crucero crucero = new Crucero();
        Posicion posicionBote = new Posicion(2,1);

        this.unTablero.ponerCrucero(crucero, this.posicionInicial, Orientacion.VERTICAL);
        this.unTablero.ponerBote(bote, posicionBote);

        Assert.assertEquals(crucero, this.unTablero.getBarco(posicionBote));
        Assert.assertNotEquals(bote, this.unTablero.getBarco(posicionBote));
    }
}
