package ar.edu.utn.frba.dds.domain.helpers;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class IniciarSesiónTests {
  private Usuario usuario;
  private IniciarSesion iniciarSesion;
  @BeforeEach
  public void inicializar() throws Exception {
    try {
      usuario = new Usuario("pepito@gmail.com","Pa$$W0rd");
    } catch (Exception e) {
      throw new RuntimeException("No se ha podido crear el usuario");
    }
    iniciarSesion = new IniciarSesion(usuario);
  }
  @Test
  @DisplayName("El usuario ingresa sus credenciales correctamente en un intento")
  public void iniciarSesionCorrectamenteEnUnIntento(){
    Boolean inicioDeSesionExitoso = iniciarSesion.validarUsuario(usuario.getEmail(), usuario.getContrasenia());
    Assertions.assertTrue(inicioDeSesionExitoso);
  }


}
