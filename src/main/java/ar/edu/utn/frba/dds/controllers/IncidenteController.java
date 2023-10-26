package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeServicios;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
import ar.edu.utn.frba.dds.server.exceptions.AccessDeniedException;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidenteController extends Controller implements ICrudViewsHandler {

    private RepositorioDeServicios repositorioServicios = new RepositorioDeServicios();
    @Override
    public void index(Context context) {

/*
        Usuario usuarioLogueado = super.usuarioLogueado(context);

        if(usuarioLogueado == null || !usuarioLogueado.getRol().tenesPermiso("crear_servicios")) {
            throw new AccessDeniedException();
        }
*/      List<Servicio> servicios= this.repositorioServicios.buscarTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("servicios", servicios);
        context.render("apertura_incidentes/apertura-incidentes.hbs", model);

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

