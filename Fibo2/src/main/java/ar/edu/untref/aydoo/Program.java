package ar.edu.untref.aydoo;

public class Program {

    protected Program() {
    }

    public static final void main(final String[] arg) {

        Fibonachi fibo = new Fibonachi();

        if (arg.length == 1) {
            System.out.print("fibo<" + arg[0] + ">: ");
            fibo.fibonachiHorizontalDirecto(Integer.parseInt(arg[0]));

        } else {

            String opcion = arg[0];
            int numero = Integer.parseInt(arg[1]);

            switch (opcion) {
                case "-o=hd":
                    System.out.print("fibo<" + numero + ">: ");
                    fibo.fibonachiHorizontalDirecto(numero);
                    break;

                case "-o=hi":
                    System.out.print("fibo<" + numero + ">: ");
                    fibo.fibonachiHorizontalInverso(numero);
                    break;

                case "-o=vd":
                    System.out.print("fibo<" + numero + ">: ");
                    fibo.fibonachiVerticalDirecto(numero);
                    break;

                case "-o=vi":
                    System.out.print("fibo<" + numero + ">: ");
                    fibo.fibonachiVerticalInverso(numero);
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        }

        System.out.println();

    }
}
