package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion;

import org.apache.commons.mail.EmailException;

public interface MedioNotificable {
    void enviarNotificacion() throws EmailException;
}
