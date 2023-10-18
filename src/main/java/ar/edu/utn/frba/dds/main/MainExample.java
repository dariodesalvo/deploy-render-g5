package ar.edu.utn.frba.dds.main;

import ar.edu.utn.frba.dds.domain.entidades.Entidad;
import com.sun.tools.javac.Main;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;

public class MainExample implements WithSimplePersistenceUnit
{

public static void main(String[] args) {new MainExample().start();}

    private void start(){
        Entidad unaEntidad = new Entidad();
        unaEntidad.setLeyenda("Tren Roca a");

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(unaEntidad);
        tx.commit();

    }



}
