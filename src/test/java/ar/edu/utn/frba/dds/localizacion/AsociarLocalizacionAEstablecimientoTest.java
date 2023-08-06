/*
package ar.edu.utn.frba.dds.localizacion;

import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.entidades.Estacion;
import ar.edu.utn.frba.dds.domain.georef.ServicioGeoref;
import ar.edu.utn.frba.dds.domain.georef.entities.Centroide;
import ar.edu.utn.frba.dds.domain.georef.entities.ListadoDeMunicipios;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AsociarLocalizacionAEstablecimientoTest {
    private Establecimiento chascomus = new Estacion();
    private Establecimiento pinamar = new Estacion();

    public void asociarLocalizacionAEstablecimiento(Establecimiento establecimiento) throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.getInstancia();
        ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosPorID(establecimiento.getLocalizacion().id);

        //tomo el primero de la lista porque filtre por nombre
        Municipio municipio = municipios.municipios.get(0);

        System.out.println("Municipio: " + municipio.nombre + " Longitud: " + municipio.centroide.lon + " Latitud: " + municipio.centroide.lat);

        establecimiento.getLocalizacion().setNombre(municipio.nombre);
        Centroide centroide = new Centroide();
        centroide.lat = municipio.centroide.lat;
        centroide.lon = municipio.centroide.lon;
        establecimiento.getLocalizacion().setCentroide(centroide);

    }

    @BeforeEach
    public void inicializar() throws Exception {
        int idChascomus = 60218;
        chascomus.setLocalizacion(new Municipio(idChascomus));

        int idPinamar = 60644;
        pinamar.setLocalizacion(new Municipio(idPinamar));


    }


    @Test
    @DisplayName("A la estacion con ID en Chascomus se le asocia su localizacion (latitud, longitud y su nombre) mediante Api")
    public void asociarLocalizacionAEstacionChascomus() throws IOException {
        this.asociarLocalizacionAEstablecimiento(chascomus);

        Assertions.assertEquals("Chascomús", chascomus.getLocalizacion().getNombre());
        Assertions.assertEquals(-35.618770599365234, chascomus.getLocalizacion().getCentroide().lat);
        Assertions.assertEquals(-57.904319763183594, chascomus.getLocalizacion().getCentroide().lon);
    }

    @Test
    @DisplayName("A la estacion con ID en Pinamar se le asocia su localizacion (latitud, longitud y su nombre) mediante Api")
    public void asociarLocalizacionAEstacionPinamar() throws IOException {
        this.asociarLocalizacionAEstablecimiento(pinamar);

        Assertions.assertEquals("Pinamar", pinamar.getLocalizacion().getNombre());
        Assertions.assertEquals(-37.109947204589844, pinamar.getLocalizacion().getCentroide().lat);
        Assertions.assertEquals(-56.86967468261719, pinamar.getLocalizacion().getCentroide().lon);
    }

}
*/
