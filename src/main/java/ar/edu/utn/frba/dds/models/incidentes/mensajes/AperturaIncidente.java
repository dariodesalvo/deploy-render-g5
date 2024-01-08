package ar.edu.utn.frba.dds.models.incidentes.mensajes;

import ar.edu.utn.frba.dds.models.incidentes.Incidente;

public class AperturaIncidente implements Mensaje {

    public AperturaIncidente(){

    }

    public String contenido(Incidente incidente){

        return "Se abrió un incidente en el servicio"+incidente.getServicio()+"a las "
                +incidente.getFechaApertura()+" con las siguientes observaciones: "+incidente.getObservacionesApertura();

    }

}
