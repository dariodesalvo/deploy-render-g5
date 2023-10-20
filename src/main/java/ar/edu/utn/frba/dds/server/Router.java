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

        Server.app().get("/", ((IndexController) FactoryController.controller("login"))::index);

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
            get("login", ((IndexController) FactoryController.controller("login"))::index);
            get("apertura-incidente", ((IncidenteController) FactoryController.controller("incidente"))::index);
            get("administrar-usuarios", ((UsuarioController) FactoryController.controller("usuario"))::index);
            get("cargar-organizaciones", ((ArchivoController) FactoryController.controller("archivo"))::index);
        });
    }
}

