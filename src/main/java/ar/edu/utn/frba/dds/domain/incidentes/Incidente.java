package ar.edu.utn.frba.dds.domain.incidentes;

import ar.edu.utn.frba.dds.domain.comunidades.Comunidad;
import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Incidente {

    private Servicio servicio;
    private Usuario abiertoPor;
    private Usuario cerradoPor;
    private Comunidad comunidad;
    private Boolean estado;
    private String observaciones;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;

    public void notificarCercania(String mensaje,List<Comunidad> comunidades){}




}


/*Toda persona miembro de alguna comunidad podrá informar el no funcionamiento de prestaciones de
servicios en establecimientos. Cada incidente se considerará válido para la propia comunidad (del miembro
informante) y no para todas las comunidades, ya que cada comunidad opera de forma cerrada/aislada.
Además, cabe destacar que el incidente puede ser asignado a un servicio base (“baño de mujeres”, por
ejemplo) o a un servicio compuesto (“baños”, por ejemplo).
Cuando un miembro informe sobre un incidente, el Sistema deberá informar a todos los miembros de la
comunidad sobre este hecho.
Todo miembro de una comunidad podrá observar en el Sistema el listado de incidentes reportados. Además,
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
Los miembros podrán indicar como “resuelto” todo incidente que otro miembro de la comunidad (o ellos
mimos) haya abierto. Ante este suceso el Sistema deberá, nuevamente, notificar a todos los miembros de
la comunidad por los mismos medios de notificación antes mencionados.*/