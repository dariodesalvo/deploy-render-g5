package ar.edu.utn.frba.dds.domain.servicios;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicio {
  private String nombre;
  private Ubicacion ubicacion;
  private List<Ubicacion> tramos;
  private boolean esDeElevacion;
  private boolean estaActivo;
}
