package ar.edu.utn.frba.dds.domain.comunidades;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comunidad {
  private String nombre;
  private List<Usuario> miembros;
  private List<Usuario> administradores;

  public Comunidad(String nombre){
    this.nombre = nombre ;
    this.miembros = new ArrayList<>();
    this.administradores = new ArrayList<>();
  }


  public void agregarMiembro(Usuario usuario) {
    this.miembros.add(usuario);
  }

  public void agregarMiembroAdministrador(Usuario usuario) {
    this.administradores.add(usuario);
  }

  public void eliminarMiembro(Usuario usuario) {
    this.miembros.remove(usuario);
  }

  public void eliminarMiembroAdministrador(Usuario usuario) {
    this.administradores.remove(usuario);
  }

  public boolean esAdministrador(Usuario usuario) {
    return this.administradores.contains(usuario);
  }

  public boolean esUsuario(Usuario usuario) {
    return this.miembros.contains(usuario);
  }

  public void sacarAdministradorA(Usuario usuario){

    if (this.esAdministrador(usuario)){
      this.eliminarMiembroAdministrador(usuario);
      this.agregarMiembro(usuario);
    }
    else {
      //TODO Exception el usuario no es admin
    }
  }

  public void darAdministradorA(Usuario usuario){

    if (this.esUsuario(usuario)){
      this.eliminarMiembro(usuario);
      this.agregarMiembroAdministrador(usuario);
    }
    else {
      this.agregarMiembroAdministrador(usuario);
      //TODO deberia agregarlo como admin o lanzar Exception el usuario no es miembro?
    }
  }
}
