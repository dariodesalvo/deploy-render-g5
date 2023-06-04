package ar.edu.utn.frba.dds.domain.archivoCSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class LectorCSV implements AdapterCSVFileReader {
  @Override
  public void leerArchivoCSV(String archivoCSV) throws IOException {
    try {
      Reader archivo = new FileReader(archivoCSV);
      Iterable<CSVRecord> atributosArchivo = CSVFormat.DEFAULT.withDelimiter(';').withHeader().parse(archivo);

      for (CSVRecord atributoArchivo : atributosArchivo) {
        String codigoEmpresa = atributoArchivo.get("Codigo Empresa");
        String nombreEmpresa = atributoArchivo.get("Nombre Empresa");
        String codigoServico = atributoArchivo.get("Codigo Servicio");
        String nombreServicio = atributoArchivo.get("Nombre Servicio");
        String usuarioResponsable = atributoArchivo.get("Usuario Responsable");

        ArchivoCSV lecturaArchivoCSV = new ArchivoCSV(codigoEmpresa, nombreEmpresa, codigoServico, nombreServicio, usuarioResponsable);
        RepositorioDeArchivos.agregarLecturaDeArchivo(lecturaArchivoCSV);
      }
      archivo.close();
    } catch (IOException e) {
      throw new IOException("No se ha encontrado el archivo");
    }
  }
}
