package ar.edu.untref.aydoo;

import java.io.*;

public final class Fibonacci {

    public static void main(final String[] args) throws IOException {

        Opciones opciones = new Opciones(args);
        RespuestaPrinter respuesta = new RespuestaPrinter();
        CalculadorResultado calculadorResultado = new CalculadorResultado();
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        try {
            validador.verificarOpciones();
        } catch (Exception OpcionesInvalidasException) {
            System.out.println(OpcionesInvalidasException.getMessage());
            return;
        }

        Integer numero = opciones.getNumero();
        char orientacion = opciones.getOrientacion();
        char direccion = opciones.getDireccion();
        char modo = opciones.getModo();
        char par = opciones.getPar();
        String archivo = opciones.getNombreArchivo();

        String textoDelResultado = calculadorResultado.getResultado(orientacion, modo, numero, direccion, par);
        respuesta.mostrarResultado(textoDelResultado, archivo, numero, modo);

    }
}
