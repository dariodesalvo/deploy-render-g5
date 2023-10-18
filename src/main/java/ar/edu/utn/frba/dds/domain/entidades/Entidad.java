package ar.edu.utn.frba.dds.domain.entidades;

import ar.edu.utn.frba.dds.domain.comunidades.Prestador;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Entidad")
public class Entidad  {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "leyenda")
    public String leyenda;
    @OneToMany(mappedBy = "entidad")
    public List<Establecimiento> establecimientos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "prestador_id", referencedColumnName = "id")
    protected Prestador prestador;

    public Entidad(){

    }

    public List<Incidente> listarIncidentes(LocalDateTime desde, LocalDateTime hasta) {
        //query de incidentes de esa entidad
        return null;
    }

}
