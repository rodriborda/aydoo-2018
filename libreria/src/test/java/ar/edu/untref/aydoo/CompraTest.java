package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CompraTest {

    private Compra compra;
    private Cliente cliente;

    @Before
    public void setUp(){
        this.cliente = new Cliente();
        this.compra = new Compra(this.cliente);
    }

    @Test
    public void calcularTotalAPagarSinAgregarProductosDevuelveCero(){

        Assert.assertEquals(0f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void calcularTotalAPagarConUnProductoDevuelveElPrecioConIva(){
        Producto libro = new Producto(200f);

        this.compra.agregarProducto(libro);

        Assert.assertEquals(242f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void calcularTotalAPagarComprandoDosProductosDevuelveLaSumaDeAmbos(){
        Producto libro = new Producto(200f);

        this.compra.agregarProducto(libro);
        this.compra.agregarProducto(libro);

        Assert.assertEquals(484f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarUnArticuloDeLibreriaDevuelveElPrecioDeVentaConIva() {
        Producto artLibreria = new ArticuloDeLibreria(200f);

        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(266.2, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarUnProductoYUnArticuloDeLibreriaSumaElPrecioCorrectoDeCadaUno() {
        Producto libro = new Producto(200f);
        Producto artLibreria = new ArticuloDeLibreria(200f);

        this.compra.agregarProducto(libro);
        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(508.2, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void compraDeUnProductoConClienteRegistradoDevuelvePrecioConDescuento() {
        Producto libro = new Producto(200f);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);

        this.compra.agregarProducto(libro);

        Assert.assertEquals(229.9, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void compraDeArticuloDeLibreriaConClienteRegistradoDevuelvePrecioDeVentaConDescuento() {
        Producto artLibreria = new ArticuloDeLibreria(200f);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);

        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(252.89, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarVariosProductosAplicaDescuentoYDevuelveRespectivoPrecio(){
        Producto libro = new Producto(200f);
        Producto artLibreria = new ArticuloDeLibreria(200f);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);

        this.compra.agregarProducto(libro);
        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(482.79, this.compra.calcularTotalAPagar(), 0.001);
    }

}
