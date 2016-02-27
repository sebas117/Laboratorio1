/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

import java.util.Scanner;

/**
 *  <h1>Simulador Parqueadero<h/1>
 *  Clase que simula el funcionamiento de un parqueadero con ciertas condiciones
 * 
 * 
 * @author Sebastian Gil y Sergio Betancur
 * @version 1.0
 * @since 23/02/16
 */
public class Parqueadero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        
        String[] Par = new String[100]; //PLACA
        int[] horas = new int[100]; // Horas de entrada
       
        int []plantilla = new int[100];
        //se inicializa el parqueadero (vacio)
        
        
        
        int opcion;
        int acumulado = 0;
        int posicion_par; 
        boolean estado = true;
        String Exit = "y";
        
        
        Imprimir(plantilla);
        
        do
        {
            
            
            System.out.println();
            System.out.println();
            Instrucciones();
            
            System.out.println();
            System.out.print("Digite su opción: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                
                case 1: 
                  
                boolean valor = false;   
                
                        for(int i = 1; i<= 87; i++)
                        {
                            if(plantilla[i] == 0)
                            {
                            valor = true;
                            break;
                            }
                            
                            
                           
                           
                        }
                        
                        if (valor == false){
                            System.out.println("El parqueadero está lleno lo sentimos");
                        
                            break;
                        }
                
                        
                        do{
                        posicion_par =(int) Math.floor((Math.random()*87)+1);
                        
                        
                        
                        
                        for(int i = 1; i<= 87; i++)
                        {
                            if(posicion_par == plantilla[i])
                            {
                            valor = false;
                            break;
                            }
                            else
                            valor = true;
                           
                           
                        }
                        
                        
                        
                        }while(valor == false);
                
                
                
                
                System.out.println("Dirijase por favor a la posición asignada: "+posicion_par);
                pintar(plantilla, posicion_par);
                System.out.println();
                System.out.println();
                
                Imprimir(plantilla);
                
                System.out.println();
                System.out.println();
                System.out.println();
                
                
                System.out.print("Digite la placa del carro: ");
                
                Par[posicion_par] = entrada.next();
                
                do{
                System.out.print("Digite la hora de llegada (6-20): ");
                horas[posicion_par]= entrada.nextInt();
                
                }while(horas[posicion_par]<6 || horas[posicion_par]>20);
                
                break;
                
                case 2:
                 
                int posicion, total_pagar, h_salida;
                 
                do{
                    
                System.out.println();
                System.out.print("Digite la posicion del carro que desea salir: ");
                posicion = entrada.nextInt();
                
                    if(plantilla[posicion]==0)
                    System.out.println("AQUÍ NO HAY NINGÚN AUTO, LO SENTIMOS...");
                    
                    break;
                    
                }while(plantilla[posicion]==0);    
                
                if(plantilla[posicion]==0)
                    break;
                
                System.out.println();
                System.out.print("Digite la hora de salida: ");
                h_salida= entrada.nextInt();
                
                total_pagar = pagar(horas, h_salida, posicion);
                
                
                
                System.out.print("El costo es de: "+ total_pagar);
                acumulado = acumulado + total_pagar;
                
                
                System.out.println();
                System.out.println();
                System.out.println();
                
                borrar(plantilla, posicion);
                Imprimir(plantilla);
                
                System.out.println();
                System.out.println();
                System.out.println();
                
                break;
                
                case 3:
                    
                System.out.println("El acumulado es de: "+acumulado);
                
                
                break;
                
                
                case 4:
                    
                int cupos_libres;
                
                
                cupos_libres = libres(plantilla);
                
                
                 System.out.println("El numero de cupos libres es de:"+cupos_libres);
                    
                
            
                break; 
            
            
            }
          
            
        }while(estado == true);
        
    }
    
    
    public static void Instrucciones(){
        
        System.out.println("Menú Parqueadero: \n");
        
        System.out.println("1- Ingresar un carro");
        System.out.println("2- Retirar un carro");
        System.out.println("3- Dinero acumulado del parqueadero");
        System.out.println("4- Numero de cupos libres del parqueadero");
        
        System.out.println();
        System.out.println("Nota: El 0 significa que lugar de estacionamiento está disponible");
        System.out.println("Nota: Fracción de hora: 3000");
       
    }
    
    public static void Imprimir(int [] A)
    {
        
        System.out.println("PARQUEADERO");
        System.out.println();
        //se imprime el parqueadero
        
        for(int i = 1; i<= 87 ;i++)
        {
            
                
          System.out.print(A[i]+ "    ");
          if(i==22 || i== 44 || i== 66)
          {
              
              System.out.println();
          }
            
        }
    
    }
    
    public static void borrar(int [] A, int pos)
    {
        
       A[pos]= 0;
       
    }
    
    public static void pintar(int [] A, int pos)
    {
        
       A[pos]= pos; 
       
    
    }
    
    
    public static int libres(int [] A)
    {
        
        int ocupados = 0;
        int totales = 87;
        
        
        for(int i=0; i<=87;i++)
        {
            
            if (A[i]!=0)
            {
               ocupados++;
            
            }
        }
        
       return totales-ocupados; 
      
    }
    
    public static int pagar(int []A, int h_salida, int pos)
    {
        
        int precio_total;
        int fracc_hora = 3000;
        
        precio_total = fracc_hora *( h_salida - A[pos]);
        
        return precio_total;
    }

}


    
    
    
    
    
    


