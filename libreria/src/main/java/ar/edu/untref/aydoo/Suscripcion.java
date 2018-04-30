package ar.edu.untref.aydoo;

public class Suscripcion {

    private Producto producto;
    private Cliente cliente;

    public Suscripcion(ProductoPeriodico producto, Cliente cliente) {
        this.cliente = cliente;
        this.producto = producto;
    }

    public Producto getProducto() {
        return this.producto;
    }
}
