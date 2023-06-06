package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.entidades.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import ar.edu.utn.frba.dds.domain.helpers.Ubicacion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Administrador extends RolesUsuario {

  public void altaServicio(Estacion estacion, Servicio servicio) throws Exception {

    estacion.agregarServicio(servicio);
  }

  public void bajaServicio(Estacion estacion, Servicio servicio) throws Exception {
    estacion.eliminarServicio(servicio);
  }

  public void editarUbicacionServicio(Servicio servicio, Ubicacion ubicacion) {
    servicio.setUbicacion(ubicacion);
  }

  public void editarNombreServicio(Servicio servicio, String nuevoNombre) {
    servicio.setNombre(nuevoNombre);
  }

  public void editarTramosServicio(Servicio servicio, List<Ubicacion> nuevosTramos) {
    servicio.setTramos(nuevosTramos);
  }

  public void editarElevacionServicio(Servicio servicio, Boolean nuevosEsDeElevacion) {
    servicio.setEsDeElevacion(nuevosEsDeElevacion);
  }


}
