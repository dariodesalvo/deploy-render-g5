package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.servicios.Estacion;
import ar.edu.utn.frba.dds.domain.servicios.MedioDeTransporte;
import ar.edu.utn.frba.dds.domain.servicios.Linea;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Prestador extends RolesUsuario {

    private List<Linea> serviciosPublicos = new ArrayList<>();

    public void altaServicioPublico(Linea linea) {
        serviciosPublicos.add(linea);
    }

    public void bajaServicioPublico(Linea linea) {
        serviciosPublicos.remove(linea);
    }

    public void editarNombreServicioPublico(Linea linea, String nombre) {
        linea.setNombre(nombre);
    }

    public void editarMedioDeTransporteServicioPublico(Linea linea, MedioDeTransporte medio) {
        linea.setMedioDeTransporte(medio);
    }

    public void editarEstacionOrigenServicioPublico(Linea linea, Estacion estacion) {
        linea.setEstacionOrigen(estacion);
    }

    public void editarEstacionDestinoServicioPublico(Linea linea, Estacion estacion) {
        linea.setEstacionDestino(estacion);
    }

    public void agregarEstacionServicioPublico(Linea linea, Estacion estacion) {
        linea.agregarEstacion(estacion);
    }

    public void eliminarEstacionServicioPublico(Linea linea, Estacion estacion) {
        linea.eliminarEstacion(estacion);
    }

}
