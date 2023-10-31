package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.helpers.ValidadorContrasenia;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeUsuarios;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class LoginController extends Controller implements ICrudViewsHandler {

    private RepositorioDeUsuarios repositorioDeUsuarios;

    public LoginController(RepositorioDeUsuarios repositorioDeUsuarios){
        this.repositorioDeUsuarios = repositorioDeUsuarios;
    }
    @Override
    public void index(Context context) {

        context.render("login/login.hbs");
    }

    public void register(Context context) {
        context.render("login/registro.hbs");
    }

    @Override
    public void show(Context context) {
    }

    @Override
    public void create(Context context){}

    public void login(Context context){

        List<Usuario> usuarios = (List<Usuario>) repositorioDeUsuarios.login(context.formParam("email"), context.formParam("password"));
        Map<String, Object> model = new HashMap<>();

        if(!usuarios.isEmpty())
        {
            Usuario usuario = usuarios.get(0);
            System.out.println("entre al if");
            model.put("usuario", usuario);
            System.out.println("cargue usuario");
            context.render("/entidades/entidades.hbs", model);
        }
        else
        {
            System.out.println("entre al else");
            String error = "No se encontró un usuario con ese password.";
            model.put("error", error);
            context.render("login/login.hbs", model);
        }
    }
    public void registrar(Context context) throws Exception {

        //esto hay que hacerlo mejor
        ValidadorContrasenia validador = new ValidadorContrasenia();

        // ver bloque try catch
        // no tiene en cuenta pass trivial
        if(validador.laContraseniaEsValida(context.formParam("password"))){
            //ver bloque try
            System.out.println("creando usuario");
            Usuario nuevoUsuario = new Usuario(context.formParam("email"),context.formParam("password"));
            //x defecto los usuarios se crean como lectores...
            this.repositorioDeUsuarios.guardar(nuevoUsuario);

            //ver uso de sessiones
//            context.sessionAttribute("usuario_id");

            Map<String, Object> model = new HashMap<>();
            model.put("usuario", nuevoUsuario);

            //x ahora redirecciona aca
            context.render("/entidades/entidades.hbs", model);

        }else{

            System.out.println("validacion de usuario no funciona");
            Map<String, Object> model = new HashMap<>();
            String error = "El password no cumple con los requisitos.";
            model.put("error", error);
            context.render("login/registro.hbs", model);

        }

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
