package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeUsuarios;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController extends Controller implements ICrudViewsHandler {

    private RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
    @Override
    public void index(Context context) {
        List<Usuario> usuarios = this.repositorioDeUsuarios.buscarTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("usuarios", usuarios);
        context.render("administracion_tipos_usuarios/administrar-usuarios.hbs",model);
    }

    @Override
    public void show(Context context) {
        context.render("administracion_tipos_usuarios/administrar-usuarios.hbs");
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
