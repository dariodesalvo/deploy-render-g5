package ar.edu.utn.frba.dds.domain.archivoCSV;

import ar.edu.utn.frba.dds.domain.comunidades.Administrador;
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
  public void limpiarRepositio (){
    RepositorioServicios.servicios = new ArrayList<Servicio>();
  }

  @Test
  @DisplayName("Un administrador puede cargar un archivo CSV")
  public void administradorCargaCSVCorrectamente() throws Exception {

    Assertions.assertEquals(5, RepositorioServicios.servicios.size());
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
    public void leerCodigoEmpresa() throws Exception {
        Servicio molinete = RepositorioServicios.servicios.get(3);
        Assertions.assertEquals(46388,molinete.getCodigoServicio());
    }
  /*
  @Test
  @DisplayName("El codigo de la empresa es 12345")
  public void leerCodigoEmpresa() throws Exception {
    ArchivoCSV primerRecord = RepositorioDeArchivos.getArchivos().get(0);
    Assertions.assertEquals("12345",primerRecord.getCodigoEmpresa());
  }
  @Test
  @DisplayName("La empresa presta como servicios: EstacionCampus, EstacionMedrano, KioskoCampus,KioskoMedrano,PuntoCargaCampus,PuntoCargaMedrano")
  public void leerServiciosQuePrestaLaEmpresa() throws Exception {
    List<ArchivoCSV> archivos = RepositorioDeArchivos.getArchivos();
    List<String> servicios =  archivos.stream().map(archivo -> archivo.getNombreServicio()).toList();

    Assertions.assertTrue(servicios.contains("EstacionCampus"));
    Assertions.assertTrue(servicios.contains("EstacionMedrano"));
    Assertions.assertTrue(servicios.contains("KioskoCampus"));
    Assertions.assertTrue(servicios.contains("KioskoMedrano"));
    Assertions.assertTrue(servicios.contains("PuntoCargaCampus"));
    Assertions.assertTrue(servicios.contains("PuntoCargaMedrano"));

  }
  @Test
  @DisplayName("La empresa no presta un banio como servicio")
  public void laEmpresaNoPrestaUnServicio() throws Exception {
    List<ArchivoCSV> archivos = RepositorioDeArchivos.getArchivos();
    List<String> servicios =  archivos.stream().map(archivo -> archivo.getNombreServicio()).toList();

    Assertions.assertFalse(servicios.contains("banio"));

  }
  */

}
