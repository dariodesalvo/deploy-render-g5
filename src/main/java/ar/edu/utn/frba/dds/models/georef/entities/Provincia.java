package ar.edu.utn.frba.dds.models.georef.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    @Column(name = "nombre")
    public String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "centroide_id")
    public Centroide centroide;

    public Provincia(){}

}
