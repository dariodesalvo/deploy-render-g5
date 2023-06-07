package ar.edu.utn.frba.dds.domain.entidades;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class Entidad {
    public String leyenda;
    public Collection<Usuario> followers;
}
