package ar.edu.utn.frba.dds.models.comunidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.utn.frba.dds.models.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Comunidad")
public class Comunidad extends Persistente {

  @Column(name = "nombre")
  private String nombre;
  @ManyToMany
  @JoinTable(
          name = "comunidad_miembros",
          joinColumns = @JoinColumn(name = "comunidad_id"),
          inverseJoinColumns = @JoinColumn(name = "miembro_id")
  )
  private List<Miembro> miembros;
  @ManyToMany
  @JoinTable(
          name = "comunidad_administradores",
          joinColumns = @JoinColumn(name = "comunidad_id"),
          inverseJoinColumns = @JoinColumn(name = "miembro_id")
  )
  private List<Usuario> administradores;

  @ElementCollection
  @CollectionTable(name = "solicitud_comunidad", joinColumns = @JoinColumn(name = "comunidad_id"))
  @Column(name = "usuario_id")
  private Set<Long> solicitudes;

  @Column(name = "confiabilidad")
  private Double confiabilidad;

  public Comunidad(){

  }

  public Comunidad(String nombre){
    this.nombre = nombre ;
    this.miembros = new ArrayList<>();
    this.administradores = new ArrayList<>();
  }

  public void agregarMiembro(Miembro miembro) {
    this.miembros.add(miembro);
    miembro.sosParte(this);
  }

  public void eliminarMiembro(Miembro miembro) {
    this.miembros.remove(miembro);
  }

  public void sacarAdministrador(Usuario usuario){
      administradores.remove(usuario);
    }

  public void darAdministradorA(Usuario usuario) {
    administradores.add(usuario);
  }

  public int cantMiembros() {
    return this.miembros.size();
  }

  public void agregarSolicitud(Long id){
    this.solicitudes.add(id);
  }

}

