package ar.edu.utn.frba.dds.domain.comunidades;

import javax.persistence.*;

@Entity
@Table(name = "RolesUsuario")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class RolesUsuario {

  @Id
  @GeneratedValue
  private Long id;
  public void desactivarAlertas() {
  }
}
