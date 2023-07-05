package ar.edu.utn.frba.dds.jobs;

import java.util.Date;
import java.util.Timer;

public class JobInvoker {

  public JobInvoker() {
  }

  public void runJob(){
    Timer time = new Timer();
    JobTask task = new JobTask();
    time.schedule(task ,new Date(),1000);
    System.out.println(task.isRunning());

  }
}
