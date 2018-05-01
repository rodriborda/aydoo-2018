package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Program {

    protected Program() {
    }

    public static final void main(final String[] arg) {

        Fibonachi fibo = new Fibonachi();


        try {
            validar(arg);
        } catch (Exception IllegalArgumentException) {
            System.out.println("Opciones no validas");
            return;
        }

        if (arg.length == 1) {
            String resultado = fibo.fibonachiHorizontalDirecto(Integer.parseInt(arg[0]));
            System.out.println(resultado);

        } else {

            String opcion = arg[0];
            int numero = Integer.parseInt(arg[1]);
            String resultado;

            switch (opcion) {
                case "-o=hd":
                    resultado = fibo.fibonachiHorizontalDirecto(numero);
                    System.out.println(resultado);
                    break;

                case "-o=hi":
                    resultado = fibo.fibonachiHorizontalInverso(numero);
                    System.out.println(resultado);
                    break;

                case "-o=vd":
                    resultado = fibo.fibonachiVerticalDirecto(numero);
                    System.out.println(resultado);
                    break;

                case "-o=vi":
                    resultado = fibo.fibonachiVerticalInverso(numero);
                    System.out.println(resultado);
                    break;
                case "-m":
                    resultado = fibo.calcularSumaFibonachi(numero);
                    System.out.println(resultado);
                    break;
                case "-f":
                    resultado = fibo.fibonachiVerticalInverso(numero);
                    guardarEnArchivo(resultado);
                    break;
                default:
                    System.out.println("Opciones no validas");
                    break;
            }
        }
    }

    private static void guardarEnArchivo(String fibonacci) {
        File archivo;
        PrintWriter escribir;
        archivo = new File("ejemplo.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println("Archivo creado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            escribir = new PrintWriter(archivo, "utf-8");
            escribir.println(fibonacci);
            escribir.close();
            System.out.println("Archivo guardado");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void validar(String[] args) {
        if (args.length > 1) {
            try {
                Integer.parseInt(args[1]);
            } catch (Exception exception) {
                throw new IllegalArgumentException();
            }
        } else {
            try {
                Integer.parseInt(args[0]);
            } catch (Exception exception) {
                throw new IllegalArgumentException();
            }
        }
    }

}
