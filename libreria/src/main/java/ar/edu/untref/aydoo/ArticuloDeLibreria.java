package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

    public ArticuloDeLibreria(Float precio) {
        super(precio);
    }

    @Override
    public Float getPrecio() {
        return super.getPrecio() * 1.21f;
    }
}
