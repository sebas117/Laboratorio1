/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

import java.util.Scanner;

/**
 * <h1>Adivinar el número</1>
 * Clase que genera un número al azar, y el usuario debe adivinarlo
 * 
 * @author Sebastian Gil y Sergio Betancir
 * @version 1.0
 * @since 20/02/16
 */
public class NumMayor {
    
    /**
     * @param args the command l ine arguments
     */
    public static void main(String[] args) {
        
        Scanner lectura = new Scanner(System.in);
        
        int mayor = 0;
        int a, b, c;
        
        System.out.print("Digite A: ");
        a = lectura.nextInt();
    
        System.out.print("Digite B: ");
        b = lectura.nextInt();

    
        System.out.print("Digite C: ");
        c = lectura.nextInt();
    
    
        if(a>b)
        {
            if(a>c)
            mayor = a;
            
            else
            mayor = c;
       
    
        }
        
        else{
            
            if(b>c)
            mayor = b;
            
            else
            mayor = c;
            
            
        }
        
        System.out.println("El mayor es: "+ mayor);
    
    
    }
        

}