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

           // reads the .csv file
           while((lines = bufferedReader.readLine()) != null)
           {

               // array to split the .csv into columns

               String[] split = lines.split("\\|");
               int id = Integer.parseInt(split[0]);
               String storyText = split[1];
               String option1Text = split[2];
               int option1NextId = Integer.parseInt(split[3]);
               String option2Text = split[4];
               int option2NextId = Integer.parseInt(split[5]);

               // creates storystep object
               StoryStep storystep = new StoryStep(id, storyText, option1Text,
                       option1NextId, option2Text, option2NextId);

               System.out.println(storystep.getStoryText());

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

