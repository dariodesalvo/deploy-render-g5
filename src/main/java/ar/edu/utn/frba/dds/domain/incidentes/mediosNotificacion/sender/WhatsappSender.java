package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter.WhatsappAdapter;

public class WhatsappSender implements MedioDeNotificacion {

    WhatsappAdapter whatsappAdapter;

    public WhatsappSender(WhatsappAdapter whatsappAdapter){
        this.whatsappAdapter = whatsappAdapter;
    }

    @Override
    public void enviarNotificacion(Miembro miembro) {
        whatsappAdapter.enviarNotificacion(miembro);
    }
}
