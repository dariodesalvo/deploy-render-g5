package ar.edu.utn.frba.dds.domain.servicios;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicio {
  private int codigoServicio;
  private String nombre;
  private Ubicacion ubicacion;
  private List<Ubicacion> tramos;
  private boolean esDeElevacion;
  private boolean estaActivo;


  public Servicio() {
  }

  public Servicio(int codigoServicio, String nombre, Ubicacion ubicacion, List<Ubicacion> tramos, boolean esDeElevacion, boolean estaActivo) {
    this.codigoServicio = codigoServicio;
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.tramos = tramos;
    this.esDeElevacion = esDeElevacion;
    this.estaActivo = estaActivo;
  }
}
