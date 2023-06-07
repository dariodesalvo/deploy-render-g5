package ar.edu.utn.frba.dds.domain.georef.entities;

public class Municipio {
    public int id;
    public String nombre;
    public Centroide centroide;

    public Municipio() {
    }

    public Municipio(int id, String nombre, Centroide centroide) {
        this.id = id;
        this.nombre = nombre;
        this.centroide = centroide;
    }
}
