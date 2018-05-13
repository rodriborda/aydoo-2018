package ar.edu.untref.aydoo;

public class CalculadorResultado {

    private CalculadorSecuencia calculador;
    private String textoDelResultado;

    public CalculadorResultado(){
        this.calculador = new CalculadorSecuencia();
        this.textoDelResultado = "";
    }

    public String getResultado(final char orientacion, final char modo,final int numero, final char direccion, final char par){
        if (orientacion == 'h') {
            this.horizontal(numero, direccion);
        } else if (orientacion == 'v') {
            this.vertical(numero, direccion);
        } else if (orientacion == 'p') {
            this.piramide(numero, direccion);
        }

        if (modo == 's') {
            this.calcularSumatoria(numero, orientacion);
        }

        if (par == 'p') {
            this.soloNumerosPares(numero, direccion, orientacion);
        }

        return this.textoDelResultado;
    }

    private int[] getSecuencia(final int numero, final char direccion){
        int[] secuencia = calculador.getFibonacci(numero);

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

    private void horizontal(final int fibo, final char direccion){
        int[] secuencia = getSecuencia(fibo, direccion);

        for (int i = 0; i < secuencia.length; i++) {
            this.textoDelResultado = this.textoDelResultado + " " + secuencia[i];
        }
    }

    private void vertical(final int fibo, final char direccion){
        int[] secuencia = getSecuencia(fibo, direccion);

        for (int i = 0; i < secuencia.length; i++) {
            this.textoDelResultado = this.textoDelResultado + "\n" + secuencia[i];
        }
    }

    private void calcularSumatoria(final int fibo, final char orientacion) {
        int[] secuencia = calculador.getFibonacci(fibo);
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

    private void soloNumerosPares(final int fibo, final char direccion, final char orientacion) {
        int[] secuencia = getSecuencia(fibo, direccion);
        this.textoDelResultado = "";

        for (int i = 0; i < secuencia.length; i++) {
            if (secuencia[i] % 2 == 0) {
                if (orientacion == 'h') {
                    this.textoDelResultado = this.textoDelResultado + " " + secuencia[i];
                } else {
                    this.textoDelResultado = this.textoDelResultado + "\n" + secuencia[i];
                }
            }
        }
    }

    private void piramide(final int fibo, final char direccion) {
        int[] secuencia = getSecuencia(fibo, direccion);

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
}