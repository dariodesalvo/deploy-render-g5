package ar.edu.utn.frba.dds.domain.externo;

import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.externo.ExternoResponse;
import ar.edu.utn.frba.dds.server.externo.ServicioExterno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicioExternoTest {

    ServicioExterno servicioExterno = new ServicioExterno();
    @Test
    @DisplayName("Se prueb integracion con servicio externo")
    public void consumirServicioExterno() throws Exception {
        ServicioExterno instancia = servicioExterno.getInstancia();
        ExternoResponse response = instancia.llamado();
        Assertions.assertFalse(response.getEntidades().isEmpty());

    }


}
