package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    private List<Cliente> clientes;
    private List<Compra> compras;

    public Libreria(){
        this.clientes = new ArrayList<Cliente>();
        this.compras = new ArrayList<Compra>();
    }

    public Float cobrarMes(Fecha mes, Cliente unCliente) {
        Float totalAPagar = 0f;

        for (Compra compra: this.compras) {
            totalAPagar += compra.calcularTotalAPagar();
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
}
