package ar.edu.untref.aydoo;

public class Crucero extends Barco{

    private String nombre;
    private int disparosRecividos;

    public Crucero(String nombre){
        this.nombre = nombre;
        this.disparosRecividos = 0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Disparo recibirDisparo() {
        if(this.disparosRecividos < 1){
            this.disparosRecividos++;
            return Disparo.TOCADO;
        }else {
            return Disparo.HUNDIDO;
        }
    }
}
