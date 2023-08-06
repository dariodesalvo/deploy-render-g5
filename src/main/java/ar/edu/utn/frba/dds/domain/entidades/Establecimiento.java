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
public abstract class Establecimiento {
    protected String leyenda;
    protected Municipio localizacion;
    protected List<Servicio> servicios;


    public void agregarServicio(Servicio servicio) throws Exception {
        this.validarRepetido(servicio);
        servicios.add(servicio);
    }

    public void eliminarServicio(Servicio servicio) throws Exception {
        this.validarServicioExistente(servicio);
        servicios.remove(servicio);
    }

    public void validarRepetido(Servicio servicio) throws Exception {
        if(servicios.contains(servicio)){
            throw new Exception("El servicio ya fue dado de alta");
        }
    }

    public void validarServicioExistente(Servicio servicio) throws Exception {
        if(!servicios.contains(servicio)){
            throw new Exception("No se encuentra el servicio que se quiere dar de baja");
        }
    }
}
