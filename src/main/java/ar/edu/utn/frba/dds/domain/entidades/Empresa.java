package ar.edu.utn.frba.dds.domain.entidades;

import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Empresa {
    private int codigoEmpresa;
    private String nombreEmpresa;
    private String usuarioResponsable;
    private List<Servicio> serviciosQuePresta = new ArrayList<Servicio>();

    public Empresa(int codigoEmpresa, String nombreEmpresa, String usuarioResponsable) {
        this.codigoEmpresa = codigoEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.usuarioResponsable = usuarioResponsable;
    }
    public void darServicioDeAlta(Servicio nuevoServicio){
        this.serviciosQuePresta.add(nuevoServicio);
    }
}
