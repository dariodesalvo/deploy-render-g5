package ar.edu.utn.frba.dds.domain.archivoCSV;

import ar.edu.utn.frba.dds.domain.servicios.Ubicacion;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorCSV implements AdapterCSVFileReader {
  @Override
  public void leerArchivoCSV(String archivoCSV) throws IOException {
    try {
      Reader archivo = new FileReader(archivoCSV);
      Iterable<CSVRecord> atributosArchivo = CSVFormat.DEFAULT.withDelimiter(';').withHeader().parse(archivo);

      for (CSVRecord atributoArchivo : atributosArchivo) {
        int codigoEmpresa = Integer.parseInt(atributoArchivo.get("Codigo Empresa"));
        String nombreEmpresa = atributoArchivo.get("Nombre Empresa");
        String usuarioResponsable = atributoArchivo.get("Usuario Responsable");
        int codigoServico = Integer.parseInt(atributoArchivo.get("Codigo Servicio"));
        String nombreServicio = atributoArchivo.get("Nombre Servicio");
        String ubicacion = atributoArchivo.get("Ubicacion");
        String tramos = atributoArchivo.get("Tramos");
        boolean esDeElvacion = Boolean.parseBoolean(atributoArchivo.get("Es de elevacion"));
        boolean estaActivo = Boolean.parseBoolean(atributoArchivo.get("Esta Activo"));

       // ArchivoCSV lecturaArchivoCSV = new ArchivoCSV(codigoEmpresa, nombreEmpresa, codigoServico, usuarioResponsable);
        //RepositorioDeArchivos.agregarLecturaDeArchivo(lecturaArchivoCSV);
      }
      archivo.close();
    } catch (IOException e) {
      throw new IOException("No se ha encontrado el archivo");
    }
  }
}
