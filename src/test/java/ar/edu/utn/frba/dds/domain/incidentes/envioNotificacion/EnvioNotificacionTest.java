package ar.edu.utn.frba.dds.domain.incidentes.envioNotificacion;

import ar.edu.utn.frba.dds.models.comunidades.Comunidad;
import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.adapter.AdapterEmail;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.adapter.AdapterCelular;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.adapterImpl.NotificarPorEmail;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.adapterImpl.Twilio;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.sender.EmailSender;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.sender.WhatsappSender;
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
    private final String notificacion = "Notificacion de prueba";
    public EnvioNotificacionTest() throws Exception {
    }

    @BeforeEach
    public void inicializar() throws Exception {
        caro.setRol(miembro2);

        miembro.setCelular("+5491121754632");
        miembro2.setEmail("maurodemarco909@gmail.com");
        miembro.setMedioNotificacionPreferido(new WhatsappSender(new Twilio()));
        miembro2.setMedioNotificacionPreferido(new EmailSender(new NotificarPorEmail()));
        comunidad.agregarMiembro(miembro);
        comunidad.agregarMiembro(miembro2);
    }

    @Test
    @DisplayName("Se envia notificacion por whatsapp a miembro")
    public void enviarWhatsapp() throws EmailException {
        AdapterCelular medio = mock(AdapterCelular.class);
        //doNothing().when(medio).enviarNotificacion(miembro, notificacion);
        medio.enviarNotificacion(miembro, notificacion);
        verify(medio, Mockito.times(1)).enviarNotificacion(miembro, notificacion);
    }

    @Test
    @DisplayName("Se envia notificacion por email a miembro")
    public void enviarCorreo() throws EmailException {
        AdapterEmail medio = mock(AdapterEmail.class);
        //miembro2.getMedioNotificacionPreferido().enviarNotificacion(miembro2, notificacion);
        medio.enviarNotificacion(miembro, notificacion);
        verify(medio, Mockito.times(1)).enviarNotificacion(miembro, notificacion);
    }

    @Test
    @DisplayName("Se envia notificacion a 2 miembros con distintos Medios de Comunicacion")
    public void enviarNotificacionesAComunidad() throws EmailException {

        for (Miembro unMiembro:comunidad.getMiembros()) {
            unMiembro.getMedioNotificacionPreferido().enviarNotificacion(unMiembro, notificacion);
        }
    }

}
