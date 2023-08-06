package ar.edu.utn.frba.dds.domain.comunidades;
import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;
import ar.edu.utn.frba.dds.domain.incidentes.TipoNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioNotificable;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Miembro extends RolesUsuario {

    private String nombre;
    private String apellido;
    private String celular;
    private MedioNotificable medioComunicacionPreferido;
    private TipoNotificacion tipoNotificacion;
    private List<Comunidad> comunidades;
    private HashMap<Servicio,Boolean> serviciosDeInteres;


    public Miembro(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public Incidente abrirIncidente(Servicio servicio, Establecimiento establecimiento, Comunidad comunidad){
        return new Incidente(servicio,establecimiento,this,comunidad,true,"", LocalDateTime.now());
    }

    public void cerrarIncidente(Servicio servicio){}

}
