package ar.edu.utn.frba.dds.domain.servicios;

import ar.edu.utn.frba.dds.domain.comunidades.Interes;
import lombok.Getter;
import lombok.Setter;
import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class ServicioPublico {
  private String nombre;
  private MedioDeTransporte medioDeTransporte;
  private Estacion estacionOrigen;
  private Estacion estacionDestino;
  private List<Estacion> estaciones;

  public ServicioPublico(String nombre, MedioDeTransporte medioDeTransporte, Estacion estacionOrigen, Estacion estacionDestino) {
    this.nombre = nombre;
    this.medioDeTransporte = medioDeTransporte;
    this.estacionOrigen = estacionOrigen;
    this.estacionDestino = estacionDestino;
  }

  public void agregarEstacion(Estacion estacion){
    estaciones.add(estacion);
  }

  public void eliminarEstacion(Estacion estacion){
    estaciones.remove(estacion);
  }

}
