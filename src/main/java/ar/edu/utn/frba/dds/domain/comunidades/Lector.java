package ar.edu.utn.frba.dds.domain.comunidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "Lector")
public class Lector extends RolesUsuario {
    private void enviarComentario(String comentario){
        System.out.print(comentario);
    }
}
