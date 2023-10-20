package ar.edu.utn.frba.dds.models.repositorios;

import ar.edu.utn.frba.dds.models.entidades.Empresa;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
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

        public static void crearEmpresa (List<CSVRecord> lectura, List<Servicio> nuevosServicios){
            for(int i = 0;i<lectura.size();i++){
                int codigoEmpresa = Integer.parseInt(lectura.get(i).get("Codigo Empresa"));
                String nombreEmpresa = lectura.get(i).get("Nombre Empresa");
                String usuarioResponsable = lectura.get(i).get("Usuario Responsable");

                Empresa nuevaEmpresa = new Empresa(codigoEmpresa,nombreEmpresa,usuarioResponsable);
                Servicio servicioDeLaEmpresa = nuevosServicios.get(i);
                nuevaEmpresa.darServicioDeAlta(servicioDeLaEmpresa);
                agregarEmpresa(nuevaEmpresa);
            }
        }
}