package ar.edu.utn.frba.dds.domain.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.dds.domain.entidades.Empresa;
import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;
import ar.edu.utn.frba.dds.domain.georef.entities.Municipio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Servicio")
public class Servicio {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "codigoServicio")
  private int codigoServicio;
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "ubicacion")
  private Municipio ubicacion;

  //ver forma de persistir consultar si es necesario
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

  public Servicio(int codigoServicio, String nombre, Municipio ubicacion, boolean esDeElevacion, boolean estaActivo) {
    this.codigoServicio = codigoServicio;
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.esDeElevacion = esDeElevacion;
    this.estaActivo = estaActivo;
  }

}
