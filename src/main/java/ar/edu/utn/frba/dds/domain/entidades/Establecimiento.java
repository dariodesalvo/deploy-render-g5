package ar.edu.utn.frba.dds.domain.entidades;

import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import ar.edu.utn.frba.dds.domain.georef.entities.Ubicacion;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "establecimiento")
public abstract class Establecimiento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "leyenda")
    protected String leyenda;

    @ManyToOne
    @JoinColumn(name = "entidad_id", referencedColumnName = "id")
    protected Entidad entidad;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubicacion_id")
    protected Ubicacion ubicacion_id;

    @OneToMany(mappedBy = "establecimiento")
    protected List<Servicio> servicios;

    public Establecimiento(){

    }
    public void agregarServicio(Servicio servicio) throws Exception {
        this.validarRepetido(servicio);
        servicios.add(servicio);
    }

    public void eliminarServicio(Servicio servicio) throws Exception {
        this.validarServicioExistente(servicio);
        servicios.remove(servicio);
    }

    public void validarRepetido(Servicio servicio) throws Exception {
        if(servicios.contains(servicio)){
            throw new Exception("El servicio ya fue dado de alta");
        }
    }

    public void validarServicioExistente(Servicio servicio) throws Exception {
        if(!servicios.contains(servicio)){
            throw new Exception("No se encuentra el servicio que se quiere dar de baja");
        }
    }
}
