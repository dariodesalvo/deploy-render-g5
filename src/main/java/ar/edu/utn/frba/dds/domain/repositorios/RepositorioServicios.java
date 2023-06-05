package ar.edu.utn.frba.dds.domain.repositorios;

import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RepositorioServicios {
    private static List<Servicio> servicios = new ArrayList<>();

    public static void agregarServicio(Servicio servicio){
        servicios.add(servicio);
    }
}
