package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private List<Producto> productos;
    private Cliente cliente;

    public Compra(Cliente cliente){
        this.productos = new ArrayList<Producto>();
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Float calcularTotalAPagar() {
        Float total = 0f;

        for (Producto producto : this.productos) {
            if(this.cliente.estaRegistrado()){
                total += producto.getPrecio() - (producto.getPrecio() * 0.05f);
            } else {
                total += producto.getPrecio();
            }
        }

        return total * 1.21f;
    }
}
