package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.entidades.Estacion;
import ar.edu.utn.frba.dds.domain.entidades.MedioDeTransporte;
import ar.edu.utn.frba.dds.domain.entidades.Linea;
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

    public void editarLeyendaServicioPublico(Linea linea, String nombre) {
        linea.setLeyenda(nombre);
    }

    public void editarMedioDeTransporteServicioPublico(Linea linea, MedioDeTransporte medio) {
        linea.setMedioDeTransporte(medio);
    }

    public void agregarEstacionServicioPublico(Linea linea, Estacion estacion) {
        linea.agregarEstacion(estacion);
    }

    public void eliminarEstacionServicioPublico(Linea linea, Estacion estacion) {
        linea.eliminarEstacion(estacion);
    }

}
