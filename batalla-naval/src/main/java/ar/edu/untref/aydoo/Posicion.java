package ar.edu.untref.aydoo;

public class Posicion {

    private int fila;
    private int columna;
    private boolean vacio;
    private Bote bote;
    private Crucero crucero;

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

    public void setEsAgua() {
        this.vacio = true;
    }

    public String getBote() {
        return this.bote.getNombre();
    }

    public void setBote(Bote unBote){
        this.bote = unBote;
        this.vacio = false;
    }

    public void setCrucero(Crucero crucero) {
        this.crucero = crucero;
        this.vacio = false;
    }
}
