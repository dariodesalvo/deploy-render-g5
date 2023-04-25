package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.builders.EstacionBuilder;
import ar.edu.utn.frba.dds.builders.UbicacionBuilder;
import ar.edu.utn.frba.dds.domain.servicios.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;

import org.junit.jupiter.api.*;

public class ABMServiciosTest {

    private Administrador administrador = new Administrador();

    private EstacionBuilder estacionBuilder = new EstacionBuilder(new UbicacionBuilder());

    private Exception e = new Exception();

    @BeforeEach
    public void inicializar() throws Exception {
        Usuario usuario = new Usuario("mauroDM@gmail.com","Pa$$W0rd");
        usuario.setRol(administrador);

    }

    @Test
    @DisplayName("Un administrador quiere dar de alta un servicio para una estacion")
    public void givenSeQuiereDarAltaNuevoServicioWhenAltaServicioThenOK() throws Exception {

        Estacion estacion = estacionBuilder.buildEstacionSinServicios("Primera Junta", 34.55490F, 22.55472F );
        Servicio nuevoServicio = new Servicio();
        administrador.altaServicio(estacion, nuevoServicio);
        Assertions.assertTrue(estacion.getServicios().contains(nuevoServicio));

    }

    @Test
    @DisplayName("Un administrador quiere dar de alta un servicio para una estacion")
    public void givenSeQuiereDarAltaServicioExistenteWhenAltaServicioThenERROR() {

        Assertions.assertThrows(e.getClass(), ()->{
            Estacion estacion = estacionBuilder.buildEstacionSinServicios("Primera Junta", 34.55490F, 22.55472F );
            Servicio nuevoServicio = new Servicio();
            administrador.altaServicio(estacion, nuevoServicio);
            administrador.altaServicio(estacion, nuevoServicio);
        });

    }

    @Test
    @DisplayName("Un administrador quiere dar de alta un servicio para una estacion")
    public void givenSeQuiereDarBajaServicioWhenBajaServicioThenOK() throws Exception {

        Estacion estacion = estacionBuilder.buildEstacionSinServicios("Primera Junta", 34.55490F, 22.55472F );
        Servicio nuevoServicio = new Servicio();
        administrador.altaServicio(estacion, nuevoServicio);
        administrador.bajaServicio(estacion, nuevoServicio);
        Assertions.assertFalse(estacion.getServicios().contains(nuevoServicio));

    }

    @Test
    @DisplayName("Un administrador quiere dar de alta un servicio para una estacion")
    public void givenSeQuiereDarBajaServicioInexistenteWhenBajaServicioThenERROR() {

        Assertions.assertThrows(e.getClass(), ()->{
            Estacion estacion = estacionBuilder.buildEstacionSinServicios("Primera Junta", 34.55490F, 22.55472F );
            Servicio nuevoServicio = new Servicio();
            administrador.bajaServicio(estacion, nuevoServicio);
        });

    }


}
