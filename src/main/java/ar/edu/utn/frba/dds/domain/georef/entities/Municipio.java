package ar.edu.utn.frba.dds.domain.georef.entities;

import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue
    public int id;

    @Column(name = "nombre")
    public String nombre;
    @OneToOne(mappedBy = "municipio")
    public Centroide centroide;

    public Municipio() {
    }

    public Municipio(int id, String nombre, Centroide centroide) {
        this.id = id;
        this.nombre = nombre;
        this.centroide = centroide;
    }

    public Municipio(int id) {
        this.id = id;
    }
}
