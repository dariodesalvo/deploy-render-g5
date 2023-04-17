package ar.edu.utn.frba.dds.domain.comunidades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Usuario {
    private String nombre;
    private String contrasenia;
    private String email;
    private List<String> intereses;
    private List<Comunidad> comunidades;

    public void registrarUsuario(String nombreUsuario, String contrasenia){

    }

    public void compartirInformacion(){}
}
