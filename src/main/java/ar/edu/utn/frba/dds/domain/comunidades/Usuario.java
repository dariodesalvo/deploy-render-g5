package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import ar.edu.utn.frba.dds.domain.helpers.IniciarSesion;
import ar.edu.utn.frba.dds.domain.helpers.ValidadorContrasenia;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Usuario {

  private String contrasenia;
  private String email;
  private List<Interes> intereses = new ArrayList<Interes>();
  private List<Comunidad> comunidades = new ArrayList<Comunidad>();
  private RolesUsuario rol = new Lector();
  private Municipio localizacion;


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

  private void iniciarSesion(String nombreUsuario, String contrasenia) {
    IniciarSesion inicioDeSesion = new IniciarSesion(this);
    inicioDeSesion.validarUsuario(nombreUsuario, contrasenia);
  }

 /* public void solicitarSerMiembro(Comunidad comunidad){
    comunidad.agregarMiembro(this);
    comunidades.add(comunidad);
  }*/

  public boolean esAdministrador(Comunidad comunidad){
    return comunidad.getAdministradores().contains(this);
  }

}
