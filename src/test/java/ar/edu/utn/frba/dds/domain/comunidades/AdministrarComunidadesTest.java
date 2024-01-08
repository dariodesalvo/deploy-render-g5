package ar.edu.utn.frba.dds.domain.comunidades;

import ar.edu.utn.frba.dds.models.comunidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdministrarComunidadesTest {
    private Comunidad losMurcielagos = new Comunidad("los murcielagos");
    private Administrador rolAdministrador = new Administrador();
    private Lector rolLector = new Lector();
    private Miembro capitan;

    @BeforeEach
    public void inicializar() throws Exception {
        capitan = new Miembro("capitan", "capitan");
        //capitan.solicitarSerMiembro(losMurcielagos);
        losMurcielagos.darAdministradorA(capitan);
        Assertions.assertTrue(capitan.esAdmin());
    }

    @Test
    @DisplayName("Se setea un administrador y una comunidad agrega un nuevo miembro")
    public void adminAgregaMiembro() throws Exception {
       // Usuario juan = new Usuario("juan", "Delantero6576*");
        Miembro juan = new Miembro("juan","perez");
        losMurcielagos.darAdministradorA(juan);
        //losMurcielagos.agregarMiembro(juan);
        Assertions.assertTrue(losMurcielagos.getMiembros().contains(juan));

    }

}




