package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    private List<Cliente> clientes;
    private List<Compra> compras;
    private List<Suscripcion> suscripciones;

    public Libreria(){
        this.clientes = new ArrayList<Cliente>();
        this.compras = new ArrayList<Compra>();
        this.suscripciones = new ArrayList<Suscripcion>();

    }

    public Float cobrarMes(Fecha fecha, Cliente cliente) {
        Float totalAPagar = 0f;

        for (Compra compra: this.compras) {
            if(compra.getMes()==fecha.getMes() && compra.getCliente()==cliente){
                totalAPagar += compra.calcularTotalAPagar();
            }
        }

        return totalAPagar;
    }

    public void registrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
        cliente.registrar();
    }

    public void registrarCompra(Compra compra){
        this.compras.add(compra);
    }

    public Float cobrarAnio(Fecha fecha, Cliente cliente) {
        Float totalAPagar = 0f;

        for (Compra compra: this.compras) {
            if(compra.getAnio()==fecha.getAnio() && compra.getCliente()==cliente){
                totalAPagar += compra.calcularTotalAPagar();
            }
        }

        return totalAPagar;
    }

    public void registrarSuscripcion(ProductoPeriodico periodico, Cliente cliente) {
        Suscripcion nuevaSuscripcion = new Suscripcion(periodico, cliente);
        this.suscripciones.add(nuevaSuscripcion);
        cliente.suscribir(nuevaSuscripcion);
    }
}
