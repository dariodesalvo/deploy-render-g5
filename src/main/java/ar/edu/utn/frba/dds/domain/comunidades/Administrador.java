package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.servicios.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import ar.edu.utn.frba.dds.domain.servicios.Ubicacion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Administrador extends Usuario {

    public void altaServicio(Estacion estacion){
        List<Servicio> servicios = estacion.getServicios();
        servicios.add(new Servicio());
        estacion.setServicios(servicios);
    }
    public void bajaServicio(Estacion estacion, Servicio servicio){
        List<Servicio> servicios = estacion.getServicios();
        servicios.remove(servicio);
        estacion.setServicios(servicios);
    }
    public void editarUbicacionServicio(Servicio servicio, Ubicacion ubicacion){
        servicio.setUbicacion(ubicacion);
    }
    public void editarNombreServicio(Servicio servicio, String nuevoNombre){
        servicio.setNombre(nuevoNombre);
    }
    public void editarTramosServicio(Servicio servicio, List<Ubicacion> nuevosTramos){
        servicio.setTramos(nuevosTramos);
    }
    public void editarElevacionServicio(Servicio servicio, Boolean nuevosEsDeElevacion){
        servicio.setEsDeElevacion(nuevosEsDeElevacion);
    }

}
