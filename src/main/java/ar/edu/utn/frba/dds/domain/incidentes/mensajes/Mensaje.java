package ar.edu.utn.frba.dds.domain.incidentes.mensajes;

import ar.edu.utn.frba.dds.domain.incidentes.Incidente;

public interface Mensaje {
    public String contenido(Incidente incidente);
}
