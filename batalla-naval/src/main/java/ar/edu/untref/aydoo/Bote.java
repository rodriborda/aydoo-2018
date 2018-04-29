package ar.edu.untref.aydoo;

public class Bote extends Barco{

    public Bote(){
        super.disparosRecividos = 0;
        super.cantidadDePosiciones = 1;
    }

    @Override
    public ResultadoDisparo recibirDisparo() {
        return ResultadoDisparo.HUNDIDO;
    }

    @Override
    public int getDisparosRecividos(){ return super.disparosRecividos; }
}
