package ar.edu.utn.frba.dds.models.incidentes.mensajes;

import ar.edu.utn.frba.dds.models.incidentes.Incidente;

public class CierreIncidente implements Mensaje {

    public CierreIncidente(){

    }

    public String contenido(Incidente incidente){

        return "Se cerró el incidente en el servicio"+incidente.getServicio()+"a las "
                +incidente.getFechaCierre()+" con las siguientes observaciones: "+incidente.getObservaciones();

    }
}
