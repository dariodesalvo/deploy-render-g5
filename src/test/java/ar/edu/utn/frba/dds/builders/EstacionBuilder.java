package ar.edu.utn.frba.dds.builders;


public class EstacionBuilder {
    CentroideBuilder centroideBuilder;

    public EstacionBuilder(CentroideBuilder centroideBuilder){
        this.centroideBuilder = centroideBuilder;
    }

   /* public Estacion buildEstacionSinServicios(String nombre, Float latitud, Float longitud){
        Estacion nuevaEstacion = new Estacion();
        nuevaEstacion.setLeyenda(nombre);
        nuevaEstacion.setLocalizacion(new Municipio(60455,"Las Flores", centroideBuilder.buildCentroide(latitud, longitud)));
        nuevaEstacion.setServicios(new ArrayList<>());
        return nuevaEstacion;
    }*/
}
