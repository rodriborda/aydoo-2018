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

    public void ponerBote(Bote unBote, Posicion posicion) throws ArrayIndexOutOfBoundsException {
        try {
            if(this.estaDisponible(posicion)){
                this.posiciones[posicion.getFila()][posicion.getColumna()].setBarco(unBote);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new ArrayIndexOutOfBoundsException("La posicion ingresada esta fuera de los limites del tablero");
        }

    }

    public void ponerCrucero(Crucero unCrucero, Posicion primeraPosicion, Orientacion orientacion) throws ArrayIndexOutOfBoundsException {
        try {
            if(orientacion==Orientacion.HORIZONTAL){
                if(this.estaDisponible(primeraPosicion) && this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna() + 1].esAgua()){
                    this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna()].setBarco(unCrucero);
                    this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna() + 1].setBarco(unCrucero);
                }
            }else {
                if(this.estaDisponible(primeraPosicion) && this.posiciones[primeraPosicion.getFila() + 1][primeraPosicion.getColumna()].esAgua()){
                    this.posiciones[primeraPosicion.getFila()][primeraPosicion.getColumna()].setBarco(unCrucero);
                    this.posiciones[primeraPosicion.getFila() + 1][primeraPosicion.getColumna()].setBarco(unCrucero);
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new ArrayIndexOutOfBoundsException("La posicion ingresada esta fuera de los limites del tablero");
        }

    }

    public boolean estaDisponible(Posicion posicion) {

        return this.posiciones[posicion.getFila()][posicion.getColumna()].esAgua();

    }

    public Barco getBarco(Posicion posicion) {

        return this.posiciones[posicion.getFila()][posicion.getColumna()].getBarco();

    }

    public ResultadoDisparo disparar(Posicion posicion) {
        return this.posiciones[posicion.getFila()][posicion.getColumna()].recibirDisparo();
    }

}
