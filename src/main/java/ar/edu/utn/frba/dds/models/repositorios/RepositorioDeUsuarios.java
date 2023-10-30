package ar.edu.utn.frba.dds.models.repositorios;

import ar.edu.utn.frba.dds.models.comunidades.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;


import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class RepositorioDeUsuarios implements WithSimplePersistenceUnit, ICrudRepository {

    @Override
    public List buscarTodos() {
        return entityManager().createQuery("from " + Usuario.class.getName()).getResultList();
    }

    public Object login(String usuario, String password) {

        String hql = "FROM "+Usuario.class.getName()+" WHERE email = "+usuario+" AND password = "+password;

        Query query = entityManager().createQuery(hql); /*
        query.setParameter("table", Usuario.class.getName());
        query.setParameter("email", usuario);
        query.setParameter("password", password);
*/
        List<Usuario> usuarios = query.getResultList();

        return this.buscar(usuarios.get(0).getId());
    }


    @Override
    public Object buscar(Long id) {
        return entityManager().find(Usuario.class, id);
    }

    @Override
    public void guardar(Object o) {
        EntityTransaction tx = entityManager().getTransaction();
        if(!tx.isActive())
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
}
