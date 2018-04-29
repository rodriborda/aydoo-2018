package ar.edu.untref.aydoo;

public class Crucero extends Barco{

    public Crucero(){
        super.disparosRecividos = 0;
        super.cantidadDePosiciones = 2;
    }

    @Override
    public ResultadoDisparo recibirDisparo() {
        if(super.disparosRecividos < 1){
            super.disparosRecividos++;
            return ResultadoDisparo.TOCADO;
        }else {
            return ResultadoDisparo.HUNDIDO;
        }
    }

    @Override
    public int getDisparosRecividos() {
        return super.disparosRecividos;
    }
}
