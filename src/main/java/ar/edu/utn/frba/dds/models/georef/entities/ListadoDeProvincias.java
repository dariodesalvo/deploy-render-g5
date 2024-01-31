package ar.edu.utn.frba.dds.models.georef.entities;

import java.util.List;

public class ListadoDeProvincias {
    public int cantidad;
    public int inicio;
    public int total;
    public List<Provincia> provincias;
    public Parametro parametro;

    private class Parametro {
        public List<String> campos;
        public int max;
    }
}
