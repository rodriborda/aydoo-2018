package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private Cliente cliente;
    private ProductoPeriodico producto;
    private Libreria libreria;

    @Before
    public void setUp(){
        this.cliente = new Cliente("Rodrigo","Olavarria");
        this.producto = new ProductoPeriodico(200f,2);
        this.libreria = new Libreria();
    }

    @Test
    public void siClienteNoEstaSuscriptoAlProductoDevuelveFalse(){

        Assert.assertFalse(this.cliente.estaSuscripto(this.producto));
    }

    @Test
    public void siClienteEstaSuscriptoAlProductoDevuelveTrue(){
        this.libreria.registrarSuscripcion(this.producto, this.cliente);

        Assert.assertTrue(this.cliente.estaSuscripto(this.producto));
    }

    @Test
    public void siClienteNoEstaRegistradoEnLaLibreriaDevuelveFalse(){

        Assert.assertFalse(this.cliente.estaRegistrado());
    }

    @Test
    public void siClienteEstaRegistradoEnlaLibreriaDevuelveTrue(){
        this.libreria.registrarCliente(this.cliente);

        Assert.assertTrue(this.cliente.estaRegistrado());
    }
}
