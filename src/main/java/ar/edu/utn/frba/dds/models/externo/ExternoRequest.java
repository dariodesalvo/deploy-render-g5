package ar.edu.utn.frba.dds.models.externo;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class ExternoRequest {
    private List<EntidadDTO> entidades;
}
