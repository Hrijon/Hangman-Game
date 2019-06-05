package code;

//import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
//import java.io.IOException;
import java.util.Scanner;

public class calc{
    
    private char userGuess = 0;
    private String hint;
    private String secretWord, userInput;
    private int count, right, wrong, total = 0;
    private String[] words;
    private String line;
    //private int wordIndex = 0;

    Scanner input = new Scanner(System.in);
    
    File file = new File("D:\\hangmanFile.txt");
    private Scanner hangmanFile;

    public calc() throws FileNotFoundException //constructor
    {
        hangmanFile = new Scanner(file);
    }

    public void readLine() throws FileNotFoundException 
    {
        int i = 0;

        words = new String[100];

        while(hangmanFile.hasNextLine()) {

                words[i]= hangmanFile.nextLine().toLowerCase();
                i++;
        }
    }
    
    public void secAssign(int level) 
    {
	secretWord = words[level];
       

        //clearing the buffer for another round
        hint = "";
        right = 0;
        wrong = 0;
        total = 0;
    }
    public void welcomeNote()
    {
        System.out.println("\t\tWelcome to the HANGMAN Game");
    }
    public void welcome() 
    {                
        hintWord(secretWord);
        System.out.println("The disguised word is <" + hint + ">");
    }
                
    public void takeInput()
    { 
        System.out.println("You must enter a character only.\nGuess a letter: ");
        userGuess = Character.toLowerCase(input.nextLine().charAt(0));
        userInput = Character.toString(userGuess);
        
    }//end of method takeinput
    
    public boolean checkChar() 
    {	
        boolean flag = false;
        if (userInput.length() == 1 && Character.isLetter(this.userInput.charAt(0))){
            flag = true;
        }
        else
        {
            System.out.println("Sorry, your must enter an character from a-z");
        }
        return flag;
    }   
    
    public String getDisguisedWord()
    {
        boolean flag = false;
        for (int i = 0; i< secretWord.length(); i++) 
        {
           if (userGuess == secretWord.charAt(i)) 
            {
                exist(userGuess, i);
                flag = true;
            }
        }//end of for
        total++;
        if (flag) 
            right++;
        else  
            wrong++;
        return hint; 
    }
    
    public void result() 
    {
        System.out.println("\nTotal Guess: " + total + "\tCorrect Guess: " + right + "\tIncorrect Guess: " + wrong + "\n");
        System.out.println("Your new disguised word <" + hint + ">");
    }
    
//    public boolean checkEquality() 
//    {
//        System.out.println("is found word   " + hint + "  secretWord  " + secretWord);
//        return(hint.equalsIgnoreCase(secretWord));
//      
//    }
    
   public void correct() 
    {
        System.out.println("Congrats you won!! the secret word is " + getSecretWord());
    }
    
    private void hintWord(String secretWord)
    {

        for (int i = 0; i<secretWord.length(); i++) 
        {
            hint += "?";

        }//end of for
    }//end of method for loop
    
    private void exist(char userGuess, int i) 
    {
        StringBuilder sb = new StringBuilder(hint);
        sb.setCharAt(i, userGuess);

        hint = sb.toString();
    }
    
    public boolean quite()
    {
        boolean flag = true;
        System.out.println("Click any input to continue or type 'q' to quite");
        char quit = input.nextLine().charAt(0);  
            
        return (quit == 'q' || quit == 'Q');
    }//end of method quite 
    
    public String getSecretWord() 
    {
        return secretWord;
    }
    
    public String getHint() 
    {
        return hint;
    }
    
    public int getCount() 
    {
        return count++;
    }
    
}//end of class
