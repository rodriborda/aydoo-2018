package ar.edu.untref.aydoo;

public class Fibonachi {

    private int[] resultado;

    public int calcularFibonachi(int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            return calcularFibonachi(numero - 1) + calcularFibonachi(numero - 2);
        }
    }

    public void fibonachiHorizontalDirecto(int numero) {
        for (int i = 0; i < numero; i++) {
            System.out.print(" " + this.calcularFibonachi(i));
        }
    }

    public void fibonachiHorizontalInverso(int numero) {
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            System.out.print(" " + resultado[i]);
        }
    }

    public void fibonachiVerticalDirecto(int numero) {
        for (int i = 0; i < numero; i++) {
            System.out.println();
            System.out.println(this.calcularFibonachi(i));
        }
    }

    public void fibonachiVerticalInverso(int numero) {
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            System.out.println();
            System.out.println(resultado[i]);
        }
    }

    public void inversor(int numero) {
        this.resultado = new int[numero];
        for (int i = 0; i <= numero - 1; i++) {
            resultado[i] = this.calcularFibonachi(i);
        }
    }
}