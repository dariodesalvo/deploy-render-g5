package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InformeController extends Controller implements ICrudViewsHandler {
    @Override
    public void index(Context context) {

    }

    @Override
    public void show(Context context) {
        Map<String, Object> model = new HashMap<>();
        model.put("servicio","Molinete");
        model.put("establecimiento","Molinete-Medrano");
        model.put("cantidadIncidentes",10);

        context.render("informes/generar-informes-incidentes.hbs", model);

    }

    @Override
    public void create(Context context) throws Exception {

    }

    @Override
    public void save(Context context) throws IOException {

    }

    @Override
    public void edit(Context context) throws IOException {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }
}
