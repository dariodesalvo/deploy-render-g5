package ar.edu.utn.frba.dds.domain.servicios;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Servicio {
    private String nombre;
    private Ubicacion ubicacion;
    private List<Ubicacion> tramos;
    private boolean esDeElevacion;
}
