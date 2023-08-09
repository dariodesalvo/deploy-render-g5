package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.whatsapp;

import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import org.apache.commons.mail.EmailException;

public class NotificarPorWhatsapp implements MedioDeNotificacion {
    private AdapterNotificadorWhatsapp adapterNotificadorWhatsapp;
    @Override
    public void enviarNotificacion() throws EmailException {

    }
}
