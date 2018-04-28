package ar.edu.untref.aydoo;

public class Bote extends Barco{

    @Override
    public ResultadoDisparo recibirDisparo() {
        return ResultadoDisparo.HUNDIDO;
    }
}
