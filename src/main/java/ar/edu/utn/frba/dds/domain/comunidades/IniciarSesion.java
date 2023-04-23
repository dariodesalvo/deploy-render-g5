package ar.edu.utn.frba.dds.domain.comunidades;

public class IniciarSesion {
  private final Usuario usuario;
  private static int cantidadIntentosDeLogin = 3;

  public IniciarSesion(Usuario usuario) {
    this.usuario = usuario;
  }

  public void validarUsuario(String nombreUsuario, String contrasenia) {
    if (cantidadIntentosDeLogin != 0) {
      if (usuario.getNombre().equals(nombreUsuario)
              && usuario.getContrasenia().equals(contrasenia)) {
        System.out.println("Inicio de sesión exitoso");
      } else {
        System.out.printf("Usuario o contraseña incorrecta. Intente nuevamente. "
                + "Intentos restantes:", cantidadIntentosDeLogin);
        cantidadIntentosDeLogin--;
      }
    } else {
      System.out.print("Ha superado la cantidad máxima de intentos de inicio de sesión."
              + " Intente más tarde nuevamente");
    }

  }


}
