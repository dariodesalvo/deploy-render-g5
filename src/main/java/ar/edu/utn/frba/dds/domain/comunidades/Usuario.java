package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.helpers.ValidadorContrasenia;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
  private String nombre;
  private String contrasenia;
  private String email;
  private List<String> intereses = new ArrayList<String>();
  private List<Comunidad> comunidades = new ArrayList<Comunidad>();
  private RolesUsuario rol = new Lector();
  private ValidadorContrasenia validadorDeContrasenia = new ValidadorContrasenia();

  public void registrarUsuario(String nombreUsuario, String contrasenia, String email)
          throws Exception {
    try {
      if (validadorDeContrasenia.laContraseniaEsValida(contrasenia)) {
        this.nombre = nombreUsuario;
        this.contrasenia = contrasenia;
        this.email = email;

      }
    } catch (Exception e) {
      throw new Exception("No se ha podido validar la contraseñia. Usuario no creado");
    }

  }

  public void iniciarSesion(String nombreUsuario, String contrasenia) {
    IniciarSesion inicioDeSesion = new IniciarSesion(this);
    inicioDeSesion.validarUsuario(nombreUsuario, contrasenia);
  }

}
