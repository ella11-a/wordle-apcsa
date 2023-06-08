import java.util.Scanner;

public class runner{
    private static final String yellow_background = "\u001B[43m";
    private static final String green_background = "\u001B[42m";
    private static final String reset_color = "\u001B[0m";
    private static final String green_text = "\u001B[32m";
    private static final String yellow_text = "\u001B[33m";
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String wordle = reset_color + "W" + green_text + " O " + yellow_text + "R" + reset_color + " D L " + yellow_text + "E" + reset_color;


        String menu = ""; 
        while (!(menu.equals("p") || (menu.equals("q")))) {
            System.out.println("\nWELCOME TO " + wordle + "! \\(>.<)/\npress h for help\npress q to quit\npress m for mcdonalds\npress b to play bday song\npress r for restroom\npress p to play");
            menu = input.nextLine();

            if (menu.equals("h")) {
                System.out.println("too bad, no help available");
            }
            else if (menu.equals("q"))
                System.out.println("okay goodbye");
            else if (menu.equals("m"))
                System.out.println("the closest mcdonalds is: 10000000 miles away");
            else if (menu.equals("b"))
                System.out.println("HAPPY BIRTHDAY SHUT UP AND EAT CAKE");
            else if (menu.equals("r"))
                System.out.println("the restroom is being cleaned at the moment...");
            else if (menu.equals("p"))
                System.out.println("welcome to Wordle \\(O.^)/");
            else {
                System.out.println("invalid request.... automatically quitting..");
            }
        }

        while (menu.equals("p")) {
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

            System.out.println("Would you like to play again? yes or no");
            String playagain = input.nextLine();
            switch (playagain) {
                case "yes":
                    System.out.println("okay goodluck!");
                    break;
                case "no":
                    System.out.println("\nwe are sad to see you go!");
                    menu = "q";
                    break;
            }
        } 
        Players p = Players.load();
        System.out.println("\nwhat is your name?");
        String name = input.nextLine();
        System.out.println("\nwhat is your age?");
        int age = input.nextInt();
        p.setInfo(name, age);
    }
}