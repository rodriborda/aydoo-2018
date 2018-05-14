package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class CalculadorResultado {

    private CalculadorSecuencia calculador;
    private String textoDelResultado;

    public CalculadorResultado() {
        this.calculador = new CalculadorSecuencia();
        this.textoDelResultado = "";
    }

    public String getResultado(final char orientacion, final char modo, final int numero, final char direccion, final char par) {
        if (orientacion == 'h') {
            this.horizontal(numero, direccion, par);
        } else if (orientacion == 'v') {
            this.vertical(numero, direccion, par);
        } else if (orientacion == 'p') {
            this.piramide(numero, direccion, par);
        }

        if (modo == 's') {
            this.calcularSumatoria(numero, orientacion, par);
        }

        return this.textoDelResultado;
    }

    private void horizontal(final int fibo, final char direccion, final char par) {
        int[] secuencia = getSecuencia(fibo, direccion, par);

        for (int i = 0; i < secuencia.length; i++) {
            this.textoDelResultado = this.textoDelResultado + " " + secuencia[i];
        }
    }

    private void vertical(final int fibo, final char direccion, final char par) {
        int[] secuencia = getSecuencia(fibo, direccion, par);

        for (int i = 0; i < secuencia.length; i++) {
            this.textoDelResultado = this.textoDelResultado + "\n" + secuencia[i];
        }
    }

    private void calcularSumatoria(final int fibo, final char orientacion, final char par) {
        int[] secuencia = calculador.getFibonacci(fibo);
        secuencia = this.getNumerosPares(secuencia, par);

        Integer resultado = 0;

        for (int i = 0; i < secuencia.length; i++) {
            resultado += secuencia[i];
        }

        if (orientacion == 'h') {
            this.textoDelResultado = " " + resultado.toString();
        } else {
            this.textoDelResultado = "\n" + resultado.toString();
        }
    }

    private void piramide(final int fibo, final char direccion, final char par) {
        int[] secuencia = getSecuencia(fibo, direccion, par);

        for (int i = 0; i < secuencia.length; i++) {
            this.textoDelResultado = this.textoDelResultado + "\n";
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    this.textoDelResultado = this.textoDelResultado + secuencia[j];
                } else {
                    this.textoDelResultado = this.textoDelResultado + secuencia[j] + " ";
                }
            }
        }
    }

    private int[] getSecuencia(final int numero, final char direccion, final char par) {
        int[] secuencia = calculador.getFibonacci(numero);

        secuencia = this.getSecuenciaConDireccion(secuencia, direccion);
        secuencia = this.getNumerosPares(secuencia, par);

        return secuencia;
    }

    private int[] getSecuenciaConDireccion(final int[] secuencia, final char direccion) {
        if (direccion == 'd') {
            return secuencia;
        } else {
            int[] nuevaSecuencia = new int[secuencia.length];
            int contador = 0;

            for (int i = secuencia.length - 1; i > 0; i--) {
                nuevaSecuencia[contador] = secuencia[i];
                contador++;
            }

            return nuevaSecuencia;
        }
    }

    private int[] getNumerosPares(final int[] secuencia, final char par) {
        if (par == 'p') {
            ArrayList<Integer> pares = new ArrayList<Integer>();

            for (int i = 0; i < secuencia.length; i++) {
                if (secuencia[i] % 2 == 0 && secuencia[i] != 0) {
                    pares.add(secuencia[i]);
                }
            }

            int[] nuevaSecuencia = pares.stream().mapToInt(i -> i).toArray();

            return nuevaSecuencia;
        } else {
            return secuencia;
        }

    }
}