package ar.edu.utn.frba.dds.builders;

import ar.edu.utn.frba.dds.domain.entidades.Estacion;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;

import java.util.ArrayList;


public class EstacionBuilder {
    CentroideBuilder centroideBuilder;

    public EstacionBuilder(CentroideBuilder centroideBuilder){
        this.centroideBuilder = centroideBuilder;
    }

   /* public Estacion buildEstacionSinServicios(String nombre, Float latitud, Float longitud){
        Estacion nuevaEstacion = new Estacion();
        nuevaEstacion.setLeyenda(nombre);
        nuevaEstacion.setLocalizacion(new Municipio(60455,"Las Flores", centroideBuilder.buildCentroide(latitud, longitud)));
        nuevaEstacion.setServicios(new ArrayList<>());
        return nuevaEstacion;
    }*/
}
