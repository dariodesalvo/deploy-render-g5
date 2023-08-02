package ar.edu.utn.frba.dds.domain.entidades;

import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class Establecimiento {
    private String leyenda;
    private Municipio localizacion;
    private List<Servicio> servicios;

    public Establecimiento(String leyenda, List<Servicio> servicios) {
        this.leyenda = leyenda;
        this.servicios = servicios;
    }

    public Establecimiento(String leyenda, Municipio localizacion, List<Servicio> servicios) {
        this.leyenda = leyenda;
        this.localizacion = localizacion;
        this.servicios = servicios;
    }
}
