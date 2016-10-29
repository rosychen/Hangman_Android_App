package com.example.rosyc.hangman;

/**
 * Created by rosyc on 10/4/2016.
 */
import java.util.Arrays;
import java.util.Random;


public class secret_word {
    private String[] words = {"bookworm", "peanuts", "Pennsylvania", "policeman", "donkey", "niece", "kilobyte", "gypsy", "school", "homework", "sushi"};
    private String[] hints = {"HINT: person", "HINT: food", "HINT: place", "HINT: occupation", "HINT: animal", "HINT: person", "HINT: measurement", "HINT: person", "HINT: place", "HINT: thing", "HINT: food"};
    private char[] blanks = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};

    private String hint_string;         // will store the hint
    private int numberWrong;            // will store the number of wrong answers

    private String hangmanTemp;         // will store the secret word
    private char[] displayArray;        // what will be displayed to the user
    char[] test_guesses;                // will be used to compare user's guesses
    private boolean victoryStatus;      // true for win and false for lose
    private boolean rightChoice;        // checks to see if the input value exists or not
    private Random r_val;


    public secret_word() {
        numberWrong = 0;

        r_val = new Random();
        int index = r_val.nextInt(words.length);    // random generates a number

        hangmanTemp = words[index];                 // stores the word
        hint_string = hints[index];                 // stores the hint

        test_guesses = hangmanTemp.toCharArray();
        displayArray = hangmanTemp.toCharArray();       // display array

        for (int i = 0; i < displayArray.length; i++) {
            displayArray[i] = blanks[i];
        }
    }


    public secret_word(String h, String w) {
        numberWrong = 0;


        hangmanTemp = w;                 // stores the word
        hint_string = h;                 // stores the hint

        test_guesses = hangmanTemp.toCharArray();
        displayArray = hangmanTemp.toCharArray();       // display array

        for (int i = 0; i < displayArray.length; i++) {
            displayArray[i] = blanks[i];
        }
    }


    public void checkLetter(char letter) {
        rightChoice = false;            // letter doesn't exist
        int temp = 0;
        for (int i = 0; i < test_guesses.length; i++) {
            if (Character.toLowerCase(test_guesses[i]) == letter) {
                displayArray[i] = letter;
                rightChoice = true;         // letter exists
            }
        }

        if (rightChoice == false) {
            numberWrong++;
        }

        boolean check = Arrays.equals(displayArray, test_guesses);
        if (check == true && numberWrong < 6) {
            victoryStatus = true;
        } else if (check == false && numberWrong == 6)
            victoryStatus = false;
    }

    public boolean getVictoryStatus(){
        return victoryStatus;
    }

    public Integer getNumberWrong(){
        return numberWrong;
    }

    public String getWord(){
        String output1 = new String(displayArray);
        return output1;
    }

    public String getHint(){
        return hint_string;
    }

}
