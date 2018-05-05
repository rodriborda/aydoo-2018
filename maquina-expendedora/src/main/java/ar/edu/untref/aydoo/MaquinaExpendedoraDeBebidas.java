package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {

    private HacedorDeCafeConLeche hacedorDeCafeConLeche = new HacedorDeCafeConLeche();
    private HacedorDeTeConLeche hacedorDeTeConLeche = new HacedorDeTeConLeche();
    private Azucarero azucarero = new Azucarero();

    public void hacerCafeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
        this.hacedorDeCafeConLeche.preparar(unVaso);
        this.azucarero.ponerAzucar(unVaso, cantidadAzucar);
    }

    public void hacerTeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
        this.hacedorDeTeConLeche.preparar(unVaso);
        this.azucarero.ponerAzucar(unVaso, cantidadAzucar);
    }
}
