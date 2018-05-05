package ar.edu.untref.aydoo;

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
            System.out.print("fibo<" + arg[0] + ">:");
            fibo.fibonachiHorizontalDirecto(Integer.parseInt(arg[0]));

        } else {

            String opcion = arg[0];
            int numero = Integer.parseInt(arg[1]);

            switch (opcion) {
                case "-o=hd":
                    System.out.print("fibo<" + numero + ">:");
                    fibo.fibonachiHorizontalDirecto(numero);
                    System.out.println();
                    break;

                case "-o=hi":
                    System.out.print("fibo<" + numero + ">:");
                    fibo.fibonachiHorizontalInverso(numero);
                    System.out.println();
                    break;

                case "-o=vd":
                    System.out.print("fibo<" + numero + ">:");
                    fibo.fibonachiVerticalDirecto(numero);
                    break;

                case "-o=vi":
                    System.out.print("fibo<" + numero + ">:");
                    fibo.fibonachiVerticalInverso(numero);
                    break;
                default:
                    System.out.println("Opciones no validas");
                    break;
            }
        }
    }

    static void validar(String[] args) {
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
