/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import bean.Clientes;
import bean.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class Clientes_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object list(int id) {
        return null;
    }

    @Override
    public List listAll() {        
        List lista = new ArrayList();
        try {
            String url, user, password;
//            url = "jdbc:mysql://10.7.0.51:33062/db_joao_Vilhanueva";
//            user = "joao_Vilhanueva";
//            password = "joao_Vilhanueva";
            url = "jdbc:mysql://localhost:3306/vendas";
            //?useTimeZone=true&serverTimezone=UTC
            user = "root";
            password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "select * from clientes";
            pstm = cnt.prepareStatement(sql);            
            ResultSet rs = pstm.executeQuery();            
            while (rs.next() == true) {
                Clientes clientes = new Clientes();
                clientes.setIdClientes(rs.getInt("idclientes"));
                clientes.setNome( rs.getString("nome"));
                clientes.setEndereco(rs.getString("endereco"));
                clientes.setCep(rs.getString("cep"));
                lista.add(clientes);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
