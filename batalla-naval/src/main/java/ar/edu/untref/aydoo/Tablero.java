package ar.edu.untref.aydoo;


public class Tablero {
    private Posicion[][] posiciones;

    public Tablero(int filas, int columnas) {
        this.posiciones = new Posicion[filas][columnas];
        for (int i = 0; i < posiciones.length; i++) {
            for (int j = 0; j < posiciones.length; j++) {
                this.posiciones[i][j] = new Posicion(i, j);
            }

        }
    }

    public void ponerBote(Bote unBote, Posicion posicion) {
        if(this.estaDisponible(posicion)){
            this.posiciones[posicion.getFila()][posicion.getColumna()].setBote(unBote);
        }
    }

    public void ponerCrucero(Crucero unCrucero, Posicion primeraPosicion, Orientacion orientacion) {

        if(orientacion==Orientacion.HORIZONTAL){
            if(this.estaDisponible(primeraPosicion) && this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna() + 1].esAgua()){
                this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna()].setCrucero(unCrucero);
                this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna() + 1].setCrucero(unCrucero);
            }
        }else {
            if(this.estaDisponible(primeraPosicion) && this.posiciones[primeraPosicion.getFila() + 1][primeraPosicion.getColumna()].esAgua()){
                this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna()].setCrucero(unCrucero);
                this.posiciones[primeraPosicion.getFila() + 1][primeraPosicion.getColumna()].setCrucero(unCrucero);
            }
        }

    }

    public boolean estaDisponible(Posicion posicion) {

        return this.posiciones[posicion.getFila()][posicion.getColumna()].esAgua();

    }

    public String getBote(Posicion posicion) {

        return this.posiciones[posicion.getFila()][posicion.getColumna()].getBote();

    }

    public Disparo disparar(Posicion posicion) {
        if(this.estaDisponible(posicion)){
            return Disparo.AGUA;
        }else {
            this.posiciones[posicion.getFila()][posicion.getColumna()].setAgua();
            return Disparo.HUNDIDO;
        }
    }

}
