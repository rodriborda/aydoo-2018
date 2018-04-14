package ar.edu.untref.aydoo;

public class Tablero {
    private Posicion[][] posiciones;

    public Tablero() {
        this.posiciones = new Posicion[10][10];
        for (int i = 0; i < posiciones.length; i++) {
            for (int j = 0; j < posiciones.length; j++) {
                this.posiciones[i][j] = new Posicion(i, j);
            }

        }
    }

    public void ponerBote(Bote unBote, Posicion posicion) {
        if(this.posiciones[posicion.getPosicionVertical()][posicion.getPosicionHorizontal()].esAgua()){
            this.posiciones[posicion.getPosicionVertical()][posicion.getPosicionHorizontal()].setBote(unBote);
        }
    }

    public void ponerCrucero(Crucero unCrucero, Posicion primeraPosicion) {
        if(this.estaDisponible(primeraPosicion) && this.posiciones[primeraPosicion.getPosicionVertical()][primeraPosicion.getPosicionHorizontal() + 1].esAgua()){
            this.posiciones[primeraPosicion.getPosicionHorizontal()][primeraPosicion.getPosicionVertical()].setCrucero(unCrucero);
            this.posiciones[primeraPosicion.getPosicionHorizontal()][primeraPosicion.getPosicionVertical() + 1].setCrucero(unCrucero);

        }
    }

    public boolean estaDisponible(Posicion posicion) {

        return this.posiciones[posicion.getPosicionHorizontal()][posicion.getPosicionVertical()].esAgua();

    }

    public String getBote(Posicion posicion) {
        return this.posiciones[posicion.getPosicionHorizontal()][posicion.getPosicionVertical()].getBote();
    }

    public Disparo disparar(Posicion posicion) {
        if(this.estaDisponible(posicion)){
            return Disparo.AGUA;
        }else {
            this.posiciones[posicion.getPosicionHorizontal()][posicion.getPosicionVertical()].setEsAgua();
            return Disparo.HUNDIDO;
        }
    }

}
