package ar.edu.utn.frba.dds.localizacion;

import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.entidades.Estacion;
import ar.edu.utn.frba.dds.models.georef.ServicioGeoref;
import ar.edu.utn.frba.dds.models.georef.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AsociarLocalizacionAEstablecimientoTest {
    private Establecimiento estacionChascomus = new Estacion();
    private Establecimiento pinamar = new Estacion();

    public void asociarLocalizacionAEstablecimiento(Establecimiento establecimiento) throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.getInstancia();
        ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosPorID(establecimiento.getUbicacion().id);

        //tomo el primero de la lista porque filtre por nombre
        Municipio municipio = municipios.municipios.get(0);

        System.out.println("Municipio: " + municipio.nombre + " Longitud: " + municipio.centroide.lon + " Latitud: " + municipio.centroide.lat);

        // establecimiento.getUbicacion().getCentroide().getMunicipio().setNombre(municipio.nombre);
        Centroide centroide = new Centroide();
        centroide.lat = municipio.centroide.lat;
        centroide.lon = municipio.centroide.lon;
        centroide.setMunicipio(municipio);
        establecimiento.getUbicacion().setCentroide(centroide);

        ListadoDeProvincias provincias = servicioGeoref.listadoDeProvincias();
        for(Provincia provincia: provincias.provincias){
            System.out.println(provincia.id +" "+ provincia.nombre);

        }
    }

    @BeforeEach
    public void inicializar() throws Exception {
        int idChascomus = 60218;
        Ubicacion ubicacionChascomus = new Ubicacion();
        ubicacionChascomus.setId(idChascomus);
        estacionChascomus.setUbicacion(ubicacionChascomus);

        //int idPinamar = 60644;
        //pinamar.getUbicacion_id().getCentroide().setMunicipio(new Municipio(idPinamar));


    }


    @Test
    @DisplayName("A la estacion con ID en Chascomus se le asocia su localizacion (latitud, longitud y su nombre) mediante Api")
    public void asociarLocalizacionAEstacionChascomus() throws IOException {
        this.asociarLocalizacionAEstablecimiento(estacionChascomus);

        Assertions.assertEquals("Chascomús", estacionChascomus.getUbicacion().getCentroide().getMunicipio().getNombre());
        Assertions.assertEquals(-35.61868667602539, estacionChascomus.getUbicacion().getCentroide().lat);
        Assertions.assertEquals(-57.90398025512695, estacionChascomus.getUbicacion().getCentroide().lon);
    }

   /* @Test
    @DisplayName("A la estacion con ID en Pinamar se le asocia su localizacion (latitud, longitud y su nombre) mediante Api")
    public void asociarLocalizacionAEstacionPinamar() throws IOException {
        this.asociarLocalizacionAEstablecimiento(pinamar);

        Assertions.assertEquals("Pinamar", pinamar.getLocalizacion().getNombre());
        Assertions.assertEquals(-37.109947204589844, pinamar.getLocalizacion().getCentroide().lat);
        Assertions.assertEquals(-56.86967468261719, pinamar.getLocalizacion().getCentroide().lon);
    }*/

}