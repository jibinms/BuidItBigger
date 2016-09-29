package com.example;

import java.util.Random;

public class JokeList {

    private static String[] jokes= {"An Android app walks into a bar. Bartender asks, “Can I get you a drink?” The app looks disappointed and says, “That wasn’t my intent.”",
            "Google’s definition of an upgrade?\n" +
            "Answer: Take old bugs out, put new ones in.",
            "What is the difference between Android 2.1 and 2.2? \n Answer: 6 months","A pregnant fragment walks into a bar. The bartender says, \"Whoa! Whoa! We don't support nested fragments here!\"",
            "Samsung walks into a bar, and then developed TouchWiz","A fragment walks into a bar and says, \"I'm lost. Can I please speak to the FragmentManager?\""};

    public static String getYourJoke(){

       return jokes[new Random().nextInt(jokes.length)] ;
    }
}
