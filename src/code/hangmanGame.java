package code;

//import java.io.BufferedReader;
import java.io.IOException;

class hangmanGame {
    
    public static void main(String[] args) throws IOException{
        
        calc hangman = new calc();
        
        int count = 0;
        //BufferedReader reader = null;
        hangman.readLine();
        hangman.welcomeNote();//ewelcome note
        
        while (true){
            //hangman.fileReader();
            hangman.secAssign(count);
            count = hangman.getCount();
            hangman.welcome();//shows disguised word
            
                while (true) {
                        hangman.takeInput(); //take inputs

                        if (hangman.checkChar())  //if char
                        {
                            hangman.getDisguisedWord();
                            //hangman.forLoop();
                        } 

                        hangman.result(); // print the progress of the user

                        if(hangman.getHint().equals(hangman.getSecretWord())){
                            hangman.correct();
                            break;
                        }
                } //end of nested while
               	
                if (hangman.quite()) 
                {
                    System.out.println("Game Finish!!!");
                    break;
                }	
                else 
                {
                    System.out.println("Welcome to the round: " + (count+2) );
                }            
        }//end of while loop 
    }//end of main
}//end of class