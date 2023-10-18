package ar.edu.utn.frba.dds.domain.comunidades;
import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;
import ar.edu.utn.frba.dds.domain.incidentes.TipoNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.mail.EmailException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Miembro")
public class Miembro extends RolesUsuario {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "celular")
    private String celular;

    @Transient
    private MedioDeNotificacion medioNotificacionPreferido;
    @Transient
    private TipoNotificacion tipoNotificacion;
    @Transient
    private List<Comunidad> comunidades = new ArrayList<>();
    @Transient
    private HashMap<Servicio,Boolean> serviciosDeInteres;
    @Transient
    private Integer numero;
    @Transient
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
