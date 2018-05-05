package ar.edu.untref.aydoo;

public class Cliente {

    private String nombre;
    private String direccion;
    private boolean registrado;
    private Suscripcion suscripcion;

    public Cliente(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.registrado = false;
    }

    public boolean estaRegistrado() {
        return this.registrado;
    }

    public void registrar() {
        this.registrado = true;
    }

    public void suscribir(Suscripcion suscripcion){
        this.suscripcion = suscripcion;
    }

    public boolean estaSuscripto(Producto producto) {
        if(this.suscripcion!=null && this.suscripcion.getProducto()==producto){
           return true;
        }
        return false;
    }
}
