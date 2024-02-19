package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeIncidentes;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformeController extends Controller implements ICrudViewsHandler {


    private RepositorioDeIncidentes repositorioDeIncidentes = new RepositorioDeIncidentes();

    @Override
    public void index(Context context) {

    }

    @Override
    public void show(Context context) {
        Map<String, Object> model = new HashMap<>();
        model.put("servicio","Molinete");
        model.put("establecimiento","Molinete-Medrano");
        model.put("cantidadIncidentes",10);
        this.cargarVariablesSesion(context,model);
        context.render("informes/generar-informes-incidentes.hbs", model);

    }

    @Override
    public void create(Context context) throws Exception {

        /*
        entidades con mayor tiempo promedio de tiempo de cierre de incidentes (diferencia entre horario de
        cierre de incidente y horario de apertura) en la semana. Este ranking es orientativo y puede no ser
        la tasa real de corrección de las fallas;
        */

        LocalDateTime desde=null, hasta=null;
        List<Incidente> incidentesCerrados = (List<Incidente>) this.repositorioDeIncidentes.buscarCerrados(desde, hasta);

        Map<String, Object> model = new HashMap<>();
        this.cargarVariablesSesion(context,model);
        context.render("informes/generar-informes-incidentes.hbs", model);

        /*
        entidades con mayor cantidad de incidentes reportados en la semana. Una vez que un incidente
        sobre un servicio es reportado por algún usuario, independientemente de la comunidad de la que
        forma parte, no se consideran, para el presente ranking, ningún incidente que se genere sobre
        dicho servicio en un plazo de 24 horas siempre y cuando el mismo continúe abierto (un incidente
        reportado como cerrado anula el plazo sobre el servicio y el siguiente incidente sí se considera para
        el cálculo);
         */

        /*
        mayor grado de impacto de las problemáticas considerando que las que algunas comunidades
        tienen mayor cantidad de miembros y por lo tanto les afecta de mayor medida el no funcionamiento
        de ese servicio. El detalle de la generación de ranking con este criterio será considerado en la
        siguiente entrega.
        */
    }

    @Override
    public void save(Context context) throws IOException {

    }

    @Override
    public void edit(Context context) throws IOException {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }
}
