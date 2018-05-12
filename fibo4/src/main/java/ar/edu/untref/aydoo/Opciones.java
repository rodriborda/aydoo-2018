package ar.edu.untref.aydoo;

public class Opciones {

    private char orientacion;
    private char direccion;
    private char modo;
    private Integer numero;
    private String archivo;

    public Opciones(String[] entrada) {
        for(int i = 0; i < entrada.length; i++) {
            if(esParseable(entrada[i])) {
                numero = Integer.parseInt(entrada[i]);
            } else if(entrada[i].contains("-o=")) {
                orientacion = entrada[i].charAt(3);
                direccion = entrada[i].charAt(4);
            } else if (entrada[i].contains("-f=")) {
                archivo = entrada[i].substring(3);
            } else if (entrada[i].contains("-m=")) {
                modo = entrada[i].charAt(3);
            }
        }
    }

    public char getOrientacion() {
        return orientacion;
    }

    public char getDireccion() {
        return direccion;
    }

    public String getArchivo() {
        return archivo;
    }

    public Integer getNumero() {
        return numero;
    }

    public boolean opcionesValidas() {
        boolean opcionValida = true;

        if (((orientacion != 'h' && orientacion != 'v')
                || (direccion != 'd' && direccion != 'i'))
                || (numero == null)) {
            opcionValida = false;
        }
        return opcionValida;
    }

    public char getModo() {
        return modo;
    }

    public String getNombreArchivo() {
        return archivo;
    }

    private boolean esParseable(String input){
        boolean parsable = true;
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            parsable = false;
        }
        return parsable;
    }
}
