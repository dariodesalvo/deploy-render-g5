package ar.edu.utn.frba.dds.builders;

import ar.edu.utn.frba.dds.domain.entidades.Estacion;
import ar.edu.utn.frba.dds.domain.helpers.Municipio;

import java.util.ArrayList;


public class EstacionBuilder {
    UbicacionBuilder ubicacionBuilder;

    public EstacionBuilder(UbicacionBuilder ubicacionBuilder){
        this.ubicacionBuilder = ubicacionBuilder;
    }

    public Estacion buildEstacionSinServicios(String nombre, Float latitud, Float longitud){
        Estacion nuevaEstacion = new Estacion();
        nuevaEstacion.setLeyenda(nombre);
        nuevaEstacion.setLocalizacion(new Municipio("flores",ubicacionBuilder.buildUbicacion(latitud, longitud)));
        nuevaEstacion.setServicios(new ArrayList<>());
        return nuevaEstacion;
    }
}
