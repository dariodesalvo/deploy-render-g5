package ar.edu.utn.frba.dds.models.comunidades;

import javax.persistence.*;

@Entity
@Table(name = "RolesUsuario")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class RolesUsuario {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  public void desactivarAlertas() {
  }
}
