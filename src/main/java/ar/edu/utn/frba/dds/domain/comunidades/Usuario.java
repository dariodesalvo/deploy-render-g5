package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.helpers.IniciarSesion;
import ar.edu.utn.frba.dds.domain.helpers.Municipio;
import ar.edu.utn.frba.dds.domain.helpers.ValidadorContrasenia;
import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.dds.domain.servicios.Ubicacion;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class Usuario {

  private String contrasenia;
  private String email;
  private List<Interes> intereses = new ArrayList<Interes>();
  private List<Comunidad> comunidades = new ArrayList<Comunidad>();
  private RolesUsuario rol = new Lector();
  private String municipio;
  private Ubicacion ubicacion = new Ubicacion();

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

  public void registrarUsuario(Usuario usuario){

    //se guarda en la base de datos

  }

  public void iniciarSesion(String nombreUsuario, String contrasenia) {
    IniciarSesion inicioDeSesion = new IniciarSesion(this);
    inicioDeSesion.validarUsuario(nombreUsuario, contrasenia);
  }

  private void solicitarSerMiembro(Comunidad comunidad){
    comunidad.agregarMiembro(this);
    comunidades.add(comunidad);
  }

}
