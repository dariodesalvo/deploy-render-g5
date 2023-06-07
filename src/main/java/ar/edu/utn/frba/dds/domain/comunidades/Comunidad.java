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

  public void eliminarMiembro(Usuario usuario) {
    this.miembros.remove(usuario);
  }

  public void sacarAdministrador(Usuario usuario){
      administradores.remove(usuario);
    }

  public void darAdministradorA(Usuario usuario) {
    administradores.add(usuario);
  }
}
