package ar.edu.utn.frba.dds.domain.rankings;

import ar.edu.utn.frba.dds.domain.entidades.Entidad;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;

import java.util.List;

public interface IRankeable {
    Ranking rankear(List<Entidad> entidad);
}
