package ar.edu.utn.frba.dds.domain.servicios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioPublico {
  private String nombre;
  private Enum<MedioDeTransporte> medioDeTransporte;
  private Estacion estacionOrigen;
  private Estacion estacionDestino;
  private Estacion estaciones;

}
