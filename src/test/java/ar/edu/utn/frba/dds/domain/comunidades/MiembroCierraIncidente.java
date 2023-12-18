package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.models.comunidades.Comunidad;
import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MiembroCierraIncidente{

    private Usuario usuario;
    private Miembro miembro;

    private Miembro miembroQueCierraA;

    private Miembro miembroQueCierraB;

    private Comunidad comunidadA;

    private Comunidad comunidadB;
    private Servicio servicio;
    private List<Incidente> incidentes = new ArrayList<>();
    private List<Incidente> incidenteA = new ArrayList<>();
    private List<Incidente> incidenteB = new ArrayList<>();
    private Incidente incidente;

    @BeforeEach
    public void inicializar() throws Exception {
        usuario = new Usuario("correoValido@gmail.com", "S4b4d012$");
        miembro = new Miembro("Sabado", "Agosto");
        usuario.setRol(miembro);
        comunidadA = new Comunidad("Comunidad A");
        comunidadB = new Comunidad("Comunidad B");
        comunidadA.agregarMiembro(miembro);
        comunidadB.agregarMiembro(miembro);
        /* Un miembro pertenece a las comunidades Ay B */

        // ini nuevo servicio que se abrira y cerrara un incidente por cada comunidad
        servicio = new Servicio();

        miembroQueCierraA = new Miembro("Cierro", "A");
        miembroQueCierraB = new Miembro("Cierro", "B");
        comunidadA.agregarMiembro(miembroQueCierraA);
        comunidadB.agregarMiembro(miembroQueCierraB);

        incidentes = miembro.abrirIncidente(servicio, "No funciona");

        /* se crean dos instancias de incidentes */
        /* se puede filtrar asi */
        incidenteA = incidentes.stream()
                .filter(incidente -> comunidadA.equals(incidente.getComunidad()))
                .collect(Collectors.toList());
        /* se puede filtrar asi tambien*/
        for (Incidente incidente : incidentes) {
            if (incidente.getComunidad()==comunidadB) {
                incidenteB.add(incidente);
            }
        }
    }

    @Test
    @DisplayName("miembro esta en comunidad A")
    public void miembroEstaEnA() throws Exception {

        Assertions.assertTrue(miembro.getComunidades().contains(comunidadA));
    }
    @Test
    @DisplayName("hay abierto un total de dos incidentes")
    public void hayAbiertosDosIncidentes() throws Exception {

        Assertions.assertEquals(incidentes.size(), 2);
    }


    @Test
    @DisplayName("Size incidentes A es 1")
    public void incidentesAesUno() throws Exception {

        Assertions.assertEquals(incidenteA.size(), 1);
    }

    @Test
    @DisplayName("Size incidentes B es 1")
    public void incidentesBesUno() throws Exception {
        Assertions.assertEquals(incidenteB.size(), 1);
    }

    @Test
    @DisplayName("Miembro 'Sabado Agosto' es el que abrio los incidentes")
    public void miembroAbrioIncidente() throws Exception {

        incidentes = miembro.abrirIncidente(servicio, "Inundado");
        incidentes.forEach( incidente -> {Assertions.assertEquals(incidente.getAbiertoPor(), miembro);}
        );
    }

    @Test
    @DisplayName("Miembro A cierra incidente para A")
    public void miembroAcerroIncidenteA() throws Exception {
        incidente = incidenteA.get(0);
        miembroQueCierraA.cerrarIncidente(incidente);
        Assertions.assertEquals(incidente.getCerradoPor(), miembroQueCierraA);

    }



    @Test
    @DisplayName("Miembro B cierra incidente para B")
    public void miembroBcerroIncidenteB() throws Exception {
        incidente = incidenteB.get(0);
        miembroQueCierraB.cerrarIncidente(incidente);
        Assertions.assertEquals(incidente.getCerradoPor(), miembroQueCierraB);
    }

}