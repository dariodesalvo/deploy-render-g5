package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.entidades.Estacion;
import ar.edu.utn.frba.dds.domain.entidades.MedioDeTransporte;
import ar.edu.utn.frba.dds.domain.entidades.Linea;
import ar.edu.utn.frba.dds.domain.entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Prestador")
public class Prestador extends RolesUsuario {

    @OneToMany(mappedBy = "prestador")
    private List<Entidad> entidades = new ArrayList<>();

    public void altaEntidad(Entidad entidad) {
        entidades.add(entidad);
    }

    public void bajaEntidad(Entidad entidad) {
        entidades.remove(entidad);
    }

    public void editarLeyendaEntidad(Entidad entidad, String nombre) {
        entidad.setLeyenda(nombre);
    }

}
