package ar.edu.utn.frba.dds.domain.georef.entities;

import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue
    public int id;
    @Column(name = "lat")
    public float lat;
    @Column(name = "lon")
    public float lon;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="centroide_id", nullable=false)
    private Centroide centroide;
}