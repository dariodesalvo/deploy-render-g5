package ar.edu.utn.frba.dds.domain.helpers;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import org.junit.jupiter.api.*;

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
  @AfterEach
  public void reiniciarIntentosDeLogin(){
    iniciarSesion.setCantidadIntentosDeLogin(3);
  }
  @Test
  @DisplayName("El usuario ingresa sus credenciales correctamente en un intento")
  public void iniciarSesionCorrectamenteEnUnIntento(){
    Boolean inicioDeSesionExitoso = iniciarSesion.validarUsuario(usuario.getEmail(), usuario.getContrasenia());
    Assertions.assertTrue(inicioDeSesionExitoso);
  }
  @Test
  @DisplayName("El usuario ingresa sus credenciales correctamente en dos intentos")
  public void iniciarSesionCorrectamenteEnDosIntentos() {
    Boolean inicioDeSesionExitoso;
    inicioDeSesionExitoso = iniciarSesion.validarUsuario("pepit@gmail.com", usuario.getContrasenia());
    inicioDeSesionExitoso = iniciarSesion.validarUsuario(usuario.getEmail(), usuario.getContrasenia());
    Assertions.assertTrue(inicioDeSesionExitoso);
    Assertions.assertEquals(2, iniciarSesion.getCantidadIntentosDeLogin());
  }
  @Test
  @DisplayName("El usuario no ingresa al sistema porque superó la cantidad de intentos")
  public void inicioDeSesiónFallido() {
    Boolean inicioDeSesionExitoso;
    inicioDeSesionExitoso = iniciarSesion.validarUsuario("pepit@gmail.com", usuario.getContrasenia());
    inicioDeSesionExitoso = iniciarSesion.validarUsuario(usuario.getEmail(), usuario.getContrasenia());
    inicioDeSesionExitoso = iniciarSesion.validarUsuario(usuario.getEmail(), "lalallala");
    inicioDeSesionExitoso = iniciarSesion.validarUsuario("pepit@gmail.com", "allalallalala");
    inicioDeSesionExitoso = iniciarSesion.validarUsuario("pepit@gmail.com", "allalalallallalala");
    Assertions.assertFalse(inicioDeSesionExitoso);
    Assertions.assertEquals(0, iniciarSesion.getCantidadIntentosDeLogin());
  }



}
