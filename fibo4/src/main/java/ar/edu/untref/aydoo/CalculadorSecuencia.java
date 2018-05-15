package ar.edu.untref.aydoo;

public class CalculadorSecuencia {

    private int getNumero(final int numero) {

        int a = 0, b = 1, c = 0;
        for (int i = 1; i < numero; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        if (numero <= 1) {
            return numero;
        } else {
            return c;
        }
    }

    public int[] getFibonacci(int numero) {
        int[] secuencia = new int[numero];

        for (int i = 0; i < numero; i++) {
            secuencia[i] = getNumero(i);
        }

        return  secuencia;
    }

}
