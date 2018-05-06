package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Partido {

    private List<Candidato> canditadosDelPartido;

    public Partido(){
        this.canditadosDelPartido = new ArrayList<Candidato>();
    }

    public int getVotosTotales() {
        int votosTotales = 0;

        for (Candidato candidato: this.canditadosDelPartido) {
            votosTotales += candidato.getCantidadVotos();
        }

        return votosTotales;
    }
}
