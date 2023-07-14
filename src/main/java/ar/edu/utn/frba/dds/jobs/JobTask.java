package ar.edu.utn.frba.dds.jobs;

import ar.edu.utn.frba.dds.domain.tarea.Tarea;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
public class JobTask extends TimerTask {
  private List<Tarea> tareasAEjecutar = new ArrayList<Tarea>();

  public JobTask(List<Tarea> tareasAEjecutar) {
    this.tareasAEjecutar = tareasAEjecutar;
  }


  @Override
  public void run() {
    try {
      tareasAEjecutar.forEach(tarea -> {
        tarea.ejecutar();
      });

    } catch (Exception ex) {

      System.out.println("Error al ejecutar rutina " + ex.getMessage());
    }
  }
}
