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
  private String apellido;
  private String contrasenia;
  private String email;
  private List<Interes> intereses = new ArrayList<Interes>();
  private List<Comunidad> comunidades = new ArrayList<Comunidad>();
  private RolesUsuario rol = new Lector();
  public Usuario(String email, String contrasenia)
        throws Exception
  {

    try{
      if(ValidadorContrasenia.laContraseniaEsValida(contrasenia))
      {
        this.contrasenia=contrasenia;
        this.email=email;
        // this.registrarUsuario(this);
      }
      else{
        System.out.println("El password no cumple con los requerimientos de seguridad.");
      }
    }catch (Exception e){
      new Exception("No se ha podido registrar un nuevo usuario.");
    }

  }

  public void registrarUsuario(Usuario usuario){

    //se guarda en la base de datos

  }

  public void iniciarSesion(String nombreUsuario, String contrasenia) {
    IniciarSesion inicioDeSesion = new IniciarSesion(this);
    inicioDeSesion.validarUsuario(nombreUsuario, contrasenia);
  }

}
