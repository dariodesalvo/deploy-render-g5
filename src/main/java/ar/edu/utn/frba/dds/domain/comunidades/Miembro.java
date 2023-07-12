package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import ar.edu.utn.frba.dds.domain.comunidades.Comunidad
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Miembro extends RolesUsuario {

    private String nombre;
    private String apellido;
    private List<Comunidad> comunidades;
    private List<Servicio> serviciosDeInteres;
    private

    public Miembro(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public void abrirIncidente(Servicio servicio){}
    public void cerrarIncidente(Servicio servicio){}

}
