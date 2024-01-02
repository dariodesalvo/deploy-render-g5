package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeIncidentes;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeServicios;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeUsuarios;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
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

    private RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();

    public IncidenteController(RepositorioDeIncidentes repositorioDeIncidentes){
        this.repositorioDeIncidentes = new RepositorioDeIncidentes();

    }
    @Override
    public void index(Context context) {


        List<Servicio> servicios= this.repositorioServicios.buscarTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("servicios", servicios);
        this.cargarVariablesSesion(context,model);
        context.render("apertura_incidentes/apertura-incidentes.hbs", model);

    }

    @Override
    public void show(Context context) {

        List<Incidente> incidentes= this.repositorioDeIncidentes.buscarTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("incidentes", incidentes);
        this.cargarVariablesSesion(context,model);
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

        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.sessionAttribute("usuario_id")));

        Miembro miembro = (Miembro)  usuario.getRol();

        Servicio servicio = (Servicio) repositorioServicios.buscar(Long.parseLong(context.formParam("servicio_id")));

        String observaciones = context.formParam("observaciones");

        List<Incidente> incidentes = miembro.abrirIncidente(servicio, observaciones);

        incidentes.forEach( incidente -> {
                    this.repositorioDeIncidentes.guardar(incidente);
                }
        );

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

    public void cerrar(Context context){

        Incidente incidente= (Incidente) this.repositorioDeIncidentes.buscar(Long.parseLong(context.formParam("incidentes_id")));
        Map<String, Object> model = new HashMap<>();
        model.put("incidente", incidente);
        this.cargarVariablesSesion(context,model);
        context.render("cierre-incidentes/cierre-incidentes.hbs", model);

    }

    private void asignarParametros(Incidente incidente, Context context) {
        if(!Objects.equals(context.formParam("observaciones"), "")) {
            incidente.setObservaciones(context.formParam("observaciones"));
            Servicio servicio = (Servicio) repositorioServicios.buscar(Long.parseLong(context.formParam("servicio_id")));
            incidente.setServicio(servicio);
        }
    }

}

