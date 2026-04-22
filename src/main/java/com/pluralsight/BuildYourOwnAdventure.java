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
       try {
           FileReader fileReader = new FileReader("adventure1.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           // skips the header
           String lines = bufferedReader.readLine();

           // reads the .csv file
           while ((lines = bufferedReader.readLine()) != null) {

               // array to columns the .csv into columns
               String[] columns = lines.split("\\|");
               int id = Integer.parseInt(columns[0]);
               String storyText = columns[1];
               String option1Text = columns[2];
               int option1NextId = Integer.parseInt(columns[3]);
               String option2Text = columns[4];
               int option2NextId = Integer.parseInt(columns[5]);


               // creates storyStep object
               StoryStep storyStep = new StoryStep(id, storyText, option1Text,
                       option1NextId, option2Text, option2NextId);

               System.out.println(storyStep.getStoryText());
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

