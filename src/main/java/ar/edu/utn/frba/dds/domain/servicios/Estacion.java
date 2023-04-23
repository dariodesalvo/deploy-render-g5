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
}
