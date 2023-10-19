package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.builders.EstacionBuilder;
import ar.edu.utn.frba.dds.builders.CentroideBuilder;
import ar.edu.utn.frba.dds.models.comunidades.Prestador;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.entidades.MedioDeTransporte;
import ar.edu.utn.frba.dds.models.entidades.Linea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ABMLineaTest {

    private final Prestador prestador = new Prestador();
    private final EstacionBuilder estacionBuilder = new EstacionBuilder(new CentroideBuilder());
    private final Exception e = new Exception();
    private final MedioDeTransporte subterraneo = new MedioDeTransporte("SUBTERRANEO");
    private final MedioDeTransporte ferrocarril = new MedioDeTransporte("FERROCARRIL");
/*    private final Estacion constitucion = estacionBuilder.buildEstacionSinServicios("Constitucion", -34.6277778F, -58.3813056F);
    private final Estacion ezeiza = estacionBuilder.buildEstacionSinServicios("Ezeiza", -34.8553F, -58.5258F);
    private final Estacion retiro = estacionBuilder.buildEstacionSinServicios("Retiro", -34.5877F, -58.3749F);
    private final Estacion avellaneda = estacionBuilder.buildEstacionSinServicios("Avellaneda", -34.6625F, -58.365F);*/
    private final Linea nuevaLineaDeTren = new Linea("Constitucion-Ezeiza", ferrocarril);

    @BeforeEach
    public void inicializar() throws Exception {
        Usuario usuario = new Usuario("caroLR@gmail.com", "Pa$$W0rd");
        usuario.setRol(prestador);

    }

    @Test
    @DisplayName("Un prestador quiere dar de alta un servicio publico: Linea de Tren")
    public void altaServicioPublico() throws Exception {

        prestador.altaEntidad(nuevaLineaDeTren);
        Assertions.assertTrue(prestador.getEntidades().contains(nuevaLineaDeTren));

    }

    @Test
    @DisplayName("Un prestador quiere dar de baja un servicio publico: Linea de Subte")
    public void bajaServicioPublico() throws Exception {

        Linea nuevaLineaDeSubte = new Linea("Subte C", subterraneo);
        prestador.altaEntidad(nuevaLineaDeSubte);
        prestador.bajaEntidad(nuevaLineaDeSubte);
        Assertions.assertFalse(prestador.getEntidades().contains(nuevaLineaDeSubte));

    }
/*
    @Test
    @DisplayName("Un prestador quiere agregar una estacion en un servicio publico")
    public void agregarEstacion() {

        nuevaLineaDeTren.agregarEstacion(avellaneda);
        Assertions.assertTrue(nuevaLineaDeTren.getEstaciones().contains(avellaneda));

    }

    @Test
    @DisplayName("Un prestador quiere eliminar una estacion en un servicio publico")
    public void eliminarEstacion() {

        nuevaLineaDeTren.eliminarEstacion(avellaneda);;
        Assertions.assertFalse(nuevaLineaDeTren.getEstaciones().contains(avellaneda));

    }*/

}




