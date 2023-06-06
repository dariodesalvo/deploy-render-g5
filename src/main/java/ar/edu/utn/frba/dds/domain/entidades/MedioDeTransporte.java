package ar.edu.utn.frba.dds.domain.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedioDeTransporte {
  String tipo;

  public MedioDeTransporte(String tipo){
    this.tipo=tipo;
  }

}


