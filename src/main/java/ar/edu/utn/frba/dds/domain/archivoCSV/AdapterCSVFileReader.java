package ar.edu.utn.frba.dds.domain.archivoCSV;

import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public interface AdapterCSVFileReader {
  public List<CSVRecord> leerArchivoCSV(String archivoCSV) throws IOException;
}
