package ar.edu.untref.aydoo;

public abstract class Barco {

    protected int cantidadDePosiciones;
    protected int disparosRecividos;

    abstract public ResultadoDisparo recibirDisparo();

    abstract public int getDisparosRecividos();

    public int getCantidadDePosiciones() {
        return cantidadDePosiciones;
    }
}
