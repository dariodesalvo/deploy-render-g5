package ar.edu.utn.frba.dds.models.converters;

import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.sender.EmailSender;
import ar.edu.utn.frba.dds.models.incidentes.mediosNotificacion.sender.WhatsappSender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class MedioDeNotificacionAttributeConverter implements AttributeConverter<MedioDeNotificacion, String> {
    @Override
    public String convertToDatabaseColumn(MedioDeNotificacion medioDeNotificacion) {
        String nombreDelMedio = "";

        switch (medioDeNotificacion.getClass().getSimpleName()) {
        case "WhatsappSender": nombreDelMedio = "wpp"; break;
        case "EmailSender": nombreDelMedio = "email"; break;
        default: nombreDelMedio = "desconocido"; break;
        }
        return nombreDelMedio;
        }
    @Override
    public MedioDeNotificacion convertToEntityAttribute(String s) {
        MedioDeNotificacion medio = null;

        if(Objects.equals(s, "wpp"))
        medio = new WhatsappSender();

        if(Objects.equals(s, "email"))
        medio = new EmailSender();

        return medio;
    }
}
