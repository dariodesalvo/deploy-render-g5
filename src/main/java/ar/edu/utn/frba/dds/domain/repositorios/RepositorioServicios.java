package ar.edu.utn.frba.dds.domain.repositorios;

import ar.edu.utn.frba.dds.domain.georef.GeorefService;
import ar.edu.utn.frba.dds.domain.georef.ServicioGeoref;
import ar.edu.utn.frba.dds.domain.georef.entities.ListadoDeMunicipios;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RepositorioServicios {
    public static List<Servicio> servicios = new ArrayList<>();

    public static void agregarServicio(Servicio servicio){
        servicios.add(servicio);
    }

    public static void crearServicio(List<CSVRecord> lectura) throws IOException {
        for(int i = 0;i<lectura.size();i++){

            int codigoServico = Integer.parseInt(lectura.get(i).get("Codigo Servicio"));
            String nombreServicio = lectura.get(i).get("Nombre Servicio");
            String municipio = lectura.get(i).get("Municipio");
            String esServicioDeElvacion = lectura.get(i).get("Es de elevacion").toLowerCase();
            String elServicioEstaActivo = lectura.get(i).get("Esta Activo");
            Boolean esDeElvacion = esServicioDeElvacion.contains("si") ? true : false;
            Boolean estaActivo = elServicioEstaActivo.contains("si") ? true : false;

            ListadoDeMunicipios municipios = ServicioGeoref.getInstancia().listadoDeMunicipiosPorNombre(municipio);

            Municipio ubicacionDelServicio = new Municipio();
            for(Municipio mun: municipios.municipios) {
                if(mun.nombre == municipio) {
                    ubicacionDelServicio = new Municipio(mun.id, mun.nombre, mun.centroide);
                }
            }
            Servicio nuevoServicio = new Servicio(codigoServico,nombreServicio,ubicacionDelServicio,esDeElvacion,estaActivo);
            agregarServicio(nuevoServicio);
        }

    }
}
