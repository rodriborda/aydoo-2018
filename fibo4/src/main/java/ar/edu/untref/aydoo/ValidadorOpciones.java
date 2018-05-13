package ar.edu.untref.aydoo;

public class ValidadorOpciones {

    private char orientacion;
    private char direccion;
    private char modo;
    private char par;
    private Integer numero;

    public ValidadorOpciones(final Opciones opciones) {
        this.orientacion = opciones.getOrientacion();
        this.direccion = opciones.getDireccion();
        this.modo = opciones.getModo();
        this.par = opciones.getPar();
        this.numero = opciones.getNumero();
    }

    public void verificarOpciones() throws OpcionesInvalidasException {
        if (((orientacion != 'h' && orientacion != 'v' && orientacion != 'p' && orientacion != '\0')
                || (direccion != 'd' && direccion != 'i' && direccion != '\0'))
                || (numero == null)
                || (modo != 's' && modo != 'l' && modo != '\0')
                || (par != 'p' && par != '\0')) {
            throw new OpcionesInvalidasException("Opciones no validas.");
        }
    }
}
