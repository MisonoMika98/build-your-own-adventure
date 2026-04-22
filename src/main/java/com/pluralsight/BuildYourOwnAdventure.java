package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;

public class BuildYourOwnAdventure {
    static void main()
    {
     loadAdventure();
    }




    // function that reads the .csv
    public static void loadAdventure()
    {
       try
       {
           FileReader fileReader = new FileReader("adventure1.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           // skips the header
           String lines = bufferedReader.readLine();

           // reads the file
           while((lines = bufferedReader.readLine()) != null) {
               System.out.println(lines);
           }

           // closes the file
           bufferedReader.close();
       }

       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }
    }
}

