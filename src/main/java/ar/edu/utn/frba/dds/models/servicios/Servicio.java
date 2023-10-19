package ar.edu.utn.frba.dds.models.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.dds.models.entidades.Empresa;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.georef.entities.Municipio;
import ar.edu.utn.frba.dds.models.georef.entities.Ubicacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Servicio")
public class Servicio {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  @Column(name = "codigoServicio")
  private int codigoServicio;
  @Column(name = "nombre")
  private String nombre;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ubicacion_id")
  private Ubicacion ubicacion;

  //ver forma de persistir consultar si es necesario
  @Transient
  private List<Municipio> tramos = new ArrayList<Municipio>();

  @Column(name = "esDeElevacion")
  private boolean esDeElevacion;
  @Column(name = "estaActivo")
  private boolean estaActivo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="empresa_id", nullable=false)
  private Empresa empresa;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="establecimiento_id", nullable=false)
  private Establecimiento establecimiento;


  public Servicio() {
  }

  public Servicio(int codigoServicio, String nombre, Ubicacion ubicacion, boolean esDeElevacion, boolean estaActivo) {
    this.codigoServicio = codigoServicio;
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.esDeElevacion = esDeElevacion;
    this.estaActivo = estaActivo;
  }

}
