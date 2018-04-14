package ar.edu.untref.aydoo;

public class Crucero extends Barco{

    private String nombre;

    public Crucero(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Disparo recibirDisparo() {
        return Disparo.TOCADO;
    }
}
