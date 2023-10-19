package ar.edu.utn.frba.dds.models.incidentes;
import ar.edu.utn.frba.dds.models.incidentes.TurnoDeNotificaciones.TurnoNotificacion;

import java.util.Timer;
import java.util.TimerTask;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.mail.EmailException;

@Getter
@Setter
//otra forma de crear una tarea programada
public class CronNotificador {

    private Notificador notificador;
    private TurnoNotificacion turno;

    public void ejecutar(){
    Timer timer;
    timer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run()
        {

            try {
                notificador.notificarPendientes(turno);
            } catch (EmailException e) {
                throw new RuntimeException(e);
            }

        }
    };

    timer.schedule(task, 10, 600000);
    //10 minutos
    }

//10 minutos
}
