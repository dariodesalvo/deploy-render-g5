package ar.edu.utn.frba.dds.server.externo;

import ar.edu.utn.frba.dds.models.externo.ExternoResponse;
import retrofit2.Call;
import retrofit2.http.POST;

public interface ServicioExternoService {
    @POST("nombre")
    Call<ExternoResponse> llamado();
}
