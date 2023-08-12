package ar.edu.utn.frba.dds.domain.incidentes.envioNotificacion;

import ar.edu.utn.frba.dds.domain.comunidades.Comunidad;
import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter.WhatsappAdapter;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapterImpl.NotificarPorEmail;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapterImpl.AdapterWhatsappTwilio;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender.EmailSender;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender.WhatsappSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class EnvioNotificacionTest {
    private final Usuario caro = new Usuario("rinaldicarolina@hotmail.com","Carolina1*" );
    private final Miembro miembro = new Miembro("Carolina", "Rinaldi");
    private final Miembro miembro2 = new Miembro("Caro","R");
    private final Comunidad comunidad = new Comunidad("PMR");

    public EnvioNotificacionTest() throws Exception {
    }

    @BeforeEach
    public void inicializar() throws Exception {
        caro.setRol(miembro2);

        miembro.setCelular("+5491121754632");
        miembro2.setEmail("maurodemarco909@gmail.com");
        miembro.setMedioNotificacionPreferido(new WhatsappSender(new AdapterWhatsappTwilio()));
        miembro2.setMedioNotificacionPreferido(new EmailSender(new NotificarPorEmail()));
        comunidad.agregarMiembro(miembro);
        comunidad.agregarMiembro(miembro2);

    }

    @Test
    @DisplayName("Se envia notificacion por whatsapp a miembro")
    public void enviarWhatsapp() throws EmailException {

        WhatsappAdapter medio = mock(WhatsappAdapter.class);
        Twilio twilio = mock(Twilio.class);
        Message message = mock(Message.class);
        doNothing().when(twilio).init("ACc49f7903c1b37d8b1d9bac8c159a6556","5d2173fadc66313c5a05a4e6b6721f3f");
        doNothing().when(message).creator(new PhoneNumber("whatsapp:"+miembro.getCelular()),
                new PhoneNumber("whatsapp:"+"+14155238886"),
                "probando envio de whatsaspp con twilio\n");
        doNothing().when(medio).enviarNotificacion(miembro);
        miembro.getMedioNotificacionPreferido().enviarNotificacion(miembro);
        verify(medio, Mockito.times(1)).enviarNotificacion(miembro);
    }

    @Test
    @DisplayName("Se envia notificacion por email a miembro")
    public void enviarCorreo() throws EmailException {
        miembro2.getMedioNotificacionPreferido().enviarNotificacion(miembro2);

    }

    @Test
    @DisplayName("Se envia notificacion a 2 miembros con distintos Medios de Comunicacion")
    public void enviarNotificacionesAComunidad() throws EmailException {
        for (Miembro unMiembro:comunidad.getMiembros()) {
            unMiembro.getMedioNotificacionPreferido().enviarNotificacion(unMiembro);
        }
    }

}
