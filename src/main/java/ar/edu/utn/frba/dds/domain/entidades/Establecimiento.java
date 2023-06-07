package ar.edu.utn.frba.dds.domain.entidades;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import ar.edu.utn.frba.dds.domain.helpers.Municipio;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class Establecimiento {
    public String leyenda;
    public Collection<Usuario> followers;
    public Municipio localizacion;
}
