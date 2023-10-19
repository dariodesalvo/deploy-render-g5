package ar.edu.utn.frba.dds.builders;

import ar.edu.utn.frba.dds.models.georef.entities.Centroide;

public class CentroideBuilder {

    public Centroide buildCentroide(float latitud, float longitud){
        Centroide nuevoCentroide = new Centroide();
        nuevoCentroide.setLat(latitud);
        nuevoCentroide.setLon(longitud);
        return nuevoCentroide;
    }
}
