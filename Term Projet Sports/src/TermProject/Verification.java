/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;
import static TermProject.ReadWrite.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 2257853
 */
public class Verification {
    
    public static void Verifying() throws FileNotFoundException{
        String temp = getVerification();
        ArrayList<String> temp_storage = new ArrayList<>(Arrays.asList(temp.substring(0,temp.lastIndexOf(',')).split(",")));
        //System.out.println(temp_storage);
        for(String s: temp_storage){
            //System.out.println(s.substring(0, s.indexOf(":")));
            String key = s.substring(0, s.indexOf(":"));
            System.out.println(key);
            String value = s.substring(s.indexOf(":")+1);
            System.out.println(value);

        }
    }
}
