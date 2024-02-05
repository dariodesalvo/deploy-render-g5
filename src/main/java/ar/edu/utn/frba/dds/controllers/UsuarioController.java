package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.RolesUsuario;
import ar.edu.utn.frba.dds.models.comunidades.TipoRol;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeComunidades;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeRoles;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeUsuarios;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController extends Controller implements ICrudViewsHandler {

    private RepositorioDeUsuarios repositorioDeUsuarios;
    private RepositorioDeRoles repositorioDeRoles = new RepositorioDeRoles();

    public UsuarioController(RepositorioDeUsuarios repositorioDeUsuarios) {
        this.repositorioDeUsuarios = repositorioDeUsuarios;
    }
    @Override
    public void index(Context context) {

       // context.render("administracion_tipos_usuarios/administrar-usuarios.hbs");
    }

    public void perfil(Context context){

        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.sessionAttribute("usuario_id")));

        Map<String, Object> model = new HashMap<>();
        model.put("miembro", usuario.getRol());
        this.cargarVariablesSesion(context, model);
        context.render("/login/perfil.hbs", model);
    }

    @Override
    public void show(Context context) {
        List<Usuario> usuarios = repositorioDeUsuarios.buscarTodos();

        List< Map<String, Object>> usuariosMappeados = new ArrayList<>();
        Map<String, Object> model = new HashMap<>();

        List<String> rolesUsuarios = new ArrayList<>();

        rolesUsuarios.add((TipoRol.Administrador.name()));
        rolesUsuarios.add((TipoRol.Lector.name()));
        rolesUsuarios.add((TipoRol.Prestador.name()));
        rolesUsuarios.add((TipoRol.Miembro.name()));

        for(Usuario usuario: usuarios){
            String email = usuario.getEmail();
            String rolUsuario = usuario.getRol().getClass().getSimpleName();
            List<String> roles = rolesUsuarios.stream().filter((rol)->!rol.equals(rolUsuario)).toList();

            Map<String,Object> usuarioMappeado= new HashMap<>();
            usuarioMappeado.put("email",email);
            usuarioMappeado.put("rol",rolUsuario);
            usuarioMappeado.put("roles",roles);
            usuariosMappeados.add(usuarioMappeado);
        }
        model.put("usuarios",usuariosMappeados);
        context.render("administracion_tipos_usuarios/administrar-usuarios.hbs", model);

    }

    @Override
    public void create(Context context) {

    }

    @Override
    public void save(Context context) {

    }

    @Override
    public void edit(Context context) {
        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.sessionAttribute("usuario_id")));

        Miembro miembro = (Miembro) usuario.getRol();

        miembro.setApellido(context.formParam("apellido"));
        miembro.setNombre(context.formParam("nombre"));
        miembro.setCelular(context.formParam("celular"));
        /* falta medio de preferencia y municipio */

        repositorioDeRoles.actualizar((RolesUsuario) miembro);

        Map<String, Object> model = new HashMap<>();

        /* desde aca */
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        model.put("municipio", usuario.getMunicipio());
        model.put("miembro", usuario.getRol());
        model.put("actualizado", "Actualizado correctamente");
        model.put("Miembro", context.sessionAttribute("Miembro"));
        context.render("/login/perfil.hbs", model);
    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }
}
