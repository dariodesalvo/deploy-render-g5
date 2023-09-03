package ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapter;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;

public interface AdapterCelular {

    void enviarNotificacion(Miembro miembro, String notificacion);

}
