package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Votaciones {

    private List<Candidato> candidatos;
    private List<Partido> partidos;


    public Votaciones(){
        this.candidatos = new ArrayList<Candidato>();
        this.partidos = new ArrayList<Partido>();
    }

    public Candidato calcularCandidatoGanadorPorProvincia(Provincia buenoAires) {
        Candidato candidatoGanadorEnProvincia = null;
        int votosDeCandidato = 0;

        for (Candidato candidato: this.candidatos) {
            int votos = candidato.getTotalVotosEnProvincia(buenoAires);
            if(votos > votosDeCandidato){
                candidatoGanadorEnProvincia = candidato;
                votosDeCandidato = votos;
            }
        }

        return candidatoGanadorEnProvincia;
    }

    public Partido calcularPartidoGanadorNacional(){
        Partido partidoConMasVotos = null;
        int votosTotales = 0;

        for (Partido partido: this.partidos) {
            int votos = partido.getVotosTotales();
            if(votos > votosTotales){
                partidoConMasVotos = partido;
                votosTotales = votos;
            }
            partido.getVotosTotales();
        }

        return partidoConMasVotos;
    }
}
