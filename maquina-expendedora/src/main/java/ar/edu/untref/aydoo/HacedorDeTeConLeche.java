package ar.edu.untref.aydoo;

public class HacedorDeTeConLeche {

    private Tetero tetero = new Tetero();
    private Lechero lechero = new Lechero();

    public void preparar(Vaso unVaso) {
        this.tetero.agregarTe(unVaso);
        this.lechero.agregarLeche(unVaso);
    }
}
