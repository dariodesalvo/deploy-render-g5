package ar.edu.utn.frba.dds.domain.rankings;

import ar.edu.utn.frba.dds.domain.entidades.Entidad;
import ar.edu.utn.frba.dds.domain.incidentes.Incidente;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RankingXTiempo implements IRankeable {

    private LocalDateTime reporteDesde;
    private LocalDateTime reportehasta;

    //clase auxiliar para ordenar listado
    @Getter
    @Setter
    public class EntidadConSegundos{
        private Entidad entidad; // quedarse con el ID de la entidad solamente
        private Long segundosAcumulados;
        private int cantidadIncidentes;

        public Long promedioCierre(){
            return segundosAcumulados/cantidadIncidentes;
        }
    }

    private List<EntidadConSegundos> segundosxEntidades = new ArrayList<>();
    private EntidadConSegundos reporteEntidad;
    private List<Incidente> incidentes = new ArrayList<>();
    private List<Entidad> entidadesRankeadas= new ArrayList<>();
    private Entidad entidad;
    @Override
    public Ranking rankear(List<Entidad> entidades) {
        for (Entidad entidad: entidades
             ) {

            reporteEntidad.entidad=entidad;
            reporteEntidad.segundosAcumulados=0L;
            reporteEntidad.cantidadIncidentes = 0;

            incidentes = entidad.listarIncidentes(reporteDesde, reportehasta);
            for (Incidente incidente : incidentes
                 ) {
                // x cada incidente se calcula el cierre
                reporteEntidad.segundosAcumulados += this.segundosEntreFechas(incidente.getFechaApertura(), incidente.getFechaCierre());
                reporteEntidad.cantidadIncidentes += 1;
            }
            segundosxEntidades.add(reporteEntidad);
        }

        // finalmente se ordena la lista para obtener el ranking
        List<EntidadConSegundos> entidadesOrdenadas =
                segundosxEntidades.stream()
                                  .sorted(Comparator.comparingLong(EntidadConSegundos::promedioCierre))
                                  .toList();

        for (EntidadConSegundos EntidadxSegundos: entidadesOrdenadas
             ) {
            entidad = EntidadxSegundos.getEntidad();
            entidadesRankeadas.add(entidad);
        }

        return new Ranking(entidadesRankeadas, "mayor promedio de tiempo de cierre de incidentes");

    }

    public long segundosEntreFechas(LocalDateTime apertura, LocalDateTime cierre){

        return  apertura.toEpochSecond(ZoneOffset.of("-03:00"))-cierre.toEpochSecond(ZoneOffset.of("-3:00"));
    }
}
