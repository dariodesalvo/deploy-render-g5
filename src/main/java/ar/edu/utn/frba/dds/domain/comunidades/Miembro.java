package ar.edu.utn.frba.dds.domain.comunidades;
import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;
import ar.edu.utn.frba.dds.domain.incidentes.TipoNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.mail.EmailException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Miembro extends RolesUsuario {

    private String nombre;
    private String apellido;
    private String celular;
    private MedioDeNotificacion medioNotificacionPreferido;
    private TipoNotificacion tipoNotificacion;
    private List<Comunidad> comunidades = new ArrayList<>();
    private HashMap<Servicio,Boolean> serviciosDeInteres;
    private Integer numero;
    private String email;

    public Miembro(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public List<Incidente> abrirIncidente(Servicio servicio){
        List<Incidente> incidentes = new ArrayList<>();
        numero=0;
        comunidades.forEach(comunidad -> { numero++;
            try {
                incidentes.add(new Incidente(servicio,this,comunidad,""));
            } catch (EmailException e) {
                throw new RuntimeException(e);
            }
        });
        return incidentes;
    }

    public void cerrarIncidente(Incidente incidente) throws EmailException {
        incidente.cerrar(this);
    }

    public void sosParte(Comunidad comunidad){
        comunidades.add(comunidad);
    }

}
