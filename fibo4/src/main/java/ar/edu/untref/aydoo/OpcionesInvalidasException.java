package ar.edu.untref.aydoo;

public class OpcionesInvalidasException extends Exception {

    OpcionesInvalidasException(final String mensajeExcepcion) {
        super(mensajeExcepcion);
    }
}