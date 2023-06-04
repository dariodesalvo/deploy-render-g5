package ar.edu.utn.frba.dds.domain.archivoCSV;

import lombok.Getter;

@Getter
public class ArchivoCSV {
  String codigoEmpresa;
  String nombreEmpresa;
  String codigoServico;
  String nombreServicio;
  String usuarioResponsable;


  public ArchivoCSV(String codigoEmpresa, String nombreEmpresa, String codigoServico,
                    String nombreServicio, String usuarioResponsable) {
    this.codigoEmpresa = codigoEmpresa;
    this.nombreEmpresa = nombreEmpresa;
    this.codigoServico = codigoServico;
    this.nombreServicio = nombreServicio;
    this.usuarioResponsable = usuarioResponsable;
  }
}
