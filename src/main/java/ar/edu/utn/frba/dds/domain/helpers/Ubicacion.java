package ar.edu.utn.frba.dds.domain.helpers;

import ar.edu.utn.frba.dds.domain.georef.ServicioGeoref;
import ar.edu.utn.frba.dds.domain.georef.entities.ListadoDeMunicipios;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class Ubicacion {
    private float latitud;
    private float longitud;


    public void asociarLocalizacionSegunMunicipio(String nombreMunicipio) throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.getInstancia();
        ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosPorNombre(nombreMunicipio);

        //tomo el primero de la lista porque filtre por nombre
        Municipio municipio = municipios.municipios.get(0);

        System.out.println("Municipio: " + municipio.nombre + " Longitud: " + municipio.centroide.lon + " Latitud: " + municipio.centroide.lat);

        this.setLongitud(municipio.centroide.lon);
        this.setLatitud(municipio.centroide.lat);
    }
}

