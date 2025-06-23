package Practise4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practise4 {
    public static void main(String[]args){
        String WorkShoplog = "Practise4/workShoplog.txt";
        String SkippedStudent = "Practise4/skipped.txt";

        int TotalPresent = 0;
        int TotalAbsent = 0;

        try(
            BufferedReader bfr = new BufferedReader(
                new FileReader(WorkShoplog));
            BufferedWriter bfw = new BufferedWriter(
                new FileWriter(SkippedStudent))
        ){
            String line;
            while((line = bfr.readLine()) != null){
                if(line.isEmpty()) continue;
                String [] token = line.split(",");
                String name = token[0].trim();
                String presence = token[1].trim();

                if(presence.equalsIgnoreCase("Attended")){
                    TotalPresent++;
                }
                else if(presence.equalsIgnoreCase("Skipped")){
                    TotalAbsent++;

                    bfw.write(line);
                    bfw.newLine();
                }

            }

        }catch(IOException ex){
            ex.printStackTrace();
        }

        System.out.println("Total present Student: " + TotalPresent);
        System.out.println("Total Absent Student: " + TotalAbsent);
    }
    
}
