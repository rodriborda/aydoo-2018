package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class OpcionesTest {

    @Test
    public void pasarComoArgumentoSoloUnNumeroLoGuardaCorrectamente(){
        String[] arg = new String[1];
        arg[0] = "5";
        Opciones opciones = new Opciones(arg);
        Integer expected = 5;

        Assert.assertEquals(expected, opciones.getNumero());
    }

    @Test
    public void pasarVariosArgumentosGuardaCadaUnoComoCorresponde(){
        String[] arg = new String[2];
        arg[0] = "5";
        arg[1] = "-o=hd";
        Opciones opciones = new Opciones(arg);
        Integer expected = 5;

        Assert.assertEquals(expected, opciones.getNumero());
        Assert.assertEquals('h', opciones.getOrientacion());
        Assert.assertEquals('d', opciones.getDireccion());
    }

    @Test
    public void pasarMuchosArgumentosYEnDiferenteOrdenLosGuardaCorrectamente(){
        String[] arg = new String[4];
        arg[0] = "-n=p";
        arg[1] = "-o=vi";
        arg[2] = "5";
        arg[3] = "-f=ejemplo.txt";
        Opciones opciones = new Opciones(arg);
        Integer expected = 5;

        Assert.assertEquals(expected, opciones.getNumero());
        Assert.assertEquals('v', opciones.getOrientacion());
        Assert.assertEquals('i', opciones.getDireccion());
        Assert.assertEquals('p', opciones.getPar());
        Assert.assertEquals("ejemplo.txt", opciones.getNombreArchivo());
    }

}
