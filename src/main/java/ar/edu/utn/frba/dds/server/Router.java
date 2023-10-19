package ar.edu.utn.frba.dds.server;

import ar.edu.utn.frba.dds.controllers.FactoryController;
import ar.edu.utn.frba.dds.controllers.IndexController;

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
        });
    }
}

