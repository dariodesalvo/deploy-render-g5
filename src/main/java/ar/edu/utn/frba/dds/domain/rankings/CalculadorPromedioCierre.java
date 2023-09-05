package ar.edu.utn.frba.dds.domain.rankings;

import ar.edu.utn.frba.dds.domain.entidades.Entidad;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class CalculadorPromedioCierre {
    private List<Incidente> incidentes;
    private  Long segundosAcumulados;

    private int cantidadIncidentes;
    public Long promedio(Entidad entidad, LocalDateTime reporteDesde, LocalDateTime reporteHasta){

         incidentes = entidad.listarIncidentes(reporteDesde, reporteHasta);

         for (Incidente incidente : incidentes
        ) {
            // x cada incidente se calcula el cierre
            segundosAcumulados += this.segundosEntreFechas(incidente.getFechaApertura(), incidente.getFechaCierre());
            cantidadIncidentes += 1;
        }

        return segundosAcumulados/cantidadIncidentes;
    }

    public long segundosEntreFechas(LocalDateTime apertura, LocalDateTime cierre){

        return  apertura.toEpochSecond(ZoneOffset.of("-03:00"))-cierre.toEpochSecond(ZoneOffset.of("-3:00"));
    }


}
