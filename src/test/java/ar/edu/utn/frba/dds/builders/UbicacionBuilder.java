package ar.edu.utn.frba.dds.builders;

import ar.edu.utn.frba.dds.domain.helpers.Ubicacion;

public class UbicacionBuilder {

    public Ubicacion buildUbicacion(float latitud, float longitud){
        Ubicacion nuevaUbicacion = new Ubicacion();
        nuevaUbicacion.setLatitud(latitud);
        nuevaUbicacion.setLongitud(longitud);
        return nuevaUbicacion;
    }
}
