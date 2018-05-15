package ar.edu.untref.aydoo;

import org.junit.Test;

public class ValidadorOpcionesTest {

    @Test
    public void pasarTotasLasOpcionesCorrectamenteLasValida() throws OpcionesInvalidasException {
        String[] arg = new String[5];
        arg[0] = "5";
        arg[1] = "-o=hd";
        arg[2] = "-m=s";
        arg[3] = "-n=p";
        arg[4] = "-f=ejemplo.txt";

        Opciones opciones = new Opciones(arg);
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        validador.verificarOpciones();
    }

    @Test (expected = OpcionesInvalidasException.class)
    public void pasarSoloUnaOpcionYQueNoSeaUnNumeroDevuelveExcepcion() throws OpcionesInvalidasException {
        String[] arg = new String[1];
        arg[0] = "n";
        Opciones opciones = new Opciones(arg);
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        validador.verificarOpciones();
    }

    @Test (expected = OpcionesInvalidasException.class)
    public void pasarOpcionesSinNumeroDevuelveExcepcion() throws OpcionesInvalidasException {
        String[] arg = new String[2];
        arg[0] = "-n=p";
        arg[1] = "-o=hd";
        Opciones opciones = new Opciones(arg);
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        validador.verificarOpciones();
    }

    @Test (expected = OpcionesInvalidasException.class)
    public void pasarOrientacionYDireccionInvalidasDevuelveExcepcion() throws OpcionesInvalidasException {
        String[] arg = new String[2];
        arg[0] = "5";
        arg[1] = "-o=yt";
        Opciones opciones = new Opciones(arg);
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        validador.verificarOpciones();
    }

    @Test (expected = OpcionesInvalidasException.class)
    public void pasarModoInvalidoDevuelveExcepcion() throws OpcionesInvalidasException {
        String[] arg = new String[2];
        arg[0] = "5";
        arg[1] = "-m=o";
        Opciones opciones = new Opciones(arg);
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        validador.verificarOpciones();
    }

    @Test (expected = OpcionesInvalidasException.class)
    public void pasarOpcionPiramideInvalidaDevuelveExcepcion() throws OpcionesInvalidasException {
        String[] arg = new String[2];
        arg[0] = "5";
        arg[1] = "-o=ph";
        Opciones opciones = new Opciones(arg);
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        validador.verificarOpciones();
    }

    @Test (expected = OpcionesInvalidasException.class)
    public void pasarOpcionParInvalidaDevuelveExcepcion() throws OpcionesInvalidasException {
        String[] arg = new String[2];
        arg[0] = "5";
        arg[1] = "-n=i";
        Opciones opciones = new Opciones(arg);
        ValidadorOpciones validador = new ValidadorOpciones(opciones);

        validador.verificarOpciones();
    }

}
