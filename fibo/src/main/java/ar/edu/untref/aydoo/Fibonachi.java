package ar.edu.untref.aydoo;

public class Fibonachi {

    public int calcularFibonachi(int n){
        if(n <= 1){
            return n;
        }else{
            return calcularFibonachi(n-1) + calcularFibonachi(n-2);
        }
    }

}