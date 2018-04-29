package ar.edu.untref.aydoo;

public class Bote extends Barco{

    public Bote(){
        super.cantidadDePosiciones = 1;
    }

    @Override
    public ResultadoDisparo recibirDisparo() {
        return ResultadoDisparo.HUNDIDO;
    }
}
