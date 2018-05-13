package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RespuestaPrinter {

    public void mostrarResultado(final String texto, final String archivo, final Integer numero, final char modo) throws IOException {
        String resultado = caratula(numero, modo) + texto;

        if (archivo == null) {
            System.out.println(resultado);
        } else {
            System.out.println("fibo<" + numero + "> guardado en " + archivo);
            escribirArchivo(resultado, archivo);
        }
    }

    private String caratula(final Integer nro, final char modo) {
        String caratula = "fibo<" + nro + ">";

        if (modo == 's' || modo == 'l') {
            caratula = caratula + modo + ":";
        } else {
            caratula = caratula + ":";
        }

        return caratula;
    }

    private void escribirArchivo(final String resultado, final String archivo) throws IOException {
        File archivoConResultado = new File(archivo);
        FileWriter escribidorArchivo = null;
        try {
            escribidorArchivo = new FileWriter(archivoConResultado);
            PrintWriter escribidor = new PrintWriter(escribidorArchivo);
            escribidor.println(resultado);

        } catch (IOException e) {
            throw e;
        } finally {
            escribidorArchivo.close();
        }
    }

}
