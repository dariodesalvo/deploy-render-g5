package ar.edu.utn.frba.dds.jobs;

import java.util.TimerTask;

public class JobTask extends TimerTask {
  public boolean isRunning() {
    return isRunning;
  }

  private boolean isRunning;
  public JobTask() {
  }

  @Override
  public void run() {
    try {
isRunning =true;
      System.out.println("Ejecutando rutina");

    } catch (Exception ex) {

      System.out.println("Error al ejecutar rutina " + ex.getMessage());
    }
  }
}
