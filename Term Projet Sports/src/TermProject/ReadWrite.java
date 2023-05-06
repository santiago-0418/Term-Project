/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author santiago
 */
public class ReadWrite {
    
    public static String GetAthleteTime(String name, String sport) throws FileNotFoundException {
        String f_name = String.format("%s%s%s","/Users/santiago/desktop/SportsTest/Athletes/",name,"/"+sport);
        BufferedReader br = new BufferedReader(new FileReader(f_name));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();


            while (line != null) {
                sb.append(line);
                //sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            br.close();
            return everything;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void WriteToAthlete(String name,String sport, ArrayList<String> ls) throws IOException {
        String f_name = String.format("%s%s%s","/Users/santiago/desktop/SportsTest/Athletes/",name,"/"+sport);
        BufferedWriter writer = new BufferedWriter(new FileWriter(f_name, false));

        for(String s: ls){
            //Gives Category
            //System.out.println(s.substring(0, s.indexOf(":")));
            writer.append(s.substring(0, s.indexOf(":")));
            writer.append(":");
            writer.append(s.substring(s.indexOf(":")+1));
            //Gives time in seconds
            //System.out.println(s.substring(s.indexOf(":")+1));
            writer.append(',');
        }
        //writer.append(section+":"+time);
        writer.close();
    }

    public static void CreateAthleteFolder(String name){

        String f_name = String.format("%s%s","/Users/santiago/desktop/SportsTest/Athletes/",name);
        new File(f_name).mkdirs();

    }
    
}
