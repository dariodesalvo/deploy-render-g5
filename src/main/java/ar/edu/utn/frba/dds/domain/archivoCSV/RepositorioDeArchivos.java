package ar.edu.utn.frba.dds.domain.archivoCSV;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeArchivos {
  @Getter
  @Setter
  private static List<ArchivoCSV> archivos = new ArrayList<ArchivoCSV>();

  public static void agregarLecturaDeArchivo (ArchivoCSV archivoCSV){
    archivos.add(archivoCSV);
  }
}
