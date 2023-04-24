package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.servicios.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import ar.edu.utn.frba.dds.domain.servicios.Ubicacion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Administrador extends RolesUsuario {

  public void altaServicio(Estacion estacion, Servicio servicio) {

    estacion.agregarServicio(servicio);
  }

  public void bajaServicio(Estacion estacion, Servicio servicio) {
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

  public void crearAdministrador(Usuario usuario){
    RolesUsuario administrador = new Administrador();
    usuario.setRol(administrador);
  }

  public void eliminarAdministrador(Usuario usuario){
    RolesUsuario lector = new Lector();
    usuario.setRol(lector);
  }

  public void agregarMiembro(Comunidad comunidad, Usuario usuario){
    comunidad.agregarMiembro(usuario);
  }

  public void agregarMiembroAdministrador(Comunidad comunidad, Usuario usuario){
    comunidad.agregarMiembroAdministrador(usuario);
  }

  public void eliminarMiembro(Comunidad comunidad, Usuario usuario){
    comunidad.eliminarMiembro(usuario);
  }

  public void eliminarMiembroAdministrador(Comunidad comunidad, Usuario usuario){
    comunidad.eliminarMiembroAdministrador(usuario);
  }


}
