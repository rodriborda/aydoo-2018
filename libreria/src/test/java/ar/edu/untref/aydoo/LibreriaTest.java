package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LibreriaTest {

    @Test
    public void cobrarMesAUnClienteSinCompraDevuelveCero() {
        Libreria libreria = new Libreria();
        Cliente cliente = new Cliente();
        Fecha mes = new Fecha(1);

        Float importeACobrar = libreria.cobrarMes(mes, cliente);

        Assert.assertEquals(0.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarMesAClienteQueComproUnProductoDevuelveElPrecioConIva(){
        Libreria libreria = new Libreria();
        Cliente cliente = new Cliente();
        Fecha mes = new Fecha(1);
        Compra compraCliente = new Compra(cliente);
        Producto libro = new Producto(200f);

        compraCliente.agregarProducto(libro);
        libreria.registrarCompra(compraCliente);
        Float importeACobrar = libreria.cobrarMes(mes, cliente);

        Assert.assertEquals(242f, importeACobrar, 0.001);

    }
}
