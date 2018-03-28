package ar.edu.untref.aydoo;

public class Fibonachi {

    public static void main(int n){
        int x=0, y=1, aux;

        System.out.println(x);
        System.out.println(y);

        for(int i=0; i < n; i++) {
            aux = x;
            x = y;
            y = aux + x;

            System.out.println(y);
        }
    }

}