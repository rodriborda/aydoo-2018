package ar.edu.untref.aydoo;

public class Fecha {

    private Integer mes;
    private Integer anio;

    public Fecha(Integer mes, Integer anio) {
        if(mes < 1 || mes > 12){
            throw new IllegalArgumentException("El mes ingresado no es valido");
        } else if(anio < 1){
            throw new IllegalArgumentException("El anio ingresado no es valido");
        }
        this.mes = mes;
        this.anio = anio;
    }

    public Integer getMes() {
        return this.mes;
    }

    public Integer getAnio() {
        return this.anio;
    }
}
