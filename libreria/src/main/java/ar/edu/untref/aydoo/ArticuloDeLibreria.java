package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

    private Float precioDeVenta;

    public ArticuloDeLibreria(Float precio) {
        super(precio);
        this.precioDeVenta = precio + 20f;
    }

    @Override
    public Float getPrecio() {
        return this.precioDeVenta;
    }
}
