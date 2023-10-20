package ar.edu.utn.frba.dds.models.externo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EntidadDTO {
    private String codigo;
    private List<IncidenteDTO> incidentes;
}
