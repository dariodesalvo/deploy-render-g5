package ar.edu.utn.frba.dds.domain.incidentes.envioNotificacion;

import ar.edu.utn.frba.dds.domain.comunidades.Miembro;
import ar.edu.utn.frba.dds.domain.comunidades.Usuario;
import ar.edu.utn.frba.dds.domain.incidentes.CronNotificador;
import ar.edu.utn.frba.dds.domain.incidentes.Notificador;
import ar.edu.utn.frba.dds.domain.incidentes.TurnoDeNotificaciones.TurnoM;
import ar.edu.utn.frba.dds.domain.incidentes.TurnoDeNotificaciones.TurnoNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.adapterImpl.NotificarPorEmail;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender.EmailSender;

//test de notificador cada 10 minutos
public class CronNotificadorTest {
    public static void main(String arglist[]) throws Exception {
        // ejemplo de uso
        // se inicializan todas las instancias minimas necesarias para comunicar una notificacion programada
        Notificador notificador = new Notificador();
        TurnoNotificacion turno = new TurnoM();
        Usuario caro = new Usuario("ddesalvo@frba.utn.edu.ar", "Password1*");
        Miembro miembro = new Miembro("caro", "rinaldi");
        caro.setRol(miembro);
        miembro.setEmail(caro.getEmail());
        NotificarPorEmail adapterEmail = new NotificarPorEmail();
        EmailSender emailSender = new EmailSender(adapterEmail);
        miembro.setMedioNotificacionPreferido(emailSender);
        turno.agregarMiembro(miembro);
        String mensaje = "Este es un mensaje enviado de prueba usando crontask";
        turno.agregarNotificacion(mensaje);

        //se inicia el cronNotificador que en este caso corre cada 10 minutos.
        CronNotificador cronNotificador = new CronNotificador();
        cronNotificador.setNotificador(notificador);
        cronNotificador.setTurno(turno);
        cronNotificador.ejecutar();

        // se simula un nuevo mensaje de incidente
        mensaje = "10 minutos despues este es un mensaje enviado de prueba usando crontask";
        turno.agregarNotificacion(mensaje);

    }
}