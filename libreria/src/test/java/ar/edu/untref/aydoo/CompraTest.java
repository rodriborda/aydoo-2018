package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {

    @Test
    public void calcularTotalAPagarSinAgregarProductosDevuelveCero(){
        Compra compra = new Compra();

        Assert.assertEquals(0f, compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void calcularTotalAPagarConUnProductoDevuelveElPrecioConIva(){
        Compra compra = new Compra();
        Producto libro = new Producto(200f);

        compra.agregarProducto(libro);

        Assert.assertEquals(242f, compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void calcularTotalAPagarComprandoDosProductosDevuelveLaSumaDeAmbos(){
        Compra compra = new Compra();
        Producto libro = new Producto(200f);

        compra.agregarProducto(libro);
        compra.agregarProducto(libro);

        Assert.assertEquals(484f, compra.calcularTotalAPagar(), 0.001);
    }
}
