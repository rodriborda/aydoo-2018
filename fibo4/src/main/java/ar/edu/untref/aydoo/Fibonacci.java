package ar.edu.untref.aydoo;

import java.io.*;

public final class Fibonacci {

    public static void main(final String[] args) throws IOException {
        Integer numero;
        char orientacion;
        char direccion;
        char modo;
        String archivo;
        boolean opcionValida;
        String textoDelResultado;
        Opciones opciones = new Opciones(args);

        if (args.length == 1) {
            numero = Integer.parseInt(args[0]);
            orientacion = 'h';
            direccion = 'd';
            opcionValida = true;
            modo = '-';
            archivo = null;

        } else {
            numero = opciones.getNumero();
            orientacion = opciones.getOrientacion();
            direccion = opciones.getDireccion();
            modo = opciones.getModo();
            archivo = opciones.getNombreArchivo();
            opcionValida = opciones.opcionesValidas();
        }

       if (opcionValida) {
           if (modo == 's') {
               textoDelResultado = calcularSumatoria(numero).toString();
           } else {
               if (direccion == 'd') {
                   textoDelResultado = menorMayor(numero, orientacion);
               } else {
                   textoDelResultado = mayorMenor(numero, orientacion);
               }
           }
           mostrarResultado(textoDelResultado, archivo, orientacion, numero, modo);
       } else {
           System.out.print("Opciones no validas.");
       }
    }

    private static Integer calcularSumatoria(Integer numero) {
        Integer resultado = 0;
        for (int i = 0; i < numero; i++) {
            resultado = resultado + getFibonacci(i);
        }
        return resultado;
    }

    private static String caratula(final Integer nro, final char orientacion, final char modo) {
        String caratula = "fibo<" + nro + ">";

        if (orientacion == 'h') {
            if (modo == 's' || modo == 'l') {
                caratula = caratula + modo + ": ";
            } else {
                caratula = caratula + ": ";
            }

        } else {
            if (modo == 's' || modo == 'l') {
                caratula = caratula + modo + ":\n";
            } else {
                caratula = caratula + ":\n";
            }
        }

        return caratula;
    }

    public static String menorMayor(final int entrada, final char orientacion) {
        String textoDelResultado = "";
        Integer resultado;
        for (int i = 0; i < entrada; i++) {
            resultado = getFibonacci(i);
            if (i == entrada - 1) {
                textoDelResultado = textoDelResultado + resultado.toString();
            } else {
                if (orientacion == 'h') {
                    textoDelResultado = textoDelResultado + resultado.toString() + " ";
                } else {
                    textoDelResultado = textoDelResultado + resultado.toString() + "\n";
                }

            }
        }
        return textoDelResultado;
    }

    public static String mayorMenor(final int entrada, final char orientacion) {
        String textoDelResultado = "";
        Integer resultado;
        for (int i = entrada - 1; i >= 0; i--) {
            resultado = getFibonacci(i);
            if (i == 0) {
                textoDelResultado = textoDelResultado + resultado.toString();
            } else {
                if (orientacion == 'h') {
                    textoDelResultado = textoDelResultado + resultado.toString() + " ";
                } else {
                    textoDelResultado = textoDelResultado + resultado.toString() + "\n";
                }
            }
        }
        return textoDelResultado;
    }

    private static int getFibonacci(final int numero) {
        int a = 0, b = 1, c = 0;
        for (int i = 1; i < numero; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        if (numero == 1) {
            return 1;
        } else {
            return c;
        }
    }

    private static void mostrarResultado(final String texto, final String archivo, final char orientacion, final Integer numero, final char modo) throws IOException {
        if (archivo == null) {
            System.out.print(caratula(numero, orientacion, modo));
            System.out.println(texto);
        } else {
            System.out.println("fibo<" + numero + "> guardado en " + archivo);
            escribirArchivo(texto, archivo, orientacion, numero, modo);
        }
    }

    private static void escribirArchivo(final String texto, final String archivo, final char orientacion, final Integer numero, final char modo) throws IOException {
        File archivoConResultado = new File(archivo);
        FileWriter escribidorArchivo = null;
        try {
            escribidorArchivo = new FileWriter(archivoConResultado);
            PrintWriter escribidor = new PrintWriter(escribidorArchivo);

            escribidor.print(caratula(numero, orientacion, modo));
            escribidor.print(texto);

        } catch (IOException e) {
            throw e;
        } finally {
            escribidorArchivo.close();
        }
    }
}
