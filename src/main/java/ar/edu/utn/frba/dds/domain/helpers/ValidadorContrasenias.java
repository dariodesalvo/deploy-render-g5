package ar.edu.utn.frba.dds.domain.helpers;

import java.net.MalformedURLException;

public interface ValidadorContrasenias {

  void validarPassword(String nombreUsuario, String contrasenia) throws MalformedURLException;
}
