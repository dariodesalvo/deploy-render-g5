package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter.AdapterCelular;

public class WhatsappSender implements MedioDeNotificacion {

    AdapterCelular whatsappAdapter;

    public WhatsappSender(AdapterCelular whatsappAdapter){
        this.whatsappAdapter = whatsappAdapter;
    }

    @Override
    public void enviarNotificacion(Miembro miembro, String notificacion) {
        whatsappAdapter.enviarNotificacion(miembro, notificacion);
    }
}
