import java.util.Scanner;

public class runner{
    private static final String yellow_background = "\u001B[43m";
    private static final String green_background = "\u001B[42m";

    private static final String reset_color = "\u001B[0m";
    public static void main(String[] args) {

        Players play = new Players();
        play.toString();
        System.out.println("Welcome to Worldle! \\(>.<)/\npress h for help\npress q to quit\npress m for mcdonalds\npress b to play bday song\npress r for restroom\npress p to play");
        Scanner input = new Scanner(System.in);
        String menu = input.nextLine();
        // switch statements 
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
        String[] words = WordleWords.getWords();
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
                        System.out.print(green_background + guess.charAt(i) + reset_color);
                        didBreak = true;
                        break;
                    }
                    if (guess.charAt(i)==word.charAt(j)){
                        System.out.print(yellow_background + guess.charAt(i) + reset_color);
                        didBreak=true;
                        break;
                    }
                }
                if (!didBreak) {
                    System.out.print(guess.charAt(i));
                }
            }
            g--;
        }
        if (guess.equals(word)) {
            System.out.println("\nYou guessed it! Good job!");
        }
        else {
            System.out.println("\nYou failed! The word was: " + green_background + word + reset_color);
        }

        //serialization & exception handling
        Players p = Players.load();
        System.out.println("what is your name?");
        String name = input.nextLine();
        System.out.println("what is your age?");
        int age = input.nextInt();
        p.setInfo(name, age);

        
        
    }
}