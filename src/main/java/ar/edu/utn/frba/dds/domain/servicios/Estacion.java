package ar.edu.utn.frba.dds.domain.servicios;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Estacion {
    private String nombre;
    private Ubicacion ubicacion;
    private List<Servicio> servicios;
}
