package ar.edu.utn.frba.dds.domain.comunidades;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Lector extends RolesUsuario {
    private void enviarComentario(String comentario){
        System.out.print(comentario);
    }
}
