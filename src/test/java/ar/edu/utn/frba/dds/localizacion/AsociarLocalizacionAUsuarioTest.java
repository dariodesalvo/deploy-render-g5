package ar.edu.utn.frba.dds.localizacion;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import ar.edu.utn.frba.dds.domain.georef.ServicioGeoref;
import ar.edu.utn.frba.dds.domain.georef.entities.Centroide;
import ar.edu.utn.frba.dds.domain.georef.entities.ListadoDeMunicipios;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AsociarLocalizacionAUsuarioTest {
    private Usuario caro;
    private Usuario mica;

    public void asociarLocalizacionAUsuario(Usuario usuario) throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.getInstancia();
        ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosPorID(usuario.getLocalizacion().id);

        //tomo el primero de la lista porque filtre por nombre
        Municipio municipio = municipios.municipios.get(0);

        System.out.println("Municipio: " + municipio.nombre + " Longitud: " + municipio.centroide.lon + " Latitud: " + municipio.centroide.lat);

        usuario.getLocalizacion().setNombre(municipio.nombre);
        Centroide centroide = new Centroide();
        centroide.lat = municipio.centroide.lat;
        centroide.lon = municipio.centroide.lon;
        usuario.getLocalizacion().setCentroide(centroide);

    }

    @BeforeEach
    public void inicializar() throws Exception {
        caro = new Usuario("caroLR@gmail.com", "Pa$$W0rd");
        int idLanus = 60434;
        caro.setLocalizacion(new Municipio(idLanus));

        mica = new Usuario("micaO@gmail.com", "Pa$$W0rd");
        int idLomasDeZamora = 60490;
        mica.setLocalizacion(new Municipio(idLomasDeZamora));

    }


    @Test
    @DisplayName("A un Usuario con Municipio ID en Lanus se le asocia su localizacion (latitud, longitud y su nombre) mediante Api")
    public void asociarLocalizacionLanusAUsuario() throws IOException {
        this.asociarLocalizacionAUsuario(caro);

        Assertions.assertEquals("Lanús", caro.getLocalizacion().getNombre());
        Assertions.assertEquals(-34.70578384399414, caro.getLocalizacion().getCentroide().lat);
        Assertions.assertEquals(-58.39544677734375, caro.getLocalizacion().getCentroide().lon);


    }

    @Test
    @DisplayName("A un Usuario con Municipio ID en Lomas de Zamora se le asocia su localizacion (latitud, longitud y su nombre) mediante Api")
    public void asociarLocalizacionLomasAUsuario() throws IOException {

        this.asociarLocalizacionAUsuario(mica);

        Assertions.assertEquals("Lomas de Zamora", mica.getLocalizacion().getNombre());
        Assertions.assertEquals(-34.755462646484375, mica.getLocalizacion().getCentroide().lat);
        Assertions.assertEquals(-58.4240837097168, mica.getLocalizacion().getCentroide().lon);

    }
}
