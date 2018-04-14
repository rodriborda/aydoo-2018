package ar.edu.untref.aydoo;

public class Bote extends Barco{

    private String nombre;

    public Bote(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Disparo recibirDisparo() {
        return Disparo.HUNDIDO;
    }
}
