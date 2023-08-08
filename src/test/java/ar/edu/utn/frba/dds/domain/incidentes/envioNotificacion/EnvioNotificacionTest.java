package ar.edu.utn.frba.dds.domain.incidentes.envioNotificacion;

import ar.edu.utn.frba.dds.domain.comunidades.Comunidad;
import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.Email;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioNotificable;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.Whatsapp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class EnvioNotificacionTest {
    private Usuario caro = new Usuario("rinaldicarolina@hotmail.com","Carolina1*" );
    private Miembro miembro = new Miembro("Carolina", "Rinaldi");
    private Miembro miembro2 = new Miembro("Caro","R");
    private Comunidad comunidad = new Comunidad("PMR");




    public EnvioNotificacionTest() throws Exception {
    }

    @BeforeEach
    public void inicializar() throws Exception {
        caro.setRol(miembro2);

        miembro.setCelular("+5491121754632");
        miembro.setMedioComunicacionPreferido(new Whatsapp(miembro.getCelular()));
       // miembro2.setEmail("rinaldicarolina@hotmail.com");
        miembro2.setMedioComunicacionPreferido(new Email(caro.getEmail()));
        comunidad.agregarMiembro(miembro);
        comunidad.agregarMiembro(miembro2);


    }

    @Test
    @DisplayName("Se envia notificacion por whatsapp a miembro")
    public void enviarWhatsapp() throws EmailException {

        Whatsapp medio = mock(Whatsapp.class);
        doNothing().when(medio).enviarNotificacion();
        miembro.getMedioComunicacionPreferido().enviarNotificacion();
        verify(medio, Mockito.times(1)).enviarNotificacion();

    }

    @Test
    @DisplayName("Se envia notificacion por email a miembro")
    public void enviarCorreo() throws EmailException {
        miembro2.getMedioComunicacionPreferido().enviarNotificacion();

    }

    @Test
    @DisplayName("Se envia notificacion a 2 miembros con distintos Medios de Comunicacion")
    public void enviarNotificacionesAComunidad() throws EmailException {
        for (Miembro unMiembro:comunidad.getMiembros()) {
            unMiembro.getMedioComunicacionPreferido().enviarNotificacion();
        }
    }

}
