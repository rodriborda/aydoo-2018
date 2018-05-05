package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private List<Producto> productos;
    private Cliente cliente;
    private Fecha fecha;

    public Compra(Cliente cliente, Fecha fecha){
        this.productos = new ArrayList<Producto>();
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Float calcularTotalAPagar() {
        Float total = 0f;

        for (Producto producto : this.productos) {
            Float precio = producto.getPrecio();

            if(this.cliente.estaSuscripto(producto)){
                precio -= (precio * 0.20f);
            }

            if(this.cliente.estaRegistrado()){
                total += precio - (precio * 0.05f);
            } else {
                total += precio;
            }
        }

        return total;
    }

    public Integer getMes() {
        return this.fecha.getMes();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Integer getAnio() {
        return this.fecha.getAnio();
    }
}
