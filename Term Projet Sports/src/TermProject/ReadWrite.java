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
import java.util.*;

/**
 *
 * @author santiago
 */
public class ReadWrite {
    
    public static String GetAthleteTime(String name, String sport) throws FileNotFoundException {
        String home = System.getProperty("user.home");
        String f_name = String.format("%s%s%s%s",home,"/desktop/SportsPlatform/Athletes/",name,"/"+sport);
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
        String home = System.getProperty("user.home");
        String f_name = String.format("%s%s%s%s",home,"/desktop/SportsPlatform/Athletes/",name,"/"+sport);
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
        String home = System.getProperty("user.home");
        String f_name = String.format("%s%s%s",home,"/desktop/SportsPlatform/Athletes/",name);
        new File(f_name).mkdirs();

    }
    
    
    public static String GetAdminLogIn() throws FileNotFoundException{
        String home = System.getProperty("user.home");
        String path = home+"/desktop/SportsPlatform/LoginInformation/Admins.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();


            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            br.close();
            return everything;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public static String GetUserLogIn() throws FileNotFoundException{
        String home = System.getProperty("user.home");
        String path = home+"/desktop/SportsPlatform/LoginInformation/Users.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();


            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            br.close();
            return everything;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public static String getVerification() throws FileNotFoundException{
        String home = System.getProperty("user.home");
        String path = home+"/desktop/SportsPlatform/Athletes/Verification.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();


            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            br.close();
            return everything;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void SaveUsers(HashMap<String,String> ls, List<Athletes> athletes) throws IOException{
        
        String home = System.getProperty("user.home");
        String path = home+"/desktop/SportsPlatform/LoginInformation/Users.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
        String toWrite = "";
        ArrayList<String> temp_ls = new ArrayList<>(ls.keySet());
        for(int i=0; i<ls.size();i++){
            toWrite+= temp_ls.get(i)+":";
            toWrite+= ls.get(temp_ls.get(i))+":";
            for(Athletes athlete: athletes){
                    
                    if(athlete.getUsername().equals(temp_ls.get(i)) && athlete.getClass()==Swimming.class)
                    {
                        toWrite+=athlete.sport+":"+athlete.firstName+":"+athlete.lastName+":"+athlete.verified+",";
                    }
                    else if(athlete.getUsername().equals(temp_ls.get(i)) && athlete.getClass()==Football.class)
                    {
                        toWrite+=athlete.sport+":"+athlete.firstName+":"+athlete.lastName+",";                
                    }
                    else if(athlete.getUsername().equals(temp_ls.get(i)) && athlete.getClass()==Track.class)
                    {
                        toWrite+=athlete.sport+":"+athlete.firstName+":"+athlete.lastName+",";
                    }
                }
        }
        writer.write(toWrite);
        //writer.append(section+":"+time);
        writer.close();
        
    }
    
    public static void SaveAdmins(HashMap<String,String> hs) throws IOException{
        
        String home = System.getProperty("user.home");
        String path = home+"/desktop/SportsPlatform/LoginInformation/Admins.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
        String toWrite = "";
        ArrayList<String> temp_ls = new ArrayList<>(hs.keySet());
        for(int i=0; i<temp_ls.size();i++){
            toWrite+=temp_ls.get(i)+":"+hs.get(temp_ls.get(i))+",";
        }
        writer.write(toWrite);
        writer.close();
        
    }
    
}
