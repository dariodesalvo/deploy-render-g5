package ar.edu.utn.frba.dds.domain.incidentes;

import ar.edu.utn.frba.dds.domain.helpers.notificaciones.Dia;
import ar.edu.utn.frba.dds.domain.helpers.notificaciones.Hora;
import ar.edu.utn.frba.dds.domain.incidentes.TurnoDeNotificaciones.TurnoNotificacion;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class TipoNotificacion {
    private boolean inmediata;
    private List<TurnoNotificacion> preferenciaTurnos;


public void agregarNotificacion(String notificacion){
    for (TurnoNotificacion turno : preferenciaTurnos
         ) {
        turno.agregarNotificacion(notificacion);
    }
}


}


