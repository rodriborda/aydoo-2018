package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneradorRespuesta {

    public void mostrarResultado(final String texto, final String archivo, final Integer numero, final char modo) throws IOException {
        if (archivo == null) {
            System.out.print(caratula(numero, modo));
            System.out.println(texto);
        } else {
            System.out.println("fibo<" + numero + "> guardado en " + archivo);
            escribirArchivo(texto, archivo, numero, modo);
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

    private void escribirArchivo(final String texto, final String archivo, final Integer numero, final char modo) throws IOException {
        File archivoConResultado = new File(archivo);
        FileWriter escribidorArchivo = null;
        try {
            escribidorArchivo = new FileWriter(archivoConResultado);
            PrintWriter escribidor = new PrintWriter(escribidorArchivo);

            escribidor.print(caratula(numero, modo));
            escribidor.print(texto);

        } catch (IOException e) {
            throw e;
        } finally {
            escribidorArchivo.close();
        }
    }

}
