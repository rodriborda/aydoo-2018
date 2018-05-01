package ar.edu.untref.aydoo;

public class Fibonachi {

    private int[] resultado;
    private String fibonacci;

    public int calcularFibonachi(int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            return calcularFibonachi(numero - 1) + calcularFibonachi(numero - 2);
        }
    }

    public String fibonachiHorizontalDirecto(int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            this.fibonacci += " " + this.calcularFibonachi(i);
        }
        return this.fibonacci;
    }

    public String fibonachiHorizontalInverso(int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            this.fibonacci += " " + resultado[i];
        }

        return this.fibonacci;
    }

    public String fibonachiVerticalDirecto(int numero) {
        this.fibonacci = "fibo<" + numero + ">:";

        for (int i = 0; i < numero; i++) {
            this.fibonacci += "\n" + this.calcularFibonachi(i);
        }

        return this.fibonacci;
    }

    public String fibonachiVerticalInverso(int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            this.fibonacci += "\n" + resultado[i];
        }

        return this.fibonacci;
    }

    public void inversor(int numero) {
        this.resultado = new int[numero];
        for (int i = 0; i <= numero - 1; i++) {
            resultado[i] = this.calcularFibonachi(i);
        }
    }

    public String calcularSumaFibonachi(int numero) {
        this.fibonacci = "fibo<" + numero + ">:s";

        int total = 0;
        for (int i = 0; i < numero; i++) {
            total += this.calcularFibonachi(numero);
        }

        return this.fibonacci + " " + total;

    }
}