package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {

    public void hacerCafeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
        unVaso.setCantidadDeAzucar(cantidadAzucar);
        unVaso.agregarCafe();
    }

    public void hacerTeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
        unVaso.setCantidadDeAzucar(cantidadAzucar);
        unVaso.agregarTe();
    }
}
