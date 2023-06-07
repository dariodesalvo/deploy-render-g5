package ar.edu.utn.frba.dds.domain.repositorios;

import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class RepositorioEmpresas{
        private static List<Servicio> empresas = new ArrayList<>();
        public static void agregarEmpresa(Servicio servicio){
            empresas.add(servicio);
        }

        public void crearEmpresa (){}
}
