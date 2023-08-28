/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author u07679183120
 */
public class Util {
    
    public static void habilitar(boolean valor, JComponent ... vetComp) {
        for (int i = 0; i < vetComp.length; i++) {
        vetComp[i].setEnabled(valor);
        }
        
    }
    public static void limparCampos(JComponent ... vetComp) {
        for (int i = 0; i < vetComp.length; i++) {
           ((JTextField)vetComp[1]).setText("");
            
        }
    }
    public static void mensagem(String cadeia) {
        JOptionPane.showMessageDialog(null, cadeia);
        
    }
    public static boolean perguntar(String cadeia) {
       // int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?",
         //       "Exclusão", JOptionPane.YES_NO_OPTION);
        
         JOptionPane.showConfirmDialog(null, cadeia,
                "Exclusão", JOptionPane.YES_NO_OPTION);
         
        return false;
    }
    public static int strInt(String cad) {
        return Integer.valueOf(cad);
    }
    public static String intStr(int num) {
        return "";
    }
    public static double strDouble(String cad) {
        return 0;
    }
    public static String doubleStr(double num) {
        return "";
    }
    public static Date strDate(String cad) {
        return null;
    }
    public static String dateStr(Date data) {
        return "";
    }
    
}
