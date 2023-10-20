package ar.edu.utn.frba.dds.models.externo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidenteDTO {
    private Integer tiempoRespuesta;
    private Boolean estaResuelto;
    private Integer miembrosAfectados;
}
