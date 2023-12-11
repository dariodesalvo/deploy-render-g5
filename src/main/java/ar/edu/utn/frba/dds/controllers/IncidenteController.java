package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.entidades.Empresa;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeIncidentes;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeServicios;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
import ar.edu.utn.frba.dds.server.exceptions.AccessDeniedException;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IncidenteController extends Controller implements ICrudViewsHandler {


    private RepositorioDeIncidentes repositorioDeIncidentes;
    private RepositorioDeServicios repositorioServicios = new RepositorioDeServicios();

    public IncidenteController(RepositorioDeIncidentes repositorioDeIncidentes){
        this.repositorioDeIncidentes = new RepositorioDeIncidentes();

    }
    @Override
    public void index(Context context) {

/*
        Usuario usuarioLogueado = super.usuarioLogueado(context);

        if(usuarioLogueado == null || !usuarioLogueado.getRol().tenesPermiso("crear_servicios")) {
            throw new AccessDeniedException();
        }
*/
        List<Servicio> servicios= this.repositorioServicios.buscarTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("servicios", servicios);
        context.render("apertura_incidentes/apertura-incidentes.hbs", model);

    }

    @Override
    public void show(Context context) {

        List<Incidente> incidentes= this.repositorioDeIncidentes.buscarTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("incidentes", incidentes);
        context.render("incidentes/incidentes.hbs", model);



    }

    @Override
    public void create(Context context) {

     /*   Incidente incidente = new Incidente();
        Map<String, Object> model = new HashMap<>();
        model.put("incidente", incidente);

        context.render("apertura_incidentes/apertura-incidentes.hbs");*/
    }

    @Override
    public void save(Context context) {
        //GUARDAR EL RECURSO
        Incidente incidente = new Incidente();
        this.asignarParametros(incidente, context);
        this.repositorioDeIncidentes.guardar(incidente);
        context.status(HttpStatus.CREATED);
        context.redirect("/incidentes");



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

    private void asignarParametros(Incidente incidente, Context context) {
        if(!Objects.equals(context.formParam("observaciones"), "")) {
            incidente.setObservaciones(context.formParam("observaciones"));
        }
    }

}

