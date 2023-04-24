package ar.edu.utn.frba.dds.domain.servicios;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estacion {
  private String nombre;
  private Ubicacion ubicacion;
  private List<Servicio> servicios;

  public void agregarServicio(Servicio servicio){
    servicios.add(servicio);
  }

  public void eliminarServicio(Servicio servicio){
    servicios.remove(servicio);
  }

}


