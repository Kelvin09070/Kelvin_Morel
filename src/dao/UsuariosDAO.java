package dao;

import aulas.TesteJDBC;
import bean.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class UsuariosDAO extends DAO_Abstract {

    public UsuariosDAO() {
        
    }
    
    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
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
            String sql = "insert into usuarios values( ?,?,?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdUsuarios());
            pstm.setString(2, usuarios.getNome());
            pstm.setString(3, usuarios.getApelido());
            pstm.setString(4, usuarios.getCpf());
            pstm.setDate(5, new java.sql.Date( usuarios.getDataNascimento().getTime() ) );
            //pstm.setDate(5, (java.sql.Date) new Date(2001,01,01));
            pstm.setString(6, usuarios.getSenha());
            pstm.setInt(7, usuarios.getNivel());
            pstm.setString(8, usuarios.getAtivo());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Usuarios usuarios = (Usuarios) object;
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
            String sql = "update usuarios set  nome=?,apelido=?, cpf=?,datanascimento=?,"
                    + "senha=?,nivel=?,ativo=? where idusuarios=? ";
            pstm = cnt.prepareStatement(sql);
            pstm.setString(1, usuarios.getNome());
            pstm.setString(2, usuarios.getApelido());
            pstm.setString(7, usuarios.getAtivo());
            pstm.setInt(8, usuarios.getIdUsuarios());
            pstm.setString(3, usuarios.getCpf());
            pstm.setDate(4, new java.sql.Date( usuarios.getDataNascimento().getTime() ));            
            pstm.setString(5, usuarios.getSenha());
            pstm.setInt(6, usuarios.getNivel());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;
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
            String sql = "delete from usuarios where idusuarios=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdUsuarios());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Usuarios usuarios = new Usuarios();
        
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
            String sql = "select * from usuarios where idusuarios=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                usuarios.setIdUsuarios( rs.getInt("idusuarios"));
                usuarios.setNome( rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setSenha(rs.getString("senha"));                
                usuarios.setDataNascimento( rs.getDate("dataNascimento"));
                usuarios.setNivel( rs.getInt("nivel"));
                usuarios.setAtivo( rs.getString("ativo"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public List listAll() {        
        List lista = new ArrayList();
        try {
            String url, user, password;
            url = "jdbc:mysql://localhost:3306/vendas";
            user = "root";
            password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "select * from usuarios ";
            pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();            
            while (rs.next() == true) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuarios( rs.getInt("idusuarios"));
                usuarios.setNome( rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setSenha(rs.getString("senha"));                
                usuarios.setDataNascimento( rs.getDate("dataNascimento"));
                usuarios.setNivel( rs.getInt("nivel"));
                usuarios.setAtivo( rs.getString("ativo"));
                lista.add(usuarios);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static void main(String[] args) {
        Usuarios usuarios = new Usuarios();
        usuarios.setIdUsuarios(20);
        usuarios.setNome("jose");
        usuarios.setApelido("jj");
        usuarios.setCpf("789");
        //usuarios.setDataNascimento(null);
        usuarios.setSenha("123");
        usuarios.setNivel(1);
        usuarios.setAtivo("S");
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.insert(usuarios);

        System.out.println("deu certo");
    }
}
