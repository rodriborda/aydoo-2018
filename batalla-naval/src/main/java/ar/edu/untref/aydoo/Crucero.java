package ar.edu.untref.aydoo;

public class Crucero extends Barco{

    private int disparosRecividos;

    public Crucero(){
        this.disparosRecividos = 0;
        super.cantidadDePosiciones = 2;
    }

    @Override
    public ResultadoDisparo recibirDisparo() {
        if(this.disparosRecividos < 1){
            this.disparosRecividos++;
            return ResultadoDisparo.TOCADO;
        }else {
            return ResultadoDisparo.HUNDIDO;
        }
    }
}
