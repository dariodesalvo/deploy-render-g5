package ar.edu.utn.frba.dds.main;

import ar.edu.utn.frba.dds.domain.entidades.Entidad;
import ar.edu.utn.frba.dds.domain.entidades.Establecimiento;

import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.MedioDeNotificacion;
import ar.edu.utn.frba.dds.domain.incidentes.mediosNotificacion.sender.EmailSender;
import com.sun.tools.javac.Main;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.hibernate.Session;

import javax.persistence.EntityTransaction;

public class MainExample implements WithSimplePersistenceUnit
{

public static void main(String[] args) {new MainExample().start();}

    private void start(){
        Entidad unaEntidad = new Entidad();
        unaEntidad.setLeyenda("Tren Roca a");

        MedioDeNotificacion email = new EmailSender();

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(unaEntidad);
        entityManager().persist(email);
        tx.commit();

    }



}
