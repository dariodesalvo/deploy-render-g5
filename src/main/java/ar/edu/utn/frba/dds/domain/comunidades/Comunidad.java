package ar.edu.utn.frba.dds.domain.comunidades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Comunidad {
    private String nombre;
    private List<Usuario> usuarios;
    private List<Usuario> administradores;



}
