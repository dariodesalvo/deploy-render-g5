package ar.edu.utn.frba.dds.domain.archivoCSV;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AdapterCSVFileReader {
  public void leerArchivoCSV(String archivoCSV) throws IOException;
}
