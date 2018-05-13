package ar.edu.untref.aydoo;

public class Opciones {

    private char orientacion;
    private char direccion;
    private char modo;
    private char par;
    private Integer numero;
    private String archivo;

    public Opciones(final String[] entrada) {
        this.orientacion = 'h';
        this.direccion = 'd';

        this.asignarOpciones(entrada);
    }

    private void asignarOpciones(final String[] entrada){
        for (int i = 0; i < entrada.length; i++) {
            if (esParseable(entrada[i])) {
                numero = Integer.parseInt(entrada[i]);
            } else if (entrada[i].contains("-o=")) {
                orientacion = entrada[i].charAt(3);
                direccion = entrada[i].charAt(4);
            } else if (entrada[i].contains("-f=")) {
                archivo = entrada[i].substring(3);
            } else if (entrada[i].contains("-m=")) {
                modo = entrada[i].charAt(3);
            } else if (entrada[i].contains("-n=")) {
                par = entrada[i].charAt(3);
            }
        }
    }

    public char getOrientacion() {
        return orientacion;
    }

    public char getDireccion() {
        return direccion;
    }

    public char getPar() {
        return par;
    }

    public Integer getNumero() {
        return numero;
    }

    public boolean opcionesValidas() {
        boolean opcionValida = true;

        if (((orientacion != 'h' && orientacion != 'v' && orientacion != 'p' && orientacion != '\0')
                || (direccion != 'd' && direccion != 'i' && direccion != '\0'))
                || (numero == null)
                || (modo != 's' && modo != 'l' && modo != '\0')
                || (par != 'p' && par != '\0')){
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

    private boolean esParseable(final String input) {
        boolean parsable = true;
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            parsable = false;
        }
        return parsable;
    }
}
