package ar.edu.utn.frba.dds.server.externo;

import ar.edu.utn.frba.dds.serviceIntegration.servicio3.entities.ExternoRequest;
import ar.edu.utn.frba.dds.serviceIntegration.servicio3.entities.ExternoResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServicioExternoService {
    @POST("entidades")
    Call<ExternoResponse> llamado(@Path("request") ExternoRequest request);
}
