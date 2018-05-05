package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CompraTest {

    private Compra compra;
    private Cliente cliente;
    private Fecha fecha;
    @Before
    public void setUp(){
        this.cliente = new Cliente("Rodrigo","Olavarria 3369");
        this.fecha = new Fecha(1,18);
        this.compra = new Compra(this.cliente, this.fecha);
    }

    @Test
    public void calcularTotalAPagarSinAgregarProductosDevuelveCero(){

        Assert.assertEquals(0f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void calcularTotalAPagarConUnProductoDevuelveTotalAPagar(){
        Producto libro = new Producto(200f);

        this.compra.agregarProducto(libro);

        Assert.assertEquals(200f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void calcularTotalAPagarComprandoDosProductosDevuelveLaSumaDeAmbos(){
        Producto libro = new Producto(200f);

        this.compra.agregarProducto(libro);
        this.compra.agregarProducto(libro);

        Assert.assertEquals(400f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarUnArticuloDeLibreriaDevuelveElPrecioDeVentaConIva() {
        Producto artLibreria = new ArticuloDeLibreria(200f);

        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(242f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarUnProductoYUnArticuloDeLibreriaSumaElPrecioCorrectoDeCadaUno() {
        Producto libro = new Producto(200f);
        Producto artLibreria = new ArticuloDeLibreria(200f);

        this.compra.agregarProducto(libro);
        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(442f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void compraDeUnProductoConClienteRegistradoDevuelvePrecioConDescuento() {
        Producto libro = new Producto(200f);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);

        this.compra.agregarProducto(libro);

        Assert.assertEquals(190f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void compraDeArticuloDeLibreriaConClienteRegistradoDevuelvePrecioDeVentaConDescuento() {
        Producto artLibreria = new ArticuloDeLibreria(200f);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);

        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(229.9, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarVariosProductosAplicaDescuentoYDevuelveRespectivoPrecio(){
        Producto libro = new Producto(200f);
        Producto artLibreria = new ArticuloDeLibreria(200f);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);

        this.compra.agregarProducto(libro);
        this.compra.agregarProducto(artLibreria);

        Assert.assertEquals(419.9, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarUnProductoPeriodicoSinSuscripcionDevuelveElTotalAPagar() {
        Producto periodico = new ProductoPeriodico(300f,1);

        this.compra.agregarProducto(periodico);

        Assert.assertEquals(300f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarUnProductoPeriodicoConSuscripcionDevuelveElPrecioConDescuento() {
        ProductoPeriodico periodico = new ProductoPeriodico(300f,1);
        Libreria libreria = new Libreria();
        libreria.registrarSuscripcion(periodico, this.cliente);


        this.compra.agregarProducto(periodico);

        Assert.assertEquals(240f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarProductoYProductoPeriodicoSoloAplicaDescuentoALaSuscripcion() {
        ProductoPeriodico periodico = new ProductoPeriodico(300f,1);
        Producto libro = new Producto(200f);
        Libreria libreria = new Libreria();
        libreria.registrarSuscripcion(periodico, this.cliente);

        this.compra.agregarProducto(libro);
        this.compra.agregarProducto(periodico);

        Assert.assertEquals(440f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarVariosProductosPeriodicosSoloAplicaDescuentoAlQueSeEstaSuscripto() {
        ProductoPeriodico periodico = new ProductoPeriodico(300f,1);
        ProductoPeriodico revista = new ProductoPeriodico(300f,1);
        Libreria libreria = new Libreria();
        libreria.registrarSuscripcion(periodico, this.cliente);

        this.compra.agregarProducto(periodico);
        this.compra.agregarProducto(revista);

        Assert.assertEquals(540f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarProductoPeriodicoSinSuscripcionConClienteRegistradoSoloAplicaDescuentoPorRegistro() {
        ProductoPeriodico periodico = new ProductoPeriodico(300f,1);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);

        this.compra.agregarProducto(periodico);


        Assert.assertEquals(285f, this.compra.calcularTotalAPagar(), 0.001);
    }

    @Test
    public void comprarProductoPeriodicoConSuscripcionYClienteRegistradoAplicaAmbosDescuentos() {
        ProductoPeriodico periodico = new ProductoPeriodico(300f,1);
        Libreria libreria = new Libreria();
        libreria.registrarCliente(this.cliente);
        libreria.registrarSuscripcion(periodico, this.cliente);

        this.compra.agregarProducto(periodico);

        Assert.assertEquals(228f, this.compra.calcularTotalAPagar(), 0.001);
    }
}
