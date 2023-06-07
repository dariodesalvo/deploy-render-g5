package ar.edu.utn.frba.dds.domain.repositorios;

import ar.edu.utn.frba.dds.domain.entidades.Empresa;
import ar.edu.utn.frba.dds.domain.georef.ServicioGeoref;
import ar.edu.utn.frba.dds.domain.georef.entities.ListadoDeMunicipios;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class RepositorioEmpresas{
        public static List<Empresa> empresas = new ArrayList<Empresa>();
        public static void agregarEmpresa(Empresa empresa){
            empresas.add(empresa);
        }

        public static void crearEmpresa (List<CSVRecord> lectura){
            for(int i = 0;i<lectura.size();i++){
                int codigoEmpresa = Integer.parseInt(lectura.get(i).get("Codigo Empresa"));
                String nombreEmpresa = lectura.get(i).get("Nombre Empresa");
                String usuarioResponsable = lectura.get(i).get("Usuario Responsable");

                Empresa nuevaEmpresa = new Empresa(codigoEmpresa,nombreEmpresa,usuarioResponsable);
                agregarEmpresa(nuevaEmpresa);
            }
        }
}
