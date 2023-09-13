package ar.edu.utn.frba.dds.domain.rankings;

import ar.edu.utn.frba.dds.domain.entidades.Entidad;
import org.apache.commons.mail.EmailException;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class generarInforme {

    private IRankeable rankearXCantidad;
    private IRankeable rankearXImpacto;
    private IRankeable rankearXTiempo;
    private List<Entidad> entidades;

    private void inicializar(){
        //query de entidades
        entidades = new ArrayList<>();

        rankearXCantidad = new RankingXCantidad();
        rankearXTiempo = new RankingXTiempo();
        rankearXImpacto = new RankingXImpacto();
    }

    public void ejecutar(){
        Timer timer;
        timer = new Timer();
        this.inicializar();
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {

                    rankearXImpacto.rankear(entidades);
                    rankearXTiempo.rankear(entidades);
                    rankearXCantidad.rankear(entidades);
                    //persistir los listados en repo
            }
        };

        timer.schedule(task, 604800000, 604800000);
        //una vez por semana
    }

}
