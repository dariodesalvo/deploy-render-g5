package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter.AdapterCelular;

import javax.persistence.*;

@Entity
@Table(name = "WhatsappSender")
public class WhatsappSender implements MedioDeNotificacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Transient
    AdapterCelular whatsappAdapter;

    public WhatsappSender(){

    }

    public WhatsappSender(AdapterCelular whatsappAdapter){
        this.whatsappAdapter = whatsappAdapter;
    }

    @Override
    public void enviarNotificacion(Miembro miembro, String notificacion) {
        whatsappAdapter.enviarNotificacion(miembro, notificacion);
    }
}
