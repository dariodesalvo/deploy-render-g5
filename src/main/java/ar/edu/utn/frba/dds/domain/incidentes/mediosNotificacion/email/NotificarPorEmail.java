package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.email;

import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class NotificarPorEmail implements MedioDeNotificacion {
    public static final String MY_SENDER_EMAIL = "carorinaldi10@gmail.com";
    public static final String PASS = "rpclpatskhtmqppv";
    @Getter @Setter
    private String emailMiembro;

    public NotificarPorEmail(String emailMiembro) {
        this.emailMiembro = emailMiembro;
    }

    @Override
    public void enviarNotificacion() throws EmailException {
        org.apache.commons.mail.Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(MY_SENDER_EMAIL, PASS));
        email.setSSLOnConnect(true);
        email.setFrom(MY_SENDER_EMAIL);
        email.setSubject("TestMail");
        email.setMsg("This is a test mail con info de objeto... :-)");
        email.addTo(this.emailMiembro);
        email.send();

        System.out.println("notificacion por correo enviada a :" + this.emailMiembro);

    }
}
