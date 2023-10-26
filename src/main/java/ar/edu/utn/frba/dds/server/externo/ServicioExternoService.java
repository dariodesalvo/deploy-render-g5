package ar.edu.utn.frba.dds.server.externo;

import ar.edu.utn.frba.dds.models.externo.ExternoRequest;
import ar.edu.utn.frba.dds.models.externo.ExternoResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioExternoService {
    @POST("entidades")
    Call<ExternoResponse> llamado(@Path("request") ExternoRequest request);
}
