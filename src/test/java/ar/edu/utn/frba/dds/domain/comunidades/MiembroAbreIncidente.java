package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.domain.incidentes.Incidente;
import ar.edu.utn.frba.dds.domain.servicios.Servicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MiembroAbreIncidente{

    private  Usuario usuario;
    private Miembro miembro;

    private Comunidad comunidadA;

    private Comunidad comunidadB;

    private Servicio servicio;

    private List<Incidente> incidentes;

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
    }

    @Test
    @DisplayName("Un miembro que se encuentra en dos comunidades abre un incidente")
    public void abrirIndicente() throws Exception {

        incidentes = miembro.abrirIncidente(servicio);
        Assertions.assertEquals(incidentes.size(), 2);
        /* se crean dos instancias de incidentes */
    }





}