package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.servicios.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.MedioDeTransporte;
import ar.edu.utn.frba.dds.domain.servicios.ServicioPublico;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Prestador extends RolesUsuario {

    private List<ServicioPublico> serviciosPublicos = new ArrayList<>();

    public void altaServicioPublico(ServicioPublico servicioPublico) {
        serviciosPublicos.add(servicioPublico);
    }

    public void bajaServicioPublico(ServicioPublico servicioPublico) {
        serviciosPublicos.remove(servicioPublico);
    }

    public void editarNombreServicioPublico(ServicioPublico servicioPublico, String nombre) {
        servicioPublico.setNombre(nombre);
    }

    public void editarMedioDeTransporteServicioPublico(ServicioPublico servicioPublico, MedioDeTransporte medio) {
        servicioPublico.setMedioDeTransporte(medio);
    }

    public void editarEstacionOrigenServicioPublico(ServicioPublico servicioPublico, Estacion estacion) {
        servicioPublico.setEstacionOrigen(estacion);
    }

    public void editarEstacionDestinoServicioPublico(ServicioPublico servicioPublico, Estacion estacion) {
        servicioPublico.setEstacionDestino(estacion);
    }

    public void agregarEstacionServicioPublico(ServicioPublico servicioPublico, Estacion estacion) {
        servicioPublico.agregarEstacion(estacion);
    }

    public void eliminarEstacionServicioPublico(ServicioPublico servicioPublico, Estacion estacion) {
        servicioPublico.eliminarEstacion(estacion);
    }

}
