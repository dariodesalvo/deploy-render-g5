package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.whatsapp;

import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

public class AdapterWhatsappTwilio implements MedioDeNotificacion {
    public static final String ACCOUNT_SID = "ACc49f7903c1b37d8b1d9bac8c159a6556";
    public static final String AUTH_TOKEN = "5d2173fadc66313c5a05a4e6b6721f3f";
    public static final String MY_SENDER_NUMBER = "+14155238886";

    @Getter @Setter
    private String celularMiembro;

    public AdapterWhatsappTwilio(String celular) {
        this.celularMiembro = celular;
    }


    @Override
    public void enviarNotificacion() {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber("whatsapp:"+this.celularMiembro),
                        new PhoneNumber("whatsapp:"+MY_SENDER_NUMBER),
                        "probando envio de whatsaspp con twilio\n")
                .create();



        System.out.println("notificacion por whatsapp enviada a :" + celularMiembro);
    }
}

/*
 *Send a WhatsApp message
 *Use WhatsApp and send a message from your device to
 *WhatsApp logo+1 415 523 8886
 *with code join individual-lungs
 **/