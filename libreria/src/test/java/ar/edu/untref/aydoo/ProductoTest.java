package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {

    private Producto producto;
    private Producto artLibreria;
    private Producto productoPeriodico;

    @Before
    public void setUp(){
        this.producto = new Producto(200f);
        this.artLibreria = new ArticuloDeLibreria(200f);
        this.productoPeriodico = new ProductoPeriodico(300f,3);
    }

    @Test
    public void cadaProductoPuedeDevolverSuRespectivoPrecio(){

        Assert.assertEquals(200f, this.producto.getPrecio(), 0.001);
        Assert.assertEquals(242f, this.artLibreria.getPrecio(), 0.001);
        Assert.assertEquals(300f, this.productoPeriodico.getPrecio(), 0.001);

    }
}
