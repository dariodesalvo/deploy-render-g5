package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Comunidad;
import ar.edu.utn.frba.dds.models.entidades.Entidad;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeComunidades;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEntidades;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEstablecimientos;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ComunidadesController extends Controller implements ICrudViewsHandler {

    private RepositorioDeComunidades repositorioDeComunidades;

    private RepositorioDeEntidades repositorioDeEntidades;
    public ComunidadesController(RepositorioDeComunidades repositorioDeComunidades) {
        this.repositorioDeComunidades = repositorioDeComunidades;
    }

    @Override
    public void index(Context context) {

        Map<String, Object> model = new HashMap<>();
        List<Comunidad> comunidades = this.repositorioDeComunidades.buscarTodos();
        model.put("comunidades", comunidades);
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("id", context.sessionAttribute("id"));
        context.render("comunidades/comunidades.hbs", model);

    }

    public void crearSolicitud(Context context){

        Long usuario= Long.parseLong(context.pathParam("usuario_id"));
        System.out.println("1");
        Comunidad comunidad = (Comunidad) this.repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));
        System.out.println("2");

        comunidad.agregarSolicitud(usuario);
        System.out.println("3");

        this.repositorioDeComunidades.actualizar(comunidad);

        Map<String, Object> model = new HashMap<>();
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("id", context.sessionAttribute("id"));
        model.put("comunidad", comunidad.getNombre());
        context.render("comunidades/solicitud_enviada.hbs", model);

    }

    public void adminComunidad(Context context){
        Map<String, Object> model = new HashMap<>();
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("id", context.sessionAttribute("id"));
        context.render("comunidades/solicitud_enviada.hbs", model);
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

    private void asignarParametros(Establecimiento establecimiento, Context context) {
        if(!Objects.equals(context.formParam("leyenda"), "")) {
            establecimiento.setLeyenda(context.formParam("leyenda"));
            Entidad entidad = (Entidad) this.repositorioDeEntidades.buscar(Long.parseLong(context.formParam("idEntidad")));
            establecimiento.setEntidad(entidad);
        }
    }


}