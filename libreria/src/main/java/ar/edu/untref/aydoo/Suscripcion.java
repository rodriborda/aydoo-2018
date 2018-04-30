package ar.edu.untref.aydoo;

public class Suscripcion {

    private Producto periodico;
    private Cliente cliente;

    public Suscripcion(ProductoPeriodico periodico, Cliente cliente) {
        this.cliente = cliente;
        this.periodico = periodico;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Producto getProducto() {
        return this.periodico;
    }
}