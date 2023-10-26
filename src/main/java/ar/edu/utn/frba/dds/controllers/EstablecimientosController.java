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
        context.render("establecimientos/establecimiento.hbs", model);
    }

    @Override
    public void save(Context context) {

        //Entidad entidad = new Entidad();
        Establecimiento establecimiento = new Establecimiento();
        this.asignarParametros(establecimiento, context);
        this.repositorioDeEstablecimientos.guardar(establecimiento);
        context.status(HttpStatus.CREATED);
        //context.redirect("/establecimientos/"+context.pathParam("idEntidad")+"/crear");
        context.redirect("/entidades");
    }

    @Override
    public void edit(Context context) {
        Establecimiento establecimiento = (Establecimiento) this.repositorioDeEstablecimientos.buscar(Long.parseLong(context.pathParam("id")));
        Map<String, Object> model = new HashMap<>();
        model.put("establecimiento", establecimiento);
        context.render("establecimientos/establecimiento.hbs", model);
    }

    @Override
    public void update(Context context) {
        Establecimiento establecimiento = (Establecimiento) this.repositorioDeEstablecimientos.buscar(Long.parseLong(context.pathParam("id")));
        this.asignarParametros(establecimiento, context);
        this.repositorioDeEstablecimientos.actualizar(establecimiento);
        context.redirect("/establecimientos");
    }

    @Override
    public void delete(Context context) {

    }

    private void asignarParametros(Establecimiento establecimiento, Context context) {
        if(!Objects.equals(context.formParam("leyenda"), "")) {
            establecimiento.setLeyenda(context.formParam("leyenda"));
            Entidad entidad = (Entidad) this.repositorioDeEntidades.buscar(Long.parseLong(context.formParam("leyenda")));
            establecimiento.setEntidad(entidad);
        }
    }

}
