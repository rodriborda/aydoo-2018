package ar.edu.untref.aydoo;

public class Program {

    protected Program() {
    }

    public static final void main(final String[] arg) {

        String opcion = arg[0];
        Fibonachi fibo = new Fibonachi();

        if(arg.length == 1){
            System.out.print("fibo<" + Integer.parseInt(arg[0]) + ">: ");
            for (int i = 0; i < Integer.parseInt(arg[0]); i++) {
                System.out.print(fibo.calcularFibonachi(i) + " ");
            }
        } else {

            int numero = Integer.parseInt(arg[1]);

            switch (opcion) {
                case "-o=hd":
                    System.out.print("fibo<" + numero + ">: ");
                    for (int i = 0; i < numero; i++) {
                        System.out.print(fibo.calcularFibonachi(i) + " ");
                    }
                    break;

                case "-o=hi":
                    int[] resultado = new int[numero];
                    for (int i = 0; i <= numero - 1; i++) {
                        resultado[i] = fibo.calcularFibonachi(i);
                    }

                    System.out.print("fibo<" + numero + ">: ");

                    for (int i = numero - 1; i >= 0; i--) {
                        System.out.print(resultado[i] + " ");
                    }
                    break;

                case "-o=vd":
                    System.out.print("fibo<" + numero + ">: ");
                    for (int i = 0; i < numero; i++) {
                        System.out.println();
                        System.out.println(fibo.calcularFibonachi(i));
                    }
                    break;

                case "-o=vi":
                    int[] resultado1 = new int[numero];
                    for (int i = 0; i <= numero - 1; i++) {
                        resultado1[i] = fibo.calcularFibonachi(i);
                    }

                    System.out.print("fibo<" + numero + ">: ");

                    for (int i = numero - 1; i >= 0; i--) {
                        System.out.println();
                        System.out.println(resultado1[i]);
                    }
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        }

        System.out.println();

    }
}
