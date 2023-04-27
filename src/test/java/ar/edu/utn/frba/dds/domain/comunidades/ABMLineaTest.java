package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.builders.EstacionBuilder;
import ar.edu.utn.frba.dds.builders.UbicacionBuilder;
import ar.edu.utn.frba.dds.domain.servicios.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.MedioDeTransporte;
import ar.edu.utn.frba.dds.domain.servicios.Linea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ABMLineaTest {

    private final Prestador prestador = new Prestador();
    private final EstacionBuilder estacionBuilder = new EstacionBuilder(new UbicacionBuilder());
    private final Exception e = new Exception();
    private final Estacion constitucion = estacionBuilder.buildEstacionSinServicios("Constitucion", -34.6277778F, -58.3813056F);
    private final Estacion ezeiza = estacionBuilder.buildEstacionSinServicios("Ezeiza", -34.8553F, -58.5258F);
    private final Estacion retiro = estacionBuilder.buildEstacionSinServicios("Retiro", -34.5877F, -58.3749F);
    private final Estacion avellaneda = estacionBuilder.buildEstacionSinServicios("Avellaneda", -34.6625F, -58.365F);
    private final Linea nuevaLineaDeTren = new Linea("Constitucion-Ezeiza", MedioDeTransporte.FERROCARRIL, constitucion, ezeiza);

    @BeforeEach
    public void inicializar() throws Exception {
        Usuario usuario = new Usuario("caroLR@gmail.com", "Pa$$W0rd");
        usuario.setRol(prestador);

    }

    @Test
    @DisplayName("Un prestador quiere dar de alta un servicio publico: Linea de Tren")
    public void givenSeQuiereDarAltaNuevoServicioPublicoWhenAltaServicioThenOK() throws Exception {

        prestador.altaServicioPublico(nuevaLineaDeTren);
        Assertions.assertTrue(prestador.getServiciosPublicos().contains(nuevaLineaDeTren));

    }

    @Test
    @DisplayName("Un prestador quiere dar de baja un servicio publico: Linea de Subte")
    public void givenSeQuiereDarBajaServicioPublicoWhenBajaServicioThenOK() throws Exception {

        Linea nuevaLineaDeSubte = new Linea("Subte C", MedioDeTransporte.SUBTERRANEO, constitucion, retiro);
        prestador.altaServicioPublico(nuevaLineaDeSubte);
        prestador.bajaServicioPublico(nuevaLineaDeSubte);
        Assertions.assertFalse(prestador.getServiciosPublicos().contains(nuevaLineaDeSubte));

    }

    @Test
    @DisplayName("Un prestador quiere agregar una estacion en un servicio publico")
    public void givenSeQuiereAgregarEstacionaDeUnServicioPublicoWhenAgregarEstacionThenOk() {

        prestador.agregarEstacionServicioPublico(nuevaLineaDeTren, avellaneda);
        Assertions.assertTrue(nuevaLineaDeTren.getEstaciones().contains(avellaneda));

    }

    @Test
    @DisplayName("Un prestador quiere eliminar una estacion en un servicio publico")
    public void givenSeQuiereEliminarEstacionaDeServicioPublicoWhenEliminarEstacionThenOk() {

        prestador.eliminarEstacionServicioPublico(nuevaLineaDeTren, avellaneda);;
        Assertions.assertFalse(nuevaLineaDeTren.getEstaciones().contains(avellaneda));

    }

}




