package ar.edu.untref.aydoo;

public class Vaso {

    private int cantidadDeAzucar = 0;
    private boolean cafe = false;
    private boolean te = false;

    public int getCantidadDeAzucar() {
        return this.cantidadDeAzucar;
    }

    public void setCantidadDeAzucar(int cantidadDeAzucar){
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public boolean tieneAzucar() {
        return this.cantidadDeAzucar > 0;
    }

    public void agregarCafe(){
        this.cafe = true;
    }

    public boolean tieneCafe() {
        return this.cafe;
    }


    public boolean tieneTe() {
        return this.te;
    }
}
