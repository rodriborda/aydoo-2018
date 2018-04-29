package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LibreriaTest {

    @Test
    public void cobrarMesAUnClienteSinCompraDevuelveCero() {
        Libreria libreria = new Libreria();
        Cliente cliente = new Cliente();
        int mes = 1;

        Float importeACobrar = libreria.cobrarMes(mes, cliente);

        Assert.assertEquals(0.0f, importeACobrar, 0.001);
    }

    @Test
    @Ignore
    public void cobrarMesAClienteQueComproUnProductoDevuelveElPrecioConIva(){
        Libreria libreria = new Libreria();
        Cliente cliente = new Cliente();
        int mes = 1;
        Compra compraCliente = new Compra();
        Producto libro = new Producto(200);

        compraCliente.agregarProducto(libro);
        Float importeACobrar = libreria.cobrarMes(mes, cliente);

        Assert.assertEquals(242f, importeACobrar, 0.001);

    }
}
