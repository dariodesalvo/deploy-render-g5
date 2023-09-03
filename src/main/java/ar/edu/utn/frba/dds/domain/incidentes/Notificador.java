package ar.edu.utn.frba.dds.domain.incidentes;

import ar.edu.utn.frba.dds.domain.comunidades.Comunidad;
import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.incidentes.mensajes.Mensaje;
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
}
