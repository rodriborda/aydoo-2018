package ar.edu.untref.aydoo;

public class Program {

    protected Program() {
    }

    public static final void main(final String[] arg) {

        Fibonachi fibo = new Fibonachi();

        switch (arg[0]){
            case "-o=hd":
                System.out.print("fibo<" + arg[1] + ">: ");
                for (int i = 0; i < Integer.parseInt(arg[1]); i++) {
                    System.out.print(fibo.calcularFibonachi(i) + " ");
                }
                break;
            case "-o=vd":
                System.out.print("fibo<" + arg[1] + ">: ");
                for (int i = 0; i < Integer.parseInt(arg[1]); i++) {
                    System.out.println();
                    System.out.println(fibo.calcularFibonachi(i));
                }
                break;
        }
        
        System.out.println();
    }
}
