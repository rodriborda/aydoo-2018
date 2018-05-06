package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Votaciones {

    private List<Candidato> candidatos;

    public Votaciones(){
        this.candidatos = new ArrayList<Candidato>();
    }

    public Candidato calcularCandidatoGanadorPorProvincia(Provincia buenoAires) {
        Candidato candidatoConMasVotos = null;
        int votosDeCandidato = 0;

        for (Candidato candidato: this.candidatos) {
            int votos = candidato.getTotalVotosEnProvincia(buenoAires);
            if(votos > votosDeCandidato){
                candidatoConMasVotos = candidato;
                votosDeCandidato = votos;
            }
        }

        return candidatoConMasVotos;
    }
}
