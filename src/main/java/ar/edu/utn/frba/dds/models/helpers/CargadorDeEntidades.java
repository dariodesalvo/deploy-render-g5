package ar.edu.utn.frba.dds.models.helpers;

import ar.edu.utn.frba.dds.models.entidades.Empresa;
import ar.edu.utn.frba.dds.models.entidades.Entidad;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.georef.entities.Centroide;
import ar.edu.utn.frba.dds.models.georef.entities.Ubicacion;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEmpresas;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEntidades;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEstablecimientos;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeServicios;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
import java.io.IOException;
import java.util.List;

public class CargadorDeEntidades {

    private static RepositorioDeEmpresas repositorioDeEmpresas = new RepositorioDeEmpresas();
    private static RepositorioDeServicios repositorioDeServicios = new RepositorioDeServicios();
    private static RepositorioDeEntidades repositorioDeEntidades = new RepositorioDeEntidades();
    private static RepositorioDeEstablecimientos repositorioDeEstablecimientos =new RepositorioDeEstablecimientos();

    public static void cargarEntidades( List<String> lecturaCsv) throws IOException {
        Object factory = null;
        for(int i = 0;i < lecturaCsv.size();i++){
            String [] val = lecturaCsv.get(i).split(";");

            Integer codigoEmpresa = Integer.parseInt(val[0]);
            String nombreEmpresa = val[1];
            String usuarioResponsable = val[2];

            Empresa nuevaEmpresa = new Empresa(codigoEmpresa,nombreEmpresa,usuarioResponsable);

            repositorioDeEmpresas.guardar(nuevaEmpresa);

            Integer codigoServicio =Integer.parseInt(val[3]);
            String nombreServicio = val[4];
            String municipio = val[5];
            Float latitud = Float.parseFloat(val[8]);
            Float longitud = Float.parseFloat(val[9]);

            Ubicacion ubicacionDelServicio = new Ubicacion(latitud,longitud);

            Boolean esDeElvacion = BooleanConverter.StringToBooleanConverter((val[6]));
            Boolean estaActivo = BooleanConverter.StringToBooleanConverter((val[7]));
            String leyenda = val[10];

            Establecimiento establecimiento = new Establecimiento();
            Servicio nuevoServicio = new Servicio(codigoServicio,nombreServicio,esDeElvacion,estaActivo,establecimiento);

            Entidad entidad = new Entidad();
            entidad.setLeyenda(leyenda);
            establecimiento.setLeyenda(leyenda);

            repositorioDeEntidades.guardar(new Entidad());
            repositorioDeEstablecimientos.guardar(establecimiento);
            repositorioDeServicios.guardar(nuevoServicio);

        }
    }
}
