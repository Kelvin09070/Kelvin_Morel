/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author u09656283104
 */
public class ListaUsuarios {
    public static void main(String[] args) {
        List lista = new ArrayList();
        Usuarios usuarios = new Usuarios();
        usuarios.setIdUsuarios(1);
        usuarios.setNome("Kelvin");
        usuarios.setApelido("KL");
        
         lista.add(usuarios);
         
         lista.add( new Usuarios(2, "klaudio", "K"));
         lista.add( new Usuarios(0, "zimba", "zizi"));
         
         Collections.sort(lista);
         for (Object usuarios1 : lista) {
             System.out.println(((Usuarios)usuarios1).getNome());    
         }
        //criar uma lista
        
        
       
        }
        //adicione 2 usuarios a lista
    }
    

