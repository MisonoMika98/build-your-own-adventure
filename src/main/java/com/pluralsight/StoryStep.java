package com.pluralsight;

public class StoryStep {
    private int id;
    private String storyText;
    private String option1Text;
    private int option1NextId;
    private String option2Text;
    private int option2NextId;

    // constructor
    public StoryStep(int id, String storyText, String option1Text, int option1NextId,
                     String option2Text, int option2NextId)
    {
        this.id = id;
        this.storyText = storyText;
        this.option1Text = option1Text;
        this.option1NextId = option1NextId;
        this.option2Text = option2Text;
        this.option2NextId = option2NextId;
    }


    // getters

    public int getId() {
        return id;
    }

    public String getStoryText() {
        return storyText;
    }

    public String getOption1Text() {
        return option1Text;
    }

    public int getOption1NextId() {
        return option1NextId;
    }

    public String getOption2Text() {
        return option2Text;
    }

    public int getOption2NextId() {
        return option2NextId;
    }


}
