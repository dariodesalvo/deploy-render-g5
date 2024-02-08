package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.comunidades.Miembro;
import ar.edu.utn.frba.dds.models.comunidades.RolesUsuario;
import ar.edu.utn.frba.dds.models.comunidades.TipoRol;
import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import ar.edu.utn.frba.dds.models.georef.ServicioGeoref;
import ar.edu.utn.frba.dds.models.georef.entities.ListadoDeMunicipios;
import ar.edu.utn.frba.dds.models.georef.entities.ListadoDeProvincias;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeComunidades;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeRoles;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeUsuarios;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.io.IOException;
import java.util.*;

public class UsuarioController extends Controller implements ICrudViewsHandler {

    private RepositorioDeUsuarios repositorioDeUsuarios;
    private RepositorioDeRoles repositorioDeRoles = new RepositorioDeRoles();

    ServicioGeoref servicioGeoref = ServicioGeoref.getInstancia();

    public UsuarioController(RepositorioDeUsuarios repositorioDeUsuarios) {
        this.repositorioDeUsuarios = repositorioDeUsuarios;
    }

    @Override
    public void index(Context context) {

        // context.render("administracion_tipos_usuarios/administrar-usuarios.hbs");
    }

    public void perfil(Context context) throws IOException {

        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.sessionAttribute("usuario_id")));
        Miembro miembro = (Miembro) usuario.getRol();
        ListadoDeProvincias listadoDeProvincias = servicioGeoref.listadoDeProvincias();


        Map<String, Object> model = new HashMap<>();

        //carga el selected
        if (!Objects.equals(context.pathParam("idProvincia"), "")) {
            ListadoDeProvincias listadoDeProvinciasPorID = servicioGeoref.listadoDeProvinciasPorID(Integer.parseInt(context.pathParam("idProvincia")));
            model.put("provincia", listadoDeProvinciasPorID.provincias.get(0));
        }

        ListadoDeMunicipios listadoDeMunicipios = null;
        //carga todos los municipios que usa
        if (!Objects.equals(context.pathParam("idProvincia"), "")) {
            listadoDeMunicipios = servicioGeoref.listadoDeMunicipiosDeProvincia(Integer.parseInt(context.pathParam("idProvincia")));
        }

        if (!Objects.equals(context.formParam("idMunicipio"), null)) {
            miembro.setIdMunicipio(Integer.parseInt(context.formParam("idMunicipio")));
        }

        //carga el selected de municipio
        if (!Objects.equals(miembro.getIdMunicipio(), 0)) {
            ListadoDeMunicipios listadoDeMunicipiosPorID = servicioGeoref.listadoDeMunicipiosPorID(miembro.getIdMunicipio());
            model.put("municipio", listadoDeMunicipiosPorID.municipios.get(0));
            /*
            ListadoDeProvincias listadoDeProvinciasPorID = servicioGeoref.listadoDeProvinciasPorID(Integer.parseInt(establecimiento.getIdProvincia().toString()));
            model.put("municipio", listadoDeProvinciasPorID.provincias.get(0));
        */
        }

        model.put("municipios", listadoDeMunicipios.municipios);
        model.put("provincias", listadoDeProvincias.provincias);
        model.put("miembro", usuario.getRol());
        this.cargarVariablesSesion(context, model);
        context.render("/login/perfil.hbs", model);
    }

    @Override
    public void show(Context context) {
        List<Usuario> usuarios = repositorioDeUsuarios.buscarTodos();

        Map<String, Object> model = new HashMap<>();

        Map<String, Object> usuariosMappeados = new HashMap<>();
        List<String> rolesUsuarios = new ArrayList<>();

        rolesUsuarios.add((TipoRol.Administrador.name()));
        rolesUsuarios.add((TipoRol.Lector.name()));
        rolesUsuarios.add((TipoRol.Prestador.name()));
        rolesUsuarios.add((TipoRol.Miembro.name()));

        for (Usuario usuario : usuarios) {
            String email = usuario.getEmail();
            String rolUsuario = usuario.getRol().getClass().getSimpleName();
            List<String> roles = rolesUsuarios.stream().filter((rol) -> !rol.equals(rolUsuario)).toList();

            usuariosMappeados.put("email", email);
            usuariosMappeados.put("rol", rolUsuario);
            usuariosMappeados.put("roles", roles);
        }


        model.put("usuarios", usuariosMappeados);

        System.out.println(model);
        context.render("administracion_tipos_usuarios/administrar-usuarios.hbs", model);

    }

    @Override
    public void create(Context context) {

    }

    @Override
    public void save(Context context) {

    }

    @Override
    public void edit(Context context) throws IOException {
        Usuario usuario = (Usuario) repositorioDeUsuarios.buscar(Long.parseLong(context.sessionAttribute("usuario_id")));
        ListadoDeProvincias listadoDeProvincias = servicioGeoref.listadoDeProvincias();
        Miembro miembro = (Miembro) usuario.getRol();



        miembro.setApellido(context.formParam("apellido"));
        miembro.setNombre(context.formParam("nombre"));
        miembro.setCelular(context.formParam("celular"));
        miembro.setIdProvincia(Long.parseLong(context.formParam("idProvincia")));
        miembro.setIdMunicipio(Integer.parseInt(context.formParam("idMunicipio")));
        /* falta medio de preferencia y municipio */

        repositorioDeRoles.actualizar((RolesUsuario) miembro);

        Map<String, Object> model = new HashMap<>();

        //carga el selected
        if (!Objects.equals(context.pathParam("idProvincia"), "")) {
            ListadoDeProvincias listadoDeProvinciasPorID = servicioGeoref.listadoDeProvinciasPorID(Integer.parseInt(context.pathParam("idProvincia")));
            model.put("provincia", listadoDeProvinciasPorID.provincias.get(0));
        }

        ListadoDeMunicipios listadoDeMunicipios = null;
        //carga todos los municipios que usa
        if (!Objects.equals(context.pathParam("idProvincia"), "")) {
            listadoDeMunicipios = servicioGeoref.listadoDeMunicipiosDeProvincia(Integer.parseInt(context.pathParam("idProvincia")));
        }

        if (!Objects.equals(context.formParam("idMunicipio"), null)) {
            miembro.setIdMunicipio(Integer.parseInt(context.formParam("idMunicipio")));
        }

        //carga el selected de municipio
        if (!Objects.equals(miembro.getIdMunicipio(), 0)) {
            ListadoDeMunicipios listadoDeMunicipiosPorID = servicioGeoref.listadoDeMunicipiosPorID(miembro.getIdMunicipio());
            model.put("municipio", listadoDeMunicipiosPorID.municipios.get(0));
            /*
            ListadoDeProvincias listadoDeProvinciasPorID = servicioGeoref.listadoDeProvinciasPorID(Integer.parseInt(establecimiento.getIdProvincia().toString()));
            model.put("municipio", listadoDeProvinciasPorID.provincias.get(0));
        */
        }
        model.put("municipios", listadoDeMunicipios.municipios);
        model.put("provincias", listadoDeProvincias.provincias);
        /* desde aca */
        model.put("email", context.sessionAttribute("email"));
        model.put("tipo_rol", context.sessionAttribute("tipo_rol"));
        model.put("usuario_id", context.sessionAttribute("usuario_id"));
        model.put("MiembroAdmin", context.sessionAttribute("MiembroAdmin"));
        //model.put("municipio", usuario.getMunicipio());
        model.put("miembro", usuario.getRol());
        model.put("municipio", miembro.getIdMunicipio());
        model.put("provincia", miembro.getIdProvincia());
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
