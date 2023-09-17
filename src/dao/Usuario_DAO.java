package dao;


import bean.KvmJogos;
import bean.KvmUsuario;


import java.sql.PreparedStatement;

import java.sql.SQLException;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcos
 */
public class Usuario_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
       Criteria criteria = session.createCriteria(KvmUsuario.class);
       criteria.add(Restrictions.eq("id", id));
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista.get(0);
        
    }

    @Override
    public List listAll() {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(KvmUsuario.class);
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }
}