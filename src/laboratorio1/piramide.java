/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;


import java.util.Scanner;

/**
 * <h1>Cuenta</1>
 * Clase que imprime una pirámide de asteriscos siguiendo una secuencia 
 * y respetando unos espacios
 * 
 * @author Sebastian Gil y Sergio Betancur
 * @version 1.0
 * @since 20/02/16
 */
public class piramide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner lectura = new Scanner(System.in);
        
        int cuenta_as, contador = 1, blan = 1;
        int num = 5;
        String ast = "*";
        String esp = " ";
        
      
        
        System.out.println(" ");
        
        while(contador <= num)
        {
        
            blan = num - contador;
            
            while(blan >0)
                
            {
                System.out.print(esp);
                blan--;
            }
            
            cuenta_as = 1;
            
            while(cuenta_as < 2*contador)
            {
                System.out.print(ast);
                cuenta_as++;
                
            }
            
            contador++;
            System.out.println(" ");
            
             
            
            
        }
        
        
        
        
        
    }
   
}
    

