package ar.edu.utn.frba.dds.domain.comunidades;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioNotificable;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Miembro extends RolesUsuario {

    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private MedioNotificable medioComunicacionPreferido;
    private List<Comunidad> comunidades;
    private List<Servicio> serviciosDeInteres;


    public Miembro(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public void abrirIncidente(Servicio servicio){}
    public void cerrarIncidente(Servicio servicio){}

}
