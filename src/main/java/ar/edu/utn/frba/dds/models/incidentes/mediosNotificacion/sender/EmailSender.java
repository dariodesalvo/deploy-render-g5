package ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.sender;

import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.adapter.AdapterEmail;
import org.apache.commons.mail.EmailException;

import javax.persistence.*;

@Entity
@Table(name = "EmailSender")
public class EmailSender implements MedioDeNotificacion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Transient
    AdapterEmail emailAdapater;

    public EmailSender(){

    }

    public EmailSender(AdapterEmail emailAdapater){
        this.emailAdapater = emailAdapater;
    }
    @Override
    public void enviarNotificacion(Miembro miembro, String notificacion) throws EmailException {
        emailAdapater.enviarNotificacion(miembro, notificacion);
    }
}
