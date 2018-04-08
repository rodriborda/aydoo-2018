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
        this.posiciones[posicion.getPosicionVertical()][posicion.getPosicionHorizontal()].setEsAgua(false);
    }

    public boolean estaDisponible(Posicion posicion) {

        return this.posiciones[posicion.getPosicionVertical()][posicion.getPosicionHorizontal()].esAgua();

    }
}
