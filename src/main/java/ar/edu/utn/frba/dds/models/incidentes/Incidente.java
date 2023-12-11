package ar.edu.utn.frba.dds.models.incidentes;

import ar.edu.utn.frba.dds.models.Persistente;
import ar.edu.utn.frba.dds.models.comunidades.Comunidad;
import ar.edu.utn.frba.dds.models.comunidades.Miembro;
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
    @JoinColumn(name = "miembro_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Miembro abiertoPor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "miembro_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Miembro cerradoPor;
    @ManyToOne
    @JoinColumn(name = "comunidad_id", referencedColumnName = "id")
    private Comunidad comunidad;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "observaciones")
    private String observaciones;
    @Transient
    private LocalDateTime fechaApertura;
    @Transient
    private LocalDateTime fechaCierre;
    @Transient
    private Notificador notificador;

    public Incidente(Servicio servicio, Miembro abiertoPor, Comunidad comunidad, String observaciones) throws EmailException {
        this.servicio = servicio;
        this.abiertoPor = abiertoPor;
        this.comunidad = comunidad;
        this.observaciones = observaciones;
        this.fechaApertura = LocalDateTime.now();

        //llamar a notificador pasarle la comunidad y el incidente

        Mensaje mensaje = new AperturaIncidente();

        this.notificador.notificar(comunidad, this, mensaje);

    }

    public Incidente(){

    }

    public void notificarCercania(String mensaje,List<Comunidad> comunidades){}

    public void cerrar(Miembro miembro) throws EmailException {
        this.setCerradoPor(miembro);
        this.fechaCierre= LocalDateTime.now();
        Mensaje mensaje = new CierreIncidente();
        this.notificador.notificar(comunidad, this, mensaje);

    }


}


/*Toda persona miembro de alguna comunidad podrá informar el no funcionamiento de prestaciones de
servicios en establecimientos. Cada incidente se considerará válido para la propia comunidad (del miembro
informante) y no para todas las comunidades, ya que cada comunidad opera de forma cerrada/aislada.
Además, cabe destacar que el incidente puede ser asignado a un servicio base (“baño de mujeres”, por
ejemplo) o a un servicio compuesto (“baños”, por ejemplo).
Cuando un miembro informe sobre un incidente, el Sistema deberá informar a todos los miembros de la
comunidad sobre este hecho.
los miembro de una comunidad podrá observar en el Sistema el listado de incidentes reportados. Además,
la notificación de “Nuevo incidente” se realizará vía correo electrónico o vía WhatsApp, según configure una
persona como medio de comunicación preferido (a fines de optimizar el uso de recursos técnicos sólo se
permitirá la configuración de uno de esos medios).
La notificación de incidentes es exclusivamente por funcionamiento o no funcionamiento del servicio (se
entiende y asume que un servicio que funciona de forma limitada pero que impide su utilización normal a la
comunidad, se encuentra fuera de funcionamiento). Además, quien registra el incidente podrá cargar
observaciones relativas al mismo; además de la fecha y hora.
Trabajo Práctico Anual 2023 – Monitoreo de Estado de Servicios
Página 11 de 19
Cierre de incidentes
Los miembros podrán indicar como “resuelto” el incidente que otro miembro de la comunidad (o ellos
mimos) haya abierto. Ante este suceso el Sistema deberá, nuevamente, notificar a todos los miembros de
la comunidad por los mismos medios de notificación antes mencionados.*/