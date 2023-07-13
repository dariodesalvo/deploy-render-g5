package ar.edu.utn.frba.dds.jobs;

import ar.edu.utn.frba.dds.domain.comunidades.Administrador;
import ar.edu.utn.frba.dds.domain.entidades.Empresa;
import ar.edu.utn.frba.dds.domain.repositorios.RepositorioEmpresas;
import ar.edu.utn.frba.dds.domain.repositorios.RepositorioServicios;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobTests  {
  private NotificadorJob task;
  @BeforeEach
  public void inicializar() throws IOException {
    task = new NotificadorJob(1000);
    task.runJob();
  }

  @Test
  @DisplayName("Correr Job")
  public void correrJob() {
  }
}
