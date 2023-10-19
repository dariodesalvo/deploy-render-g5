package ar.edu.utn.frba.dds.models.comunidades;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Comunidad")
public class Comunidad {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
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
}
