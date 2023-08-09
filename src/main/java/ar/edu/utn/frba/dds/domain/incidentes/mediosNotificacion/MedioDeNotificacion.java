package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion;

import org.apache.commons.mail.EmailException;

public interface MedioDeNotificacion {
    void enviarNotificacion() throws EmailException;
}
