package ar.edu.utn.frba.dds.domain.comunidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Miembro extends RolesUsuario {

    private String nombre;
    private String apellido;

    public Miembro(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

}
