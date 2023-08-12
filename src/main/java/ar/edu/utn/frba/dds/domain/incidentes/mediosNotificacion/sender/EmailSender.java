package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter.EmailAdapater;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter.WhatsappAdapter;
import org.apache.commons.mail.EmailException;

public class EmailSender implements MedioDeNotificacion {

    EmailAdapater emailAdapater;

    public EmailSender(EmailAdapater emailAdapater){
        this.emailAdapater = emailAdapater;
    }
    @Override
    public void enviarNotificacion(Miembro miembro) throws EmailException {
        emailAdapater.enviarNotificacion(miembro);
    }
}
