package ar.edu.utn.frba.dds.externo;

import ar.edu.utn.frba.dds.serviceIntegration.servicio3.ServicioCalculoRII;
import ar.edu.utn.frba.dds.serviceIntegration.servicio3.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class IntegracionServicio3Test {

    private ExternoRequest entidadesRequest = new ExternoRequest();
    private EntidadDTO e1 = new EntidadDTO("1");
    private EntidadDTO e2 = new EntidadDTO("2");
    private EntidadDTO e3 = new EntidadDTO("3");
    private IncidenteDTO i1 = new IncidenteDTO(10,true,2);
    private IncidenteDTO i2 = new IncidenteDTO(100,true,9);
    private IncidenteDTO i3 = new IncidenteDTO(5,false,28);
    private IncidenteDTO i4 = new IncidenteDTO(50,true,15);
    private IncidenteDTO i5 = new IncidenteDTO(1,false,100);
    private IncidenteDTO i6 = new IncidenteDTO(5,false,46);


    @BeforeEach
    public void inicializar() throws Exception {
        e1.agregarIncidente(i1,i2,i3);
        e2.agregarIncidente(i4,i5,i6);
        e3.agregarIncidente(i1,i2,i3,i4,i5,i6);

        entidadesRequest.agregarEntidad(e1,e2,e3);

    }

    @Test
    @DisplayName("Se calcula el ranking de impacto de incidentes")
    public void calcularRankingDeImpacto() throws IOException {
        ServicioCalculoRII servicioCalculoRII = ServicioCalculoRII.getInstancia();
        ExternoResponse er = servicioCalculoRII.listadoDeEntidadesResult(entidadesRequest);

        for(EntidadResultDTO entidadResultDTO: er.getEntidades()) {
            System.out.println("codigoEntidad: " + entidadResultDTO.getCodigoEntidad() + " impactoIncidentes: " + entidadResultDTO.getImpactoIncidentes());
        }
    }

}
