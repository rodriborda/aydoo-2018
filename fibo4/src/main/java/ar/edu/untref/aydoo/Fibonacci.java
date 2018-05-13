package ar.edu.untref.aydoo;

import java.io.*;

public final class Fibonacci {

    public static void main(final String[] args) throws IOException {

        Opciones opciones = new Opciones(args);
        GeneradorRespuesta respuesta = new GeneradorRespuesta();
        Resultados resultados = new Resultados();

        Integer numero;
        char orientacion;
        char direccion;
        char modo;
        char par;
        String archivo;
        boolean opcionValida = opciones.opcionesValidas();
        String textoDelResultado;

        if (!opcionValida) {
            System.out.println("Opciones no validas.");
        } else {

            numero = opciones.getNumero();
            orientacion = opciones.getOrientacion();
            direccion = opciones.getDireccion();
            modo = opciones.getModo();
            par = opciones.getPar();
            archivo = opciones.getNombreArchivo();

            textoDelResultado = resultados.getResultado(orientacion, modo, numero, direccion, par);
            respuesta.mostrarResultado(textoDelResultado, archivo, numero, modo);
        }
    }
}
