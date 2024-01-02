package ar.edu.utn.frba.dds.server.externo;

import ar.edu.utn.frba.dds.serviceIntegration.servicio3.entities.ExternoRequest;
import ar.edu.utn.frba.dds.serviceIntegration.servicio3.entities.ExternoResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioExterno {
    private static final String urlAPI = "";
    private Retrofit retrofit;
    private static ServicioExterno instancia = null;


    public ServicioExterno(){
        this.retrofit = new Retrofit.Builder().baseUrl(urlAPI).
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ServicioExterno getInstancia(){
        if(instancia == null){
            instancia = new ServicioExterno();
        }
        return instancia;
    }

    public ExternoResponse llamado(ExternoRequest request) throws IOException {
        ServicioExternoService service = this.retrofit.create(ServicioExternoService.class);
        Call<ExternoResponse> responseCall = service.llamado(request);
        Response<ExternoResponse> response = responseCall.execute();
        return response.body();
    }

}
