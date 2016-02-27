/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

import java.util.Scanner;

/**
 * <h1>Adivinar el número<h/1>
 * Clase que genera un número al azar, y el usuario debe adivinarlo
 * 
 * @author Sebastian Gil y Sergio Betancur
 * @version 1.0
 * @since 20/02/16
 */
public class AdivinarNum {

    /**
     * @param args the command l ine arguments
     */
    
    
    
    public static void main(String[] args) {
        
        Scanner lectura = new Scanner(System.in);
        String playAgain= "y";
        
        while("y".equals(playAgain))
        {
            GuessingNum();
            
            System.out.println("Would you like to play another game(y/n)");
            playAgain = lectura.nextLine();
            
            System.out.println("");
            System.out.println(""); 
            System.out.println("");
        }
        
    
    }
    
    
    public static void GuessingNum()
    {
        Scanner lectura = new Scanner(System.in);
        
        int answer =(int) Math.floor((Math.random()*100)+1);
        int guess=0;
        int NumGuesses=0;
        
        while(NumGuesses<7 && guess != answer)
        {
            
           System.out.print("Guess a number: ");
           guess = lectura.nextInt();
           
           if(guess< answer)
           {
               System.out.println("Higher...");
               NumGuesses++;
               
           }
           
           else
           {
               
               if(guess> answer)
               {
                  System.out.println("Lower...");
                  NumGuesses++;
               }    
                   
               else
               {
                  System.out.println("You WIN!!!");
               }
                   
                   
           }
           
          
           
        }
        
        if(NumGuesses>=7)
         System.out.println("You LOSE!!!"); 
        
        
         
   
        
     }
        
        
        
    }
    



