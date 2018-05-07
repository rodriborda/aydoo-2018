package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Candidato {

    private List<Voto> votos;

    public Candidato(){
        this.votos = new ArrayList<Voto>();
    }

    public int getTotalVotosEnProvincia(Provincia buenoAires) {
        int votosPorProvincia = 0;

        for (Voto voto: this.votos) {
            if(voto.getProvincia() == buenoAires){
                votosPorProvincia++;
            }
        }

        return votosPorProvincia;
    }

    public int getCantidadVotos() {

        return this.votos.size();

    }
}
