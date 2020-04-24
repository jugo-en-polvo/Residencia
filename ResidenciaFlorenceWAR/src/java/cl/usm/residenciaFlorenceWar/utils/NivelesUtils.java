/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author elagosl
 */
public class NivelesUtils {
    
    public static Boolean presionValida(String presion) {
        Pattern pattern = Pattern.compile("^\\d?\\d\\d/\\d?\\d\\d");
        Matcher matcher = pattern.matcher(presion);
        if (matcher.matches() == false) {
            return false;
        }else{
            return true;
        }
    }
        
    public static String[] sistoleDiastole(String presion){
        return presion.split("/");
    }
    
    
}
