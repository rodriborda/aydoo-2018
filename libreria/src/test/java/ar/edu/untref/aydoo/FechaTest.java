package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FechaTest {

    @Test
    public void crearFechaConMesYAnioValidosGuardaCorrectamenteLosValores(){
        Integer mes = 5;
        Integer anio = 18;
        Fecha fecha = new Fecha(mes, anio);

        Assert.assertEquals(mes,fecha.getMes());
        Assert.assertEquals(anio, fecha.getAnio());
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearFechaConMesMenorA1DevuelveExcepcion(){
        Integer mes = 0;
        Integer anio = 1;
        Fecha fecha = new Fecha(mes, anio);
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearFechaConMesMayorA13DevuelveExcepcion(){
        Integer mes = 13;
        Integer anio = 1;
        Fecha fecha = new Fecha(mes, anio);
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearFechaConAnioMenorA1DevuelveExcepcion(){
        Integer mes = 5;
        Integer anio = 0;
        Fecha fecha = new Fecha(mes, anio);
    }
}
