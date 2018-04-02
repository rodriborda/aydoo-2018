package ar.edu.untref.aydoo;

public class Program {

    protected Program() {
    }

    public static final void main(final String[] arg) {

        Fibonachi fibo = new Fibonachi();

        System.out.print("fibo<" + arg[0] + ">: ");

        for(int i = 0; i < Integer.parseInt(arg[0]); i++){
            System.out.print(fibo.calcularFibonachi(i) + " ");
        }

        System.out.println();
    }
}
