package ar.edu.untref.aydoo;

public class Posicion {

    private int fila;
    private int columna;
    private Barco barco;

    public Posicion(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
    }

    public boolean esAgua() {
        return this.barco==null;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setAgua() {
        this.barco = null;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public Barco getBarco(){
        return this.barco;
    }

    public ResultadoDisparo recibirDisparo() {
        if (this.esAgua()) {
            return ResultadoDisparo.AGUA;
        } else {
            ResultadoDisparo resultado = this.barco.recibirDisparo();
            this.setAgua();
            return resultado;
        }
    }
}
