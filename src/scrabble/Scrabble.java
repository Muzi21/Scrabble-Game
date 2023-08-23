 
package scrabble;
import java.util.Scanner;
public class Scrabble {
    
    private static String PlayerOne;
    private static String PlayerTwo;
    private static int PlayerNumber=1;
    private static String CurrentPlayer;
    private static int option ;
    private static  String usedWord="";
    private static String alphabetList=" abcdefghijklmnopqrstuvwxyz ";
    private static String usedLetters="";
    private static boolean updateAlphabets=true;
    private static int Player1_Score=0;
    private static int Player2_Score=0;
    
    public static void main(String[] args) {
        
      Scanner scan = new Scanner(System.in);
      
        
 System.out.print("Welcome to the WORD WARS game."+
               "\n\nPress (1) to start the game"+
               "\n\nPress any other to key to exit the game"+
                 "\nEnter your Selection :"   );
        int option =scan.nextInt();
        if (option==1)
        {
        System.out.print("\nEnter Player one name: ");
        PlayerOne =scan.next();
        System.out.print("\nEnter Player Two name: ");
        PlayerTwo =scan.next();
        startGame();
        
        }
        else
        {
        System.exit(0);
        }
        
        
     
   
    }

    private static void startGame() {
     
    while(!usedWord.equals("###"))
        
    {
     CurrentPlayer();
    System.out.print("\nAlphabet letters left : "+ updateAlphabets());
    System.out.print(CurrentPlayer+" \nEnter your word:");
    usedWord= new Scanner(System.in).next();
    
    validatingusedWord();
    
    }
    PlayerScore();
    }

    private static String updateAlphabets() {
     if(updateAlphabets==true){
     for(int i = 0; i<alphabetList.toCharArray().length;i++)
     {
     if (usedWord.contains( (alphabetList.toCharArray()[i]+ "")))
     {
     usedLetters +=(alphabetList.toCharArray()[i]+ "");
     alphabetList=alphabetList.replace((alphabetList.toCharArray()[i]+ ""),"_");
     }
     }
     }
     else
     {
     System.out.print("\nYOU ENTERED A WORD THAT IS USED OR IS NOT VALID. PLEASE ENTER ANOTHER WORD");
     }
    return alphabetList;
    }

    private static void CurrentPlayer()
    {
    if(PlayerNumber==1)
    {
    CurrentPlayer=PlayerOne;
    PlayerNumber+=1;
    }
    else
    {
    CurrentPlayer=PlayerTwo;
    PlayerNumber-=1;
    }
    }

    private static void trimVowels() {
        
   String Vowels= "aeiou";
   
   for(int i=0;i<usedWord.toCharArray().length;i++)
   {
   if(Vowels.contains( (usedWord.toCharArray()[i]+"")))
   {
   usedWord=usedWord.replace((usedWord.toCharArray()[i]+""), "");
   }
   }
    }

    private static void validatingusedWord() {
        
        System.out.print("\nEnter (y) yes if both players agree on the word or Enter any key to Disagree:");
         if(new Scanner(System.in).next().equalsIgnoreCase("y"))
         {
         trimVowels();
         usedletterCheck();
         gettingScores();
         }
         else
         {
         usedWord="";
         }
    
    }

    private static void usedletterCheck() {
        for(int i= 0; i <usedLetters.toCharArray().length;i++)
        {
        if(usedWord.contains( (usedLetters.toCharArray()[i]+ "")))
                
                { updateAlphabets=false;}
        }
    }

    private static void PlayerScore() {
         System.out.print(PlayerOne + "Score :"+ Player1_Score+
                      "\n"+PlayerTwo + "Score :"+ Player2_Score);
    }

    private static void gettingScores() {
       if(CurrentPlayer.equals(PlayerOne) && !usedWord.equals("###"))
       {
       Player1_Score+=1;
       }
      if(CurrentPlayer.equals(PlayerTwo) && !usedWord.equals("###"))
       {
       Player2_Score+=1;
       System.out.print("THE GAME IS OVER NOW.THANK YOU FOR PALYING WORD WARS!!!");
       }
    }
    
}
