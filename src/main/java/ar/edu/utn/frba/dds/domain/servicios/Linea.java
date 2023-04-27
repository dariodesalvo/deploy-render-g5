package ar.edu.utn.frba.dds.domain.servicios;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Linea {
  private String nombre;
  private MedioDeTransporte medioDeTransporte;
  private Estacion estacionOrigen;
  private Estacion estacionDestino;
  private List<Estacion> estaciones;

  public Linea(String nombre, MedioDeTransporte medioDeTransporte, Estacion estacionOrigen, Estacion estacionDestino) {
    this.nombre = nombre;
    this.medioDeTransporte = medioDeTransporte;
    this.estacionOrigen = estacionOrigen;
    this.estacionDestino = estacionDestino;
    this.estaciones = new ArrayList<>();
  }

  public void agregarEstacion(Estacion estacion){
    estaciones.add(estacion);
  }

  public void eliminarEstacion(Estacion estacion){
    estaciones.remove(estacion);
  }

}
