package ar.edu.utn.frba.dds.domain.georef.entities;

import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "centroide")
public class Centroide {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    @Column(name = "lat")
    public float lat;
    @Column(name = "lon")
    public float lon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="municipio_id", nullable=false)
    private Municipio municipio;
}
