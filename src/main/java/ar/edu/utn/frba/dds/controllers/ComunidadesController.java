package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.*;
import ar.edu.utn.frba.dds.models.entidades.Entidad;
import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.helpers.ValidadorContrasenia;
import ar.edu.utn.frba.dds.models.repositorios.*;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<Comunidad> otrasComunidades;

        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        model.put("Miembro", context.sessionAttribute("Miembro"));

        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.sessionAttribute("usuario_id")));

        List<Comunidad> comunidadesPendientes = comunidades
                .stream()
                .filter(comunidad -> comunidad.getSolicitudes().contains(usuario))
                .collect(Collectors.toList());

        if(context.sessionAttribute("Miembro")!=null) {
            Miembro miembro = (Miembro) usuario.getRol();
            List<Comunidad> misComunidades = miembro.getComunidades();
            model.put("misComunidades", misComunidades);
            /*filtro las que ya participa*/
            otrasComunidades = comunidades
                    .stream()
                    .filter(comunidad -> !misComunidades.contains(comunidad))
                    .collect(Collectors.toList());

        }else{
            /* filtro solicitudes*/
            otrasComunidades = comunidades
                    .stream()
                    .filter(comunidad ->  !comunidadesPendientes.contains(comunidad) )
                    .collect(Collectors.toList());
        }

        model.put("comunidades", otrasComunidades);


        model.put("comunidadesPendientes", comunidadesPendientes);
        model.put("usuario", usuario);
        model.put("rol", usuario.getRol());

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
        model.put("Miembro", context.sessionAttribute("Miembro"));
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
        model.put("Miembro", context.sessionAttribute("Miembro"));
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
        model.put("Miembro", context.sessionAttribute("Miembro"));
        /* hasta aca averiguar cómo*/
        model.put("comunidad", comunidad);
        context.render("comunidades/gestionar_comunidad.hbs", model);

    }

    public void aceptarSolicitud(Context context) throws Exception {
        try{
        Comunidad comunidad = (Comunidad) repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));
        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.pathParam("usuario_id")));


        comunidad.eliminarSolicitud(usuario);



        RolesUsuario rol = usuario.getRol();

        Miembro miembro = new Miembro();
        miembro.setNombre(usuario.getEmail());
        miembro.setConfiabilidad(4.5);
        miembro.miembroAceptado(comunidad);
        repositorioDeRoles.guardar(miembro);
        usuario.setRol(miembro);
        comunidad.agregarMiembro(miembro);





                repositorioDeUsuarios.actualizar(usuario);
                repositorioDeRoles.eliminar(rol);
                System.out.println("rol eliminado");
                repositorioDeComunidades.actualizar(comunidad);

            Map<String, Object> model = new HashMap<>();

            /* desde aca */
            model.put("email", context.sessionAttribute("email"));
            model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
            model.put("usuario_id", context.sessionAttribute("usuario_id"));
            model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
            model.put("Miembro", context.sessionAttribute("Miembro"));
            /* hasta aca averiguar cómo*/
            model.put("comunidad", comunidad);

            context.render("comunidades/gestionar_comunidad.hbs", model);


        }catch (Exception e){
                new Exception("No se ha podido aceptar un nuevo miembro.");
            }


        }

    public void eliminar(Context context){

       Comunidad comunidad = (Comunidad) repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));
       List<Usuario> usuarios = (List<Usuario>) repositorioDeUsuarios.buscarXRol(Long.parseLong(context.pathParam("miembro_id")));
       Usuario usuario = usuarios.get(0);
       Miembro rol = (Miembro) usuario.getRol();

       if(comunidad.getAdministradores().contains(rol)){
           comunidad.sacarAdministrador(rol);
       }

       /* remueve de comunidad */
       rol.getComunidades().remove(comunidad);
       comunidad.getMiembros().remove(rol);

       /*x si es admin */
        if(comunidad.getAdministradores().contains(rol)){
            comunidad.getAdministradores().remove(rol);
        }
        /* en un futuro esta logica hay que hacerla mejor */

        /* si es miembro en mas de una no se elimina su rol */
        if(rol.getComunidades().size()<1)
        {
            Lector lector = new Lector();
            usuario.setRol(lector);
            repositorioDeRoles.eliminar(rol);
        }

        repositorioDeUsuarios.actualizar(usuario);
        repositorioDeComunidades.actualizar(comunidad);

        context.redirect("/comunidades/"+comunidad.getId().toString()+"/gestionar");
    }

    public void hacerAdmin(Context context){
        Comunidad comunidad = (Comunidad) repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));
        List<Usuario> usuarios = (List<Usuario>) repositorioDeUsuarios.buscarXRol(Long.parseLong(context.pathParam("miembro_id")));
        Usuario usuario = usuarios.get(0);
        Miembro miembro = (Miembro) usuario.getRol();

        comunidad.darAdministradorA(miembro);

        repositorioDeComunidades.actualizar(comunidad);

        Map<String, Object> model = new HashMap<>();

        /* desde aca */
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        model.put("Miembro", context.sessionAttribute("Miembro"));
        /* hasta aca averiguar cómo*/
        model.put("comunidad", comunidad);

        context.render("comunidades/gestionar_comunidad.hbs", model);

    }

    public void quitarAdmin(Context context){

        Comunidad comunidad = (Comunidad) repositorioDeComunidades.buscar(Long.parseLong(context.pathParam("comunidad_id")));
        List<Usuario> usuarios = (List<Usuario>) repositorioDeUsuarios.buscarXRol(Long.parseLong(context.pathParam("miembro_id")));

        Usuario usuario = usuarios.get(0);
        Miembro miembro = (Miembro) usuario.getRol();

        Map<String, Object> model = new HashMap<>();

        if(comunidad.getAdministradores().size()<2){
        model.put("mensaje", "Debe haber al menos un administrador de la comunidad");
        }else {
            comunidad.sacarAdministrador(miembro);

        }
        repositorioDeComunidades.actualizar(comunidad);


        /* desde aca */
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        model.put("Miembro", context.sessionAttribute("Miembro"));
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