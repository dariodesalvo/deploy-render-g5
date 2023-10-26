package ar.edu.utn.frba.dds.server;

import ar.edu.utn.frba.dds.controllers.*;

import static io.javalin.apibuilder.ApiBuilder.*;
public class Router {
    public static void init() {
        /*
        Server.app().get("/", ctx -> {
            ctx.sessionAttribute("item1", "Cosa 1");
            ctx.result("Hola mundo");
        });*/

        Server.app().get("/", ((IndexController) FactoryController.controller("Login"))::index);

        /*
        Server.app().get("/saluda", ctx -> {
            ctx.result("Hola "
                    + ctx.queryParam("nombre")
                    + ", " + ctx.sessionAttribute("item1")
            );
        });
        */
        Server.app().get("/saludo-para/{nombre}", ctx -> ctx.result("Hola "
                + ctx.pathParam("nombre")
        ));

        Server.app().routes(() -> {
            get("login", ((IndexController) FactoryController.controller("Login"))::index);
            get("apertura-incidente", ((IncidenteController) FactoryController.controller("Incidentes"))::index);
            get("administrar-usuarios", ((UsuarioController) FactoryController.controller("Usuarios"))::index);
            get("cargar-organizaciones", ((ArchivoController) FactoryController.controller("Archivos"))::index);

            /* Entidades Controller */

            get("entidades", ((EntidadesController) FactoryController.controller("Entidades"))::index);
            get("entidades/crear", ((EntidadesController) FactoryController.controller("Entidades"))::create);
            get("entidades/{id}/editar", ((EntidadesController) FactoryController.controller("Entidades"))::edit);
            post("entidades/{id}", ((EntidadesController) FactoryController.controller("Entidades"))::update);
            post("entidades", ((EntidadesController) FactoryController.controller("Entidades"))::save);
            get("entidades/{id}/establecimientos", ((EntidadesController) FactoryController.controller("Entidades"))::showEstablecimientos);
            /* Establecimientos Controller */

            get("establecimientos/{idEntidad}/crear", ((EstablecimientosController) FactoryController.controller("Establecimientos"))::create);
            post("establecimientos", ((EstablecimientosController) FactoryController.controller("Establecimientos"))::save);
            get("establecimientos/{id}/editar", ((EstablecimientosController) FactoryController.controller("Establecimientos"))::edit);
            post("establecimientos/{id}", ((EstablecimientosController) FactoryController.controller("Establecimientos"))::update);
            get("establecimientos/{id}/servicios", ((EstablecimientosController) FactoryController.controller("Establecimientos"))::showServicios);

            /* Servicios Controller */
            get("servicios/{idEstablecimiento}/crear", ((ServiciosController) FactoryController.controller("Servicios"))::create);
            post("servicios", ((ServiciosController) FactoryController.controller("Servicios"))::save);
            get("servicios/{id}/editar", ((ServiciosController) FactoryController.controller("Servicios"))::edit);
            post("servicios/{id}", ((ServiciosController) FactoryController.controller("Servicios"))::update);



        });
    }
}

