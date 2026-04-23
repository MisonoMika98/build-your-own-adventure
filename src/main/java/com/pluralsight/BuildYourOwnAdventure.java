package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class BuildYourOwnAdventure
{
    static Scanner userInput = new Scanner(System.in);

    // static and at top of class so it can run it static functions and out of scope
    static ArrayList<StoryStep> steps;

    static void main()
    {
     steps = loadAdventure();
     homeScreen();
    }

    public static void homeScreen()
    {

        System.out.println();
        System.out.println("Welcome to your adventure!");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter (P) to Play");
        System.out.println("Enter (Q) to Quit");
        System.out.println("===================");
        String selection = userInput.nextLine().toUpperCase().trim();

        // user input options

        if (selection.equals("P")) {
            gameScreen(1);
        }
        else if (selection.equals("Q")) {
            System.out.println();
            System.out.println("See you again!");
            userInput.close();
        }
        else {
            System.out.println();
            System.out.println("Error, please try again!");
            homeScreen(); // recursion
        }

    }

    public static void gameScreen(int id)
    {
        int nextId = id;

        while (nextId != -1)
        {
            StoryStep step = findStep(nextId);

            if (step == null)
            {
                System.out.println();
                System.out.println("An error occurred. Step not found.");
            }
            else
            {
                System.out.println();
                System.out.println("Story Text: " + step.getStoryText());
                System.out.println();
                System.out.println("1) " + step.getOption1Text());
                System.out.println();
                System.out.println("2) " + step.getOption2Text());
                System.out.println();
                System.out.print("Make a selection (1 or 2): ");

                String optionSelect = userInput.nextLine().strip().toLowerCase();

                switch (optionSelect)
                {
                    case "1":
                        nextId = step.getOption1NextId();
                        break;

                    case "2":
                        nextId = step.getOption2NextId();
                        break;
                }
            }
        }
    }

    // function that looks for the steps inside array list
    public static StoryStep findStep(int id)
    {
        // gets arraylist size
        for (int i = 0; i < steps.size(); i++)
        {
            StoryStep step = steps.get(i);
            if (step.getId() == id)
            {
                return step;
            }
        }
        return null;
    }

    // function that reads the .csv and stores data
    public static ArrayList <StoryStep> loadAdventure()
    {
        // create the container
        // arraylists grow as needed when you add new items, unlike an array with a number of predetermined items
       ArrayList<StoryStep> steps = new ArrayList<>();

       try {
           FileReader fileReader = new FileReader("adventure1.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           // skips the header
           String lines = bufferedReader.readLine();

           // reads the .csv file
           while ((lines = bufferedReader.readLine()) != null) {

               // array to split the .csv into columns
               String[] columns = lines.split("\\|");
               int id = Integer.parseInt(columns[0]);
               String storyText = columns[1];
               String option1Text = columns[2];
               int option1NextId = Integer.parseInt(columns[3]);
               String option2Text = columns[4];
               // changed text (END) in the .cvs file column[5] to -1 so it can read the column
               int option2NextId = Integer.parseInt(columns[5]);


               // creates storyStep object
               StoryStep storyStep = new StoryStep(id, storyText, option1Text,
                       option1NextId, option2Text, option2NextId);

               // adds the current storyStep into an array list/container
               steps.add(storyStep);

           }


           // closes the file
           bufferedReader.close();
       }

       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }
       // returns the container
       return steps;
    }


}

