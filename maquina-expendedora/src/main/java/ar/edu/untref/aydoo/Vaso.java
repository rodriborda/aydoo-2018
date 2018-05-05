package ar.edu.untref.aydoo;

public class Vaso {

    private int cantidadDeAzucar = 0;
    private boolean cafe = false;
    private boolean te = false;
    private boolean leche;

    public int getCantidadDeAzucar() {
        return this.cantidadDeAzucar;
    }

    public boolean tieneAzucar() {
        return this.cantidadDeAzucar > 0;
    }

    public boolean tieneCafe() {
        return this.cafe;
    }

    public boolean tieneTe() {
        return this.te;
    }


    public void setCantidadDeAzucar(int cantidadDeAzucar){
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public void agregarCafe(){
        this.cafe = true;
    }

    public void agregarTe(){
        this.te = true;
    }

    public void agregarLeche() {
        this.leche = true;
    }

    public boolean tieneLeche(){
        return this.leche;
    }
}
