package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.server.exceptions.AccessDeniedException;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

public class IncidenteController extends Controller implements ICrudViewsHandler {
    @Override
    public void index(Context context) {

/*
        Usuario usuarioLogueado = super.usuarioLogueado(context);

        if(usuarioLogueado == null || !usuarioLogueado.getRol().tenesPermiso("crear_servicios")) {
            throw new AccessDeniedException();
        }
*/
        context.render("apertura_incidentes/apertura-incidentes.hbs");

    }

    @Override
    public void show(Context context) {

        //context vas a tener el id

        //query usando el id

        //retornas la vista hidratada con el query

    }

    @Override
    public void create(Context context) {
        context.render("apertura_incidentes/apertura-incidentes.hbs");
    }

    @Override
    public void save(Context context) {
        // entity manager
    }

    @Override
    public void edit(Context context) {
        // podes llamar a save
    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }


}

