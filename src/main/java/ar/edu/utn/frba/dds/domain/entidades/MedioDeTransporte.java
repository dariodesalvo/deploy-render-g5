package ar.edu.utn.frba.dds.domain.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MedioDeTransporte")
public class MedioDeTransporte {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "tipo")
  String tipo;
  public MedioDeTransporte(String tipo){
    this.tipo=tipo;
  }

}


