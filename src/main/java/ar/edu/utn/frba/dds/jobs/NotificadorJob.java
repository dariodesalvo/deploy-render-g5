package ar.edu.utn.frba.dds.jobs;

import java.util.Date;
import java.util.Timer;

public class NotificadorJob {
  private long periodoDeEjecucion;

  public NotificadorJob(long periodoDeEjecucion) {
    this.periodoDeEjecucion = periodoDeEjecucion;
  }

  public void runJob(){
    Timer time = new Timer();
    JobTask task = new JobTask();
    time.schedule(task ,new Date(),this.periodoDeEjecucion);

  }
}
