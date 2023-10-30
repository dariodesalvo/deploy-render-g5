package ar.edu.utn.frba.dds.domain.externo;

import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.externo.EntidadDTO;
import ar.edu.utn.frba.dds.models.externo.ExternoRequest;
import ar.edu.utn.frba.dds.models.externo.ExternoResponse;
import ar.edu.utn.frba.dds.models.externo.IncidenteDTO;
import ar.edu.utn.frba.dds.server.externo.ServicioExterno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ServicioExternoTest {

    ServicioExterno servicioExterno = new ServicioExterno();
    @Test
    @DisplayName("Se prueb integracion con servicio externo")
    public void consumirServicioExterno() throws Exception {
        ExternoRequest request = new ExternoRequest();
        EntidadDTO entidadDTO = new EntidadDTO();
        IncidenteDTO incidenteDTO = new IncidenteDTO();
        List<IncidenteDTO> listaIncidentes = new ArrayList<>();
        List<EntidadDTO> listaEntidades = new ArrayList<>();
        incidenteDTO.setEstaResuelto(true);
        incidenteDTO.setTiempoRespuesta(1);
        incidenteDTO.setMiembrosAfectados(2);
        listaIncidentes.add(incidenteDTO);
        entidadDTO.setCodigo("1001");
        entidadDTO.setIncidentes(listaIncidentes);
        listaEntidades.add(entidadDTO);
        request.setEntidades(listaEntidades);
        ServicioExterno instancia = servicioExterno.getInstancia();
        ExternoResponse response = instancia.llamado(request);
        Assertions.assertFalse(response.getEntidades().isEmpty());

    }


}
