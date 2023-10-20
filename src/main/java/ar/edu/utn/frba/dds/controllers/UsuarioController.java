package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

public class UsuarioController extends Controller implements ICrudViewsHandler {
    @Override
    public void index(Context context) {
        context.render("administracion_tipos_usuarios/administrar-usuarios.hbs");
    }

    @Override
    public void show(Context context) {

    }

    @Override
    public void create(Context context) {

    }

    @Override
    public void save(Context context) {

    }

    @Override
    public void edit(Context context) {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }
}
