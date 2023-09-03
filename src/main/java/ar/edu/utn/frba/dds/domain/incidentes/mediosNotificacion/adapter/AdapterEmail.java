package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import org.apache.commons.mail.EmailException;

public interface AdapterEmail {

    void enviarNotificacion(Miembro miembro, String notificacio) throws EmailException;
}
