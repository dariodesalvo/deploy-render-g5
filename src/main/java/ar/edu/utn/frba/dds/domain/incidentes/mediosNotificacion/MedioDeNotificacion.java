package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import org.apache.commons.mail.EmailException;

public interface MedioDeNotificacion {
    void enviarNotificacion(Miembro miembro) throws EmailException;
}
