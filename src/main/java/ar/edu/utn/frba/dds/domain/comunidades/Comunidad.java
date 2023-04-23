package ar.edu.utn.frba.dds.domain.comunidades;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comunidad {
  private String nombre;
  private List<Usuario> usuarios;
  private List<Usuario> administradores;


}
