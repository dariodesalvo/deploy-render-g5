package ar.edu.utn.frba.dds.models.archivoCSV;

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

        lecturasDeArchivo.add(atributoArchivo);
      }
      archivo.close();
    } catch (IOException e) {
      throw new IOException("No se ha encontrado el archivo");
    }
    return lecturasDeArchivo;
  }
}
