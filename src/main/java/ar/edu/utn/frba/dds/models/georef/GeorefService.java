package ar.edu.utn.frba.dds.models.georef;


import ar.edu.utn.frba.dds.models.georef.entities.ListadoDeMunicipios;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeorefService {
    //solamente tenemos q modelar la ruta relativa, la absoluta va en otra parte
    @GET("municipios")
    Call<ListadoDeMunicipios> municipios();

    @GET("municipios")
    Call<ListadoDeMunicipios> municipios(@Query("nombre") String nombre);

    @GET("municipios")
    Call<ListadoDeMunicipios> municipios(@Query("id") int id);

    @GET("municipios")
    Call<ListadoDeMunicipios> municipios(@Query("provincia") int idProvincia, @Query("campos") String campos, @Query("max") int max);
}
