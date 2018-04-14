package ar.edu.untref.aydoo;

public class Posicion {

    private int posicionVertical;
    private int posicionHorizontal;
    private boolean vacio;
    private Bote bote;
    private Crucero crucero;

    public Posicion(int posicionHorizontal, int posicionVertical) {
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
        this.vacio = true;
    }

    public boolean esAgua() {
        return this.vacio;
    }

    public int getPosicionVertical() {
        return posicionVertical;
    }

    public int getPosicionHorizontal() {
        return posicionHorizontal;
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
