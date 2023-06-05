package ar.edu.utn.frba.dds.domain.archivoCSV;

import ar.edu.utn.frba.dds.domain.archivoCSV.ArchivoCSV;
import ar.edu.utn.frba.dds.domain.archivoCSV.RepositorioDeArchivos;
import ar.edu.utn.frba.dds.domain.servicios.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoCSVTest {
  /*
  Empresa transporteDDS = new Empresa();

  @BeforeEach
  public void inicializar() throws IOException {
    transporteDDS.cargarArchivo("src/test/java/ar/edu/utn/frba/dds/domain/archivoCSV/archivoCSVPrueba.csv");
  }
  @AfterEach
  public void limpiarRepositio (){
    RepositorioDeArchivos.setArchivos(new ArrayList<ArchivoCSV>());
  }

  @Test
  @DisplayName("Una empresa puede cargar un archivo CSV")
  public void empresaCargaCSVCorrectamente() throws Exception {

    Assertions.assertEquals(6,RepositorioDeArchivos.getArchivos().size());
    Assertions.assertDoesNotThrow(()->{inicializar();});
  }
  @Test
  @DisplayName("Una empresa no puede cargar un archivo CSV")
  public void empresaNoCargaCSVCorrectamente() throws Exception {
    Assertions.assertThrows(IOException.class, ()->{
      transporteDDS.cargarArchivo("src/test/java/ar/edu/utn/frba/dds/archivoCSV/archia.csv");
    },"No se ha podido leer el archivo");
  }
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
