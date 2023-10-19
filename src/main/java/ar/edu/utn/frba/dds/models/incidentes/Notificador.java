package ar.edu.utn.frba.dds.models.incidentes;

import ar.edu.utn.frba.dds.models.comunidades.Comunidad;
import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.incidentes.TurnoDeNotificaciones.TurnoNotificacion;
import ar.edu.utn.frba.dds.models.incidentes.mensajes.Mensaje;
import org.apache.commons.mail.EmailException;

public final class Notificador {


    public void notificar(Comunidad comunidad, Incidente incidente, Mensaje mensaje) throws EmailException {


        String notificacion = mensaje.contenido(incidente);

        for (Miembro miembro :  comunidad.getMiembros()
             ) {

            if(miembro.getTipoNotificacion().isInmediata()){
                // se notifica de one
                miembro.getMedioNotificacionPreferido().enviarNotificacion(miembro, notificacion);
            }
            else{
                //entra en una cola
                miembro.getTipoNotificacion().agregarNotificacion(notificacion);
            }

        }

    }

    public void notificarPendientes(TurnoNotificacion turno) throws EmailException {

        for (String notificacion: turno.getNotificaciones()
             ) {
            // hay que notificar a todos los miembros
            for (Miembro miembro : turno.getMiembros()
                 ) {
                miembro.getMedioNotificacionPreferido().enviarNotificacion(miembro, notificacion);
            }
            //removes la notificacion
            turno.quitarNotificacion(notificacion);
        }

    }

}
