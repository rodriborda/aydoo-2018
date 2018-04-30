package ar.edu.untref.aydoo;

public class ProductoPeriodico extends Producto {

    private Integer periodicidad;

    public ProductoPeriodico(Float precio, Integer periodicidad) {
        super(precio);
        this.periodicidad = periodicidad;
    }
}
