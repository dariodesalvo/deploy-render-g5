package ar.edu.utn.frba.dds.server.externo;

import ar.edu.utn.frba.dds.models.entidades.Entidad;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.externo.EntidadDTO;
import ar.edu.utn.frba.dds.models.externo.ExternoRequest;
import ar.edu.utn.frba.dds.models.externo.ExternoResponse;
import ar.edu.utn.frba.dds.models.externo.IncidenteDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
