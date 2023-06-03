import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
public class runner{
    public static void main(String[] args) {
        System.out.println("Welcome to Worldle! \\(>.<)/\npress h for help\npress q to quit\npress m for mcdonalds\npress b to play bday song\npress r for restroom\npress p to play");
        Scanner input = new Scanner(System.in);
        String menu = input.nextLine();
        switch(menu) {
            case "h":
                System.out.println("too bad, no help available");
                break;
            case "q":
                System.out.println("no quitting no quitters no q");
                break;
            case "m":
                System.out.println("the closest mcdonalds is: 10000000 miles away");
                break;
            case "b":
                System.out.println("HAPPY BIRTHDAY SHUT UP AND EAT CAKE");
                break;
            case "r":
                System.out.println("sry, this key is in repair");
                break;
            case "p":
                System.out.println("welcome to Wordle \\(O.^)/");
                break;
        }
        String[] words = {"hello", "phone", "mouse", "angry", "camel"};
        String word = words[(int)(Math.random()*words.length)];
        int g = 6;
        String guess = "";
        while(!guess.equals(word)&&g>0) {
            System.out.println("\nYou have " + g + " guesses remaining.");
            guess = input.nextLine();
            if (guess.length()!= 5) {
                System.out.println("Needs to be 5 characters");
                guess = input.nextLine();
            }
            for (int i = 0; i<word.length(); i++){
                boolean didBreak = false;
                for(int j = 0; j<word.length(); j++) {
                    if (guess.charAt(i)==word.charAt(i)) {
                        System.out.print("Y");
                        didBreak = true;
                        break;
                    }
                    if (guess.charAt(i)==word.charAt(j)){
                        System.out.print("C");
                        didBreak=true;
                        break;
                    }
                }
                if (!didBreak) {
                    System.out.print("X");
                }
            }
            g--;
        }
        if (guess.equals(word)) {
            System.out.println("\nYou guessed it! Good job!");
        }
        else {
            System.out.println("\nYou failed! The word was: " + word);
        }
    }
}
