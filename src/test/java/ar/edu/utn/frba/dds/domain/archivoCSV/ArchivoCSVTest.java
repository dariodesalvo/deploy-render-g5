package ar.edu.utn.frba.dds.domain.archivoCSV;

import ar.edu.utn.frba.dds.domain.comunidades.Administrador;
import ar.edu.utn.frba.dds.domain.entidades.Empresa;
import ar.edu.utn.frba.dds.domain.repositorios.RepositorioEmpresas;
import ar.edu.utn.frba.dds.domain.repositorios.RepositorioServicios;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoCSVTest {

    private Administrador administrador;
  @BeforeEach
  public void inicializar() throws IOException {
      administrador = new Administrador();
      administrador.cargarArchivo("src/test/java/ar/edu/utn/frba/dds/domain/archivoCSV/DatosEmpresasYServicios.csv");
  }
  @AfterEach
  public void limpiarRepositorios (){
    RepositorioServicios.servicios = new ArrayList<Servicio>();
    RepositorioEmpresas.empresas= new ArrayList<Empresa>();
  }

  @Test
  @DisplayName("Un administrador puede cargar un archivo CSV")
  public void administradorCargaCSVCorrectamente() throws Exception {

    Assertions.assertEquals(5, RepositorioServicios.servicios.size());
    Assertions.assertEquals(5, RepositorioEmpresas.empresas.size());
    Assertions.assertDoesNotThrow(()->{inicializar();});
  }

  @Test
  @DisplayName("Un administrador no puede cargar un archivo CSV")
  public void empresaNoCargaCSVCorrectamente() throws Exception {
    Assertions.assertThrows(IOException.class, ()->{
      administrador.cargarArchivo("src/test/java/ar/edu/utn/frba/dds/archivoCSV/archia.csv");
    },"No se ha podido leer el archivo");
  }
    @Test
    @DisplayName("Los servicios en el sistema son banio,escalera mecanica,barrera,molinete y ascensor")
    public void serviciosDelSistema() throws Exception {
        List<Servicio> listaServicios = RepositorioServicios.servicios;
        List<String> servicios =  listaServicios.stream().map(servicio -> servicio.getNombre()).toList();

        Assertions.assertTrue(servicios.contains("Banio"));
        Assertions.assertTrue(servicios.contains("Escalera Mecanica"));
        Assertions.assertTrue(servicios.contains("Barrera"));
        Assertions.assertTrue(servicios.contains("Molinete"));
        Assertions.assertTrue(servicios.contains("Ascensor"));
    }
    @Test
    @DisplayName("El codigo del molinete es 46388")
    public void leerCodigoServicio() throws Exception {
        Servicio molinete = RepositorioServicios.servicios.get(3);
        Assertions.assertEquals(46388,molinete.getCodigoServicio());
    }

  @Test
  @DisplayName("El codigo de la empresa AscensoresDDS es 68888")
  public void leerCodigoEmpresa() throws Exception {
    Empresa ascensoresDDS = RepositorioEmpresas.empresas.get(1);
    Assertions.assertEquals(68888,ascensoresDDS.getCodigoEmpresa());
  }


}
