package ar.edu.untref.aydoo;

public class Cliente {

    private boolean registrado;

    public Cliente(){
        this.registrado = false;
    }

    public boolean estaRegistrado() {
        return this.registrado;
    }

    public void registrar() {
        this.registrado = true;
    }
}
