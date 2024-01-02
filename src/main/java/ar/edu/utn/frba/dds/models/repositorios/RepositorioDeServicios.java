package ar.edu.utn.frba.dds.models.repositorios;

import ar.edu.utn.frba.dds.models.entidades.Establecimiento;
import ar.edu.utn.frba.dds.models.servicios.Servicio;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;


import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioDeServicios implements WithSimplePersistenceUnit, ICrudRepository {

    @Override
    public List buscarTodos() {
        return entityManager().createQuery("from " + Servicio.class.getName()).getResultList();
    }

    @Override
    public Object buscar(Long id) {
        return entityManager().find(Servicio.class, id);
    }

    @Override
    public void guardar(Object o) {
        EntityTransaction tx = entityManager().getTransaction();
        if (!tx.isActive())
            tx.begin();

        entityManager().persist(o);
        tx.commit();
    }

    @Override
    public void actualizar(Object o) {
        EntityTransaction tx = entityManager().getTransaction();
        if(!tx.isActive())
            tx.begin();

        entityManager().merge(o);
        tx.commit();
      }

    @Override
    public void eliminar(Object o) {
        EntityTransaction tx = entityManager().getTransaction();
        if(!tx.isActive())
            tx.begin();

        entityManager().remove(o);
        tx.commit();
      }

    @Override
    public void limpiarCache(){
        entityManager().clear();
    }
}
