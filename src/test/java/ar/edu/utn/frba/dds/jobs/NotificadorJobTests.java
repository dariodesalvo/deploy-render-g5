package ar.edu.utn.frba.dds.jobs;

import ar.edu.utn.frba.dds.domain.jobs.NotificadorJob;
import ar.edu.utn.frba.dds.domain.tarea.GenerarInforme;
import ar.edu.utn.frba.dds.domain.tarea.NotificarSinApuro;
import ar.edu.utn.frba.dds.domain.tarea.Tarea;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.times;

public class NotificadorJobTests {
  private NotificadorJob taskGenerarInforme;
  private NotificadorJob taskNotificarSinApuros;
  private Tarea generarInforme;
  private Tarea notificarSinApuro;
  @BeforeEach
  public void inicializar() throws IOException {
    taskGenerarInforme = new NotificadorJob(86400);
    taskNotificarSinApuros = new NotificadorJob(900);
    generarInforme = Mockito.mock(GenerarInforme.class);
    notificarSinApuro = Mockito.mock(NotificarSinApuro.class);
  }
  @AfterEach
  public void finalizarRutinas() {
    taskGenerarInforme.finalizarJob();
   taskNotificarSinApuros.finalizarJob();
  }
  @Test
  @DisplayName("Ejecutar tarea de generar informe")
  public void ejecutarJobGenerarInforme() {
    taskGenerarInforme.agregarTarea(generarInforme);
    taskGenerarInforme.ejecutarJob();
    Mockito.verify(generarInforme,times(1)).ejecutar();
  }

  @Test
  @DisplayName("Ejecutar tarea de notificar sin apuro")
  public void ejecutarJobNofificarSinApuro() {
    taskNotificarSinApuros.agregarTarea(notificarSinApuro);
    taskNotificarSinApuros.ejecutarJob();
    Mockito.verify(notificarSinApuro,times(1)).ejecutar();
  }
}
