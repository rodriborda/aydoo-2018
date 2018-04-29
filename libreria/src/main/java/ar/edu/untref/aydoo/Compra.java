package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private List<Producto> productos;

    public Compra(){
        this.productos = new ArrayList<Producto>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Float calcularTotalAPagar() {
        Float total = 0f;

        for (Producto producto : this.productos) {
            total += producto.getPrecio() * 1.21f;
        }

        return total;
    }
}
