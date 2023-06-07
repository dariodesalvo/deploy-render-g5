package ar.edu.utn.frba.dds.localizacion;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AsociacionAUsuarioTest {
    private Usuario caro;
    private Usuario mica;


    @BeforeEach
    public void inicializar() throws Exception {
        caro = new Usuario("caroLR@gmail.com", "Pa$$W0rd");
        caro.setMunicipio("lomas de zamora");

        mica = new Usuario("micaO@gmail.com", "Pa$$W0rd");
        mica.setMunicipio("lanus");

    }

    @Test
    @DisplayName("A un Usuario con Municipio en Lomas de Zamora se le asocioa su ubicacion (latitud y longitud) mediante Api")
    public void asociarLocaliacionLDZAUsuario() throws IOException {

        caro.getUbicacion().asociarLocalizacionSegunMunicipio(caro.getMunicipio());

            Assertions.assertEquals(-34.755462646484375, caro.getUbicacion().getLatitud());
            Assertions.assertEquals(-58.4240837097168, caro.getUbicacion().getLongitud());
    }

    @Test
    @DisplayName("A un Usuario con Municipio en Lanus se le asocioa su ubicacion (latitud y longitud) mediante Api")
    public void asociarLocaliacionLanusAUsuario() throws IOException {

        mica.getUbicacion().asociarLocalizacionSegunMunicipio(mica.getMunicipio());

        Assertions.assertEquals(-34.70578384399414, mica.getUbicacion().getLatitud());
        Assertions.assertEquals(-58.39544677734375, mica.getUbicacion().getLongitud());
    }
}
