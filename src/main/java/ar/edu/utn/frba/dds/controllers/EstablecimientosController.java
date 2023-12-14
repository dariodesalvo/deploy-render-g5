package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.entidades.Entidad;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEntidades;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEstablecimientos;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class EstablecimientosController extends Controller implements ICrudViewsHandler {

    private RepositorioDeEstablecimientos repositorioDeEstablecimientos;

    private EntidadesController entidadesController = new EntidadesController(new RepositorioDeEntidades());

    private RepositorioDeEntidades repositorioDeEntidades;
    public EstablecimientosController(RepositorioDeEstablecimientos repositorioDeEstablecimientos, RepositorioDeEntidades repositorioDeEntidades) {
        this.repositorioDeEstablecimientos = repositorioDeEstablecimientos;
        this.repositorioDeEntidades = repositorioDeEntidades;
    }

    @Override
    public void index(Context context) {

        Map<String, Object> model = new HashMap<>();
        List<Entidad> establecimientos = this.repositorioDeEstablecimientos.buscarTodos();
        model.put("establecimientos", establecimientos);
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        context.render("establecimientos/establecientos.hbs", model);

    }

    @Override
    public void show(Context context) {

        //context vas a tener el id

        //query usando el id

        //retornas la vista hidratada con el query

    }

    @Override
    public void create(Context context) {

        Entidad entidad = (Entidad) this.repositorioDeEntidades.buscar(Long.parseLong(context.pathParam("idEntidad")));
        Establecimiento establecimiento = null;
        Map<String, Object> model = new HashMap<>();
        model.put("establecimiento", establecimiento);
        model.put("entidad", entidad);
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        context.render("establecimientos/establecimiento.hbs", model);
    }

    @Override
    public void save(Context context) {

        Establecimiento establecimiento = new Establecimiento();
        this.asignarParametros(establecimiento, context);
        this.repositorioDeEstablecimientos.guardar(establecimiento);
        context.status(HttpStatus.CREATED);
        /*Map<String, Object> model = new HashMap<>();
        model.put("entidad", establecimiento.getEntidad());
        model.put("establecimientos", establecimiento.getEntidad().misEstablecimientos());*/
        //context.render("establecimientos/establecimientos.hbs", model);
        context.redirect("entidades/"+establecimiento.getEntidad().getId()+"/establecimientos");

    }

    @Override
    public void edit(Context context) {
        Establecimiento establecimiento = (Establecimiento) this.repositorioDeEstablecimientos.buscar(Long.parseLong(context.pathParam("id")));
        context.status(HttpStatus.OK);
        Map<String, Object> model = new HashMap<>();
        model.put("establecimiento", establecimiento);
        model.put("entidad", establecimiento.getEntidad());
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        context.render("establecimientos/establecimiento.hbs", model);
    }

    @Override
    public void update(Context context) {
        Establecimiento establecimiento = (Establecimiento) this.repositorioDeEstablecimientos.buscar(Long.parseLong(context.pathParam("id")));
        this.asignarParametros(establecimiento, context);
        this.repositorioDeEstablecimientos.actualizar(establecimiento);
        context.status(HttpStatus.OK);
        /* Map<String, Object> model = new HashMap<>();
        model.put("entidad", establecimiento.getEntidad());
        model.put("establecimientos", establecimiento.getEntidad().misEstablecimientos());
        context.render("establecimientos/establecimientos.hbs", model);
        */
        context.redirect("/entidades/"+establecimiento.getEntidad().getId()+"/establecimientos");


    }


    @Override
    public void delete(Context context) {

    }

    private void asignarParametros(Establecimiento establecimiento, Context context) {
        if(!Objects.equals(context.formParam("leyenda"), "")) {
            establecimiento.setLeyenda(context.formParam("leyenda"));
            Entidad entidad = (Entidad) this.repositorioDeEntidades.buscar(Long.parseLong(context.formParam("idEntidad")));
            establecimiento.setEntidad(entidad);
        }
    }

    public void showServicios(Context context){
        Establecimiento establecimiento = (Establecimiento) this.repositorioDeEstablecimientos.buscar(Long.parseLong(context.pathParam("id")));
        Map<String, Object> model = new HashMap<>();
        model.put("establecimiento", establecimiento);
        model.put("servicios", establecimiento.getServicios());
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        context.render("servicios/servicios.hbs", model);

    }

}
