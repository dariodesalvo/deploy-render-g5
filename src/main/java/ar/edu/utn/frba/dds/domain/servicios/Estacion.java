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


  public void agregarServicio(Servicio servicio) throws Exception {
    this.validarRepetido(servicio);
    servicios.add(servicio);
  }

  public void eliminarServicio(Servicio servicio) throws Exception {
    this.validarServicioExistente(servicio);
    servicios.remove(servicio);
  }

  public void validarRepetido(Servicio servicio) throws Exception {
    if(servicios.contains(servicio)){
      throw new Exception("El servicio ya fue dado de alta");
    }
  }

  public void validarServicioExistente(Servicio servicio) throws Exception {
    if(!servicios.contains(servicio)){
      throw new Exception("No se encuentra el servicio que se quiere dar de baja");
    }
  }

}


