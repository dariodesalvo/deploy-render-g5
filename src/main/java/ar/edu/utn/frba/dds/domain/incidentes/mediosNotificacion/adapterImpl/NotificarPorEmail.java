package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapterImpl;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter.AdapterEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class NotificarPorEmail implements AdapterEmail {
    public static final String MY_SENDER_EMAIL = "carorinaldi10@gmail.com";
    public static final String PASS = "rpclpatskhtmqppv";

    @Override
    public void enviarNotificacion(Miembro miembro, String notificacion) throws EmailException {
        org.apache.commons.mail.Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(MY_SENDER_EMAIL, PASS));
        email.setSSLOnConnect(true);
        email.setFrom(MY_SENDER_EMAIL);
        email.setSubject("TestMail");
        email.setMsg(notificacion);
        email.addTo(miembro.getEmail());
        email.send();

        System.out.println("notificacion por correo enviada a :" + miembro.getEmail());

    }
}