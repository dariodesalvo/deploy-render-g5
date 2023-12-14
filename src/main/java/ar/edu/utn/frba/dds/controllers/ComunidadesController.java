package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Comunidad;
import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.RolesUsuario;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.entidades.Entidad;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.repositorios.*;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ComunidadesController extends Controller implements ICrudViewsHandler {

    private RepositorioDeComunidades repositorioDeComunidades;

    private RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
    private RepositorioDeRoles repositorioDeRoles = new RepositorioDeRoles();

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
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        context.render("comunidades/comunidades.hbs", model);

    }

    public void crearSolicitud(Context context){

        Usuario usuario= (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.pathParam("usuario_id")));

        Comunidad comunidad = (Comunidad) this.repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));

        comunidad.agregarSolicitud(usuario);

        this.repositorioDeComunidades.actualizar(comunidad);

        Map<String, Object> model = new HashMap<>();
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        model.put("comunidad", comunidad.getNombre());
        context.render("comunidades/solicitud_enviada.hbs", model);

    }

    public void adminComunidad(Context context){

        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.sessionAttribute("usuario_id")));
        Miembro miembro = (Miembro) usuario.getRol();

        Map<String, Object> model = new HashMap<>();
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        model.put("comunidades", miembro.comunidadesAdministradas());
        context.render("comunidades/administrar_comunidad.hbs", model);
    }

    public void gestionar(Context context){
        Comunidad comunidad = (Comunidad) repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));
        Map<String, Object> model = new HashMap<>();
        /* desde aca */
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        /* hasta aca averiguar cómo*/
        model.put("comunidad", comunidad);
        context.render("comunidades/gestionar_comunidad.hbs", model);

    }

    public void aceptarSolicitud(Context context){

        Comunidad comunidad = (Comunidad) repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));
        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.pathParam("usuario_id")));


        comunidad.eliminarSolicitud(usuario);



        RolesUsuario rol = usuario.getRol();

        Miembro miembro = new Miembro();
        miembro.setConfiabilidad(4.5);
        miembro.getComunidades().add(comunidad);
        usuario.setRol(miembro);
        comunidad.agregarMiembro(miembro);

        repositorioDeRoles.eliminar(rol);

        repositorioDeUsuarios.actualizar(usuario);
        repositorioDeComunidades.actualizar(comunidad);

        Map<String, Object> model = new HashMap<>();

        /* desde aca */
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        /* hasta aca averiguar cómo*/
        model.put("comunidad", comunidad);

        context.render("comunidades/gestionar_comunidad.hbs", model);
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