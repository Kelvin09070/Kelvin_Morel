/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.KvmCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcos
 */
public class Cliente_DAO extends DAO_Abstract {

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
       Criteria criteria = session.createCriteria(KvmCliente.class);
       criteria.add(Restrictions.eq("idKvmClientes", id));
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista.get(0);
        
    }

    @Override
    public List listAll() {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(KvmCliente.class);
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }
}
    
