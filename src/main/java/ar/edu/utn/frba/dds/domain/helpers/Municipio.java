package ar.edu.utn.frba.dds.domain.helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Municipio {
    public String nombre;
    public Ubicacion ubicacion;


public Municipio(String nombre, Ubicacion ubicacion){
    this.nombre=nombre;
    this.ubicacion=ubicacion;
}

}
