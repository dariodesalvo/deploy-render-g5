package ar.edu.utn.frba.dds.domain.archivoCSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV implements AdapterCSVFileReader {
  @Override
  public List<CSVRecord> leerArchivoCSV(String archivoCSV) throws IOException {
    List<CSVRecord> lecturasDeArchivo = new ArrayList<CSVRecord>();
    try {
      Reader archivo = new FileReader(archivoCSV);
      Iterable<CSVRecord> atributosArchivo = CSVFormat.DEFAULT.withDelimiter(';').withHeader().parse(archivo);

      for (CSVRecord atributoArchivo : atributosArchivo) {
        int codigoEmpresa = Integer.parseInt(atributoArchivo.get("Codigo Empresa"));
        String nombreEmpresa = atributoArchivo.get("Nombre Empresa");
        String usuarioResponsable = atributoArchivo.get("Usuario Responsable");
        int codigoServico = Integer.parseInt(atributoArchivo.get("Codigo Servicio"));
        String nombreServicio = atributoArchivo.get("Nombre Servicio");
        String municipio = atributoArchivo.get("Municipio");
        String esServicioDeElvacion = atributoArchivo.get("Es de elevacion").toLowerCase();
        String elServicioEstaActivo = atributoArchivo.get("Esta Activo");

        Boolean esDeElvacion = esServicioDeElvacion.contains("si") ? true : false;
        Boolean estaActivo = elServicioEstaActivo.contains("si") ? true : false;

        lecturasDeArchivo.add(atributoArchivo);
      }
      archivo.close();
    } catch (IOException e) {
      throw new IOException("No se ha encontrado el archivo");
    }
    return lecturasDeArchivo;
  }
}
