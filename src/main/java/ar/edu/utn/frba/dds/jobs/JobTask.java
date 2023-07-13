package ar.edu.utn.frba.dds.jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class JobTask extends TimerTask {
  private List<String> tareasAEjecutar = new ArrayList<>();
  public JobTask() {
  }

  @Override
  public void run() {
    try {
      System.out.println("Ejecutando rutina");

    } catch (Exception ex) {

      System.out.println("Error al ejecutar rutina " + ex.getMessage());
    }
  }
}
