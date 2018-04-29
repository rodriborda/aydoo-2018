package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LibreriaTest {

    private Libreria libreria;
    private Cliente cliente;
    private Producto producto;
    private Producto artLibreria;

    @Before
    public void setUp(){
        this.libreria = new Libreria();
        this.cliente = new Cliente();
        this.producto = new Producto(200f);
        this.artLibreria = new ArticuloDeLibreria(200f);

    }

    @Test
    public void cobrarMesAUnClienteSinCompraDevuelveCero() {
        Fecha fecha = new Fecha(1,18);

        Float importeACobrar = this.libreria.cobrarMes(fecha, this.cliente);

        Assert.assertEquals(0.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarMesAClienteQueComproUnProductoDevuelveElPrecioConIva(){
        Fecha fecha = new Fecha(1,18);
        Compra compraCliente = new Compra(this.cliente, fecha);
        compraCliente.agregarProducto(this.producto);
        this.libreria.registrarCompra(compraCliente);

        Float importeACobrar = this.libreria.cobrarMes(fecha, this.cliente);

        Assert.assertEquals(242f, importeACobrar, 0.001);

    }

    @Test
    public void dcwaee(){
        Fecha fecha = new Fecha(1,18);
        Compra compraCliente = new Compra(this.cliente, fecha);
        compraCliente.agregarProducto(this.artLibreria);
        this.libreria.registrarCompra(compraCliente);

        Float importeACobrar = this.libreria.cobrarMes(fecha, this.cliente);

        Assert.assertEquals(266.2, importeACobrar, 0.001);

    }

    @Test
    public void cobrarMesSoloCobraASuRespectivoCliente(){
        Fecha fecha = new Fecha(1,18);
        Compra compraCliente = new Compra(this.cliente, fecha);
        compraCliente.agregarProducto(this.producto);
        this.libreria.registrarCompra(compraCliente);
        Cliente otroCliente = new Cliente();

        Float importeACobrar = this.libreria.cobrarMes(fecha, otroCliente);

        Assert.assertEquals(0f, importeACobrar, 0.001);

    }

    @Test
    public void cobrarAClienteUnMesSinCompraDevuelveCero(){
        Fecha fecha = new Fecha(1,18);
        Compra compraCliente = new Compra(this.cliente, fecha);
        compraCliente.agregarProducto(this.producto);
        this.libreria.registrarCompra(compraCliente);
        Fecha nuevaFecha = new Fecha(2,18);

        Float importeACobrar = this.libreria.cobrarMes(nuevaFecha, this.cliente);

        Assert.assertEquals(0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarVariasComprasAUnMismoClienteEnElMismoMesDevuelveLaSumaTotal(){
        Fecha fecha = new Fecha(1,18);
        Compra primeraCompra = new Compra(this.cliente, fecha);
        primeraCompra.agregarProducto(this.producto);
        this.libreria.registrarCompra(primeraCompra);
        Compra segundaCompra = new Compra(this.cliente, fecha);
        segundaCompra.agregarProducto(this.artLibreria);
        this.libreria.registrarCompra(segundaCompra);

        Float importeACobrar = this.libreria.cobrarMes(fecha, this.cliente);

        Assert.assertEquals(508.2, importeACobrar, 0.001);
    }

    @Test
    public void cobrarMesSoloCobraElTotalDelMesSeleccionado(){
        Fecha fecha = new Fecha(1,18);
        Fecha otraFecha = new Fecha(2,18);
        Compra primeraCompra = new Compra(this.cliente, fecha);
        primeraCompra.agregarProducto(this.producto);
        this.libreria.registrarCompra(primeraCompra);
        Compra segundaCompra = new Compra(this.cliente, fecha);
        segundaCompra.agregarProducto(this.artLibreria);
        this.libreria.registrarCompra(segundaCompra);
        Compra terceraCompra = new Compra(this.cliente, otraFecha);
        terceraCompra.agregarProducto(this.artLibreria);
        this.libreria.registrarCompra(terceraCompra);

        Float importeACobrar = this.libreria.cobrarMes(fecha, this.cliente);

        Assert.assertEquals(508.2, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAnioAClienteSinComprasDevuelveCero(){
        Fecha fecha = new Fecha(1, 18);

        Float importeACobrar = this.libreria.cobrarAnio(fecha, this.cliente);

        Assert.assertEquals(0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAnioAClienteConUnaCompraDevuelveTotalAPagar(){
        Fecha fecha = new Fecha(1, 18);
        Compra compra = new Compra(this.cliente, fecha);
        compra.agregarProducto(this.producto);
        this.libreria.registrarCompra(compra);

        Float importeACobrar = this.libreria.cobrarAnio(fecha, this.cliente);

        Assert.assertEquals(242f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAnioAClienteConDosComprasElMismoMesDevuelveTotalAPagar(){
        Fecha fecha = new Fecha(1, 18);
        Compra compra = new Compra(this.cliente, fecha);
        compra.agregarProducto(this.producto);
        compra.agregarProducto(this.producto);
        this.libreria.registrarCompra(compra);

        Float importeACobrar = this.libreria.cobrarAnio(fecha, this.cliente);

        Assert.assertEquals(484f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAnioAClienteConComprasDeDistintosMesesDevuelveLaSumaTotal(){
        Fecha fecha = new Fecha(1, 18);
        Fecha fecha2 = new Fecha(5, 18);
        Compra primeraCompra = new Compra(this.cliente, fecha);
        primeraCompra.agregarProducto(this.producto);
        this.libreria.registrarCompra(primeraCompra);
        Compra segundaCompra = new Compra(this.cliente, fecha2);
        segundaCompra.agregarProducto(this.artLibreria);
        this.libreria.registrarCompra(segundaCompra);

        Float importeACobrar = this.libreria.cobrarAnio(fecha, this.cliente);

        Assert.assertEquals(508.2, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAnioSoloCobraComprasDelAnioSeleccionado(){
        Fecha fecha = new Fecha(1, 18);
        Fecha fecha2 = new Fecha(5, 19);
        Compra primeraCompra = new Compra(this.cliente, fecha);
        primeraCompra.agregarProducto(this.producto);
        this.libreria.registrarCompra(primeraCompra);
        Compra segundaCompra = new Compra(this.cliente, fecha2);
        segundaCompra.agregarProducto(this.artLibreria);
        this.libreria.registrarCompra(segundaCompra);

        Float importeACobrar = this.libreria.cobrarAnio(fecha, this.cliente);

        Assert.assertEquals(242f, importeACobrar, 0.001);
    }

}
