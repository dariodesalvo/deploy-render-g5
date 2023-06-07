package ar.edu.utn.frba.dds.domain.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicio {
  private int codigoServicio;
  private String nombre;
  private Municipio ubicacion;
  private List<Municipio> tramos = new ArrayList<Municipio>();
  private boolean esDeElevacion;
  private boolean estaActivo;


  public Servicio() {
  }

  public Servicio(int codigoServicio, String nombre, Municipio ubicacion, boolean esDeElevacion, boolean estaActivo) {
    this.codigoServicio = codigoServicio;
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.esDeElevacion = esDeElevacion;
    this.estaActivo = estaActivo;
  }

}
