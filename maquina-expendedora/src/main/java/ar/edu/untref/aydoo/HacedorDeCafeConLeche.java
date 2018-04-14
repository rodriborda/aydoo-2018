package ar.edu.untref.aydoo;

public class HacedorDeCafeConLeche {

    private Cafetero cafetero = new Cafetero();
    private Lechero lechero = new Lechero();

    public void preparar(Vaso unVaso) {
        this.cafetero.agregarCafe(unVaso);
        this.lechero.agregarLeche(unVaso);
    }
}
