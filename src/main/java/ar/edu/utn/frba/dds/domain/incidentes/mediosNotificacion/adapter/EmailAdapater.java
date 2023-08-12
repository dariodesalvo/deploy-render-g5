package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import org.apache.commons.mail.EmailException;

public interface EmailAdapater {

    void enviarNotificacion(Miembro miembro) throws EmailException;
}
