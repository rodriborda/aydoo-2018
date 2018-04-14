package ar.edu.untref.aydoo;

public class Posicion {

    private int fila;
    private int columna;
    private boolean vacio;
    private Barco barco;

    public Posicion(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        this.vacio = true;
    }

    public boolean esAgua() {
        return this.vacio;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setAgua() {
        this.vacio = true;
    }

    public String getNombreBarco() {
        return this.barco.getNombre();
    }

    public void setBote(Bote unBote){
        this.barco = unBote;
        this.vacio = false;
    }

    public void setCrucero(Crucero crucero) {
        this.barco = crucero;
        this.vacio = false;
    }

    public Barco getBarco(){
        return this.barco;
    }
}
