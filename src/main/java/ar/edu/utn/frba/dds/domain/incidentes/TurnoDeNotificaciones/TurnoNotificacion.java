package ar.edu.utn.frba.dds.domain.incidentes.TurnoDeNotificaciones;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class TurnoNotificacion {
    protected List<Miembro> miembros;
    protected List<String> notificaciones;

    public void agregarNotificacion(String notificacion){
        notificaciones.add(notificacion);
    }

    public void quitarNotificacion(String notificacion){
        notificaciones.remove(notificacion);
    }

}
