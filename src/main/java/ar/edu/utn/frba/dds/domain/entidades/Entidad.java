package ar.edu.utn.frba.dds.domain.entidades;

import ar.edu.utn.frba.dds.domain.incidentes.Incidente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Entidad  {
    public String leyenda;
    public List<Establecimiento> establecimientos = new ArrayList<>();

    public List<Incidente> listarIncidentes(LocalDateTime desde, LocalDateTime hasta) {
        return null;
    }

}
