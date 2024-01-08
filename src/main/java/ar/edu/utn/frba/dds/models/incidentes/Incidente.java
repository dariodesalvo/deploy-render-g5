package ar.edu.utn.frba.dds.models.incidentes;

import ar.edu.utn.frba.dds.models.Persistente;
import ar.edu.utn.frba.dds.models.comunidades.Comunidad;
import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.RolesUsuario;
import ar.edu.utn.frba.dds.models.converters.LocalDateTimeAttributeConverter;
import ar.edu.utn.frba.dds.models.incidentes.mensajes.AperturaIncidente;
import ar.edu.utn.frba.dds.models.incidentes.mensajes.CierreIncidente;
import ar.edu.utn.frba.dds.models.incidentes.mensajes.Mensaje;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.mail.EmailException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "incidente")
public class Incidente extends Persistente {

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abierto_por", referencedColumnName = "id")
    private Miembro abiertoPor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cerrado_por", referencedColumnName = "id")
    private Miembro cerradoPor;

    @ManyToOne
    @JoinColumn(name = "comunidad_id", referencedColumnName = "id")
    private Comunidad comunidad;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "observacionesApertura")
    private String observacionesApertura;
    @Column(name = "observacionesCierre")
    private String observacionesCierre;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechaApertura")
    private LocalDateTime fechaApertura;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechaCierre")
    private LocalDateTime fechaCierre;
    @Transient
    private Notificador notificador;

    public Incidente(Servicio servicio, Miembro abiertoPor, Comunidad comunidad, String observaciones) throws EmailException {
        this.servicio = servicio;
        this.abiertoPor = abiertoPor;
        this.comunidad = comunidad;
        this.observacionesApertura = observaciones;
        this.fechaApertura = LocalDateTime.now();
        this.estado=Boolean.TRUE;

        //llamar a notificador pasarle la comunidad y el incidente

        Mensaje mensaje = new AperturaIncidente();

        //this.notificador.notificar(comunidad, this, mensaje);

    }

    public Incidente(){

    }

    public void notificarCercania(String mensaje,List<Comunidad> comunidades){}

    public void cerrar(Miembro miembro, String observaciones) throws EmailException {
        this.setCerradoPor(miembro);
        this.observacionesCierre = observaciones;
        this.fechaCierre= LocalDateTime.now();
        this.estado=Boolean.FALSE;
        Mensaje mensaje = new CierreIncidente();
        //this.notificador.notificar(comunidad, this, mensaje);

    }

}
