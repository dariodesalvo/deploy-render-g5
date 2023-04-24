package ar.edu.utn.frba.dds.domain.helpers;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;

public class IniciarSesion {
  private final Usuario usuario;
  private static int cantidadIntentosDeLogin = 3;

  public IniciarSesion(Usuario usuario) {
    this.usuario = usuario;
  }

  public boolean validarUsuario(String email, String contrasenia) {
    if (cantidadIntentosDeLogin != 0) {
      if (usuario.getEmail().equals(email)
              && usuario.getContrasenia().equals(contrasenia)) {
        System.out.println("Inicio de sesión exitoso");
        return true;
      } else {
        System.out.printf("Usuario o contraseña incorrecta. Intente nuevamente. "
                + "Intentos restantes:", cantidadIntentosDeLogin);
        cantidadIntentosDeLogin--;
        return false;
      }
    } else {
      System.out.print("Ha superado la cantidad máxima de intentos de inicio de sesión."
              + " Intente más tarde nuevamente");
      return false;
    }
  }


}
