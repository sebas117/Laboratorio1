/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

import java.util.Scanner;

/**
 *
 * @author Sebastian Gil y Sergio Betancur
 * @version 1.0
 * @since 26/02/16
 */
public class Ventas_local {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        
        int a;
        
        System.out.println("SEGUIMIENTO DE VENTAS\n");
        
        System.out.print("Ingrese la cantidad de productos que hay en el inventario: ");
        a = entrada.nextInt();
        
        int [][] producto = new int[a+1][3]; // Código y precio de cada producto
        
        
        String[] descripcion = new String[a+1];
        
        for (int i=1; i<=a; i++){
            
            System.out.println("PRODUCTO ["+i+"]");
            System.out.println();
            
            for(int j=1; j<3;){                                      //Se repite no mas una vez
                
                
                System.out.print("Ingrese el código del producto ["+i+"]: ");  
                producto[i][j] = entrada.nextInt();
                
                System.out.print("Ingrese la descripcion del producto ["+i+"]: ");  
                entrada.nextLine();
                
                descripcion[i] = entrada.nextLine();
                
                
                j++;
                
                System.out.print("Ingrese el precio del producto ["+i+"]: ");  
                producto[i][j] = entrada.nextInt();
                        
                j++;       
            
            }
            
            System.out.println();
            System.out.println();
            
       
        }
        
        imprimir_inventario(producto, descripcion, a);
        
        System.out.println();
        System.out.println();
        
        int b;
        
        
        System.out.print("Ingrese la cantidad de ventas hechas: ");
        b = entrada.nextInt();
        
        
        
        String [] Fechas = new String[b+1]; //FECHAS
        String [][][] modo_pago = new String [b+1][2][1000];
        
        String [] vendedor  = new String[b+1]; //Nombre y apellido
        String [] id_vendedor = new String[b+1]; //Id vendendor
        
        int [][][] datos_producto = new int[b+1][3][1000]; // DATOS PRODUCTO   b+1 -> Ventas // 3 -> ( codigo y cantidad vendida) // Productos vendidos  (diferentes
                                                                                                                                  //por vendedor
        
        
        for (int i=1; i<=b; i++){
            
            
            System.out.println("Venta ["+i+"]");
            System.out.println();
            
                                                  //Se repite no mas una vez
                        
            System.out.print("Ingrese la fecha de venta (DD/MM/AA) ["+i+"]: ");  
            entrada.nextLine();
            
            Fechas [i] = entrada.nextLine();
                
                
                
            System.out.println("Datos vendedor ["+i+"]");
            System.out.println();
                
            System.out.print("Ingrese la ID del vendedor ["+i+"]: ");  
            id_vendedor[i] = entrada.next();
                
                
                
            System.out.print("Ingrese el Nombre y apellido del vendedor ["+i+"]: ");  
            entrada.nextLine();
                        
            vendedor[i] = entrada.nextLine();   
                
               
               
            
                System.out.println();
                
                int z;
                System.out.print("Ingrese la cantidad de productos  que vendió: ");
                
                z = entrada.nextInt();
                
               
                    
                    
                
                    for(int y = 1; y<=z; y++){
                        
                    System.out.println("Datos del producto ["+y+"]");
                    System.out.println();    
                        
                    System.out.print("Ingrese el código del producto: ");
                    datos_producto[i][1][y] = entrada.nextInt();
                    
                    
                    
                    System.out.print("Ingrese la cantidad vendida: ");
                    datos_producto[i][2][y] = entrada.nextInt();
                    
                    
                    
                   
                    
                    System.out.print("Ingrese la forma de pago (efectivo-debito-tarjeta): ");
                    entrada.nextLine();
                    
                    modo_pago[i][1][y] = entrada.nextLine();
                    }
            
            
            
            System.out.println();
            System.out.println();
            
       
        }
        
        //System.out.println("El vendedor que más ventas de productos hizo fue: "+ 
        
        acumulador_ventas(vendedor, datos_producto, b);
        
        imprimir_ventas_debito(vendedor, datos_producto, b, modo_pago, producto, a);
        
        
        
        
        
        
        
        
    }
    
    public static void acumulador_ventas(String []vendedor, int [][][]num_ventas, int i_1)
    {
        
        int acum_ventas =0;
        int aux_i =0;
        int mayor_ventas = 0;
        
        for (int i = 1; i<= i_1; i++)
        {
            for(int k= 1; k<= 100; k++){
                
            acum_ventas= acum_ventas + num_ventas[i][2][k] ;
            
                System.out.println(acum_ventas);
            }
        }
            /*
            if(acum_ventas > mayor_ventas){
            mayor_ventas = acum_ventas;
            aux_i = i;
            
            }
                
            
        }
        
        return mayor_ventas;
        */
        
        
    }
    
    public static void imprimir_ventas_debito(String []vendedor, int [][][] datos_producto, int b, String [][][] modo_pago, int [][] producto,int d)
    {
        
        
        String ventas = "Ventas(Codigo)";
        String precio_final = "Precio_final";
        int precio_finalx;
        
        
        
        
        
        for(int i=1 ; i<= b; i++)
        {
            
            System.out.println("Vendedor ["+i+"]");  
            
            
            System.out.print(ventas + "            ");  System.out.print(precio_final);
            
            for(int k = 1; k<= 100; k++){
                
            if("efectivo".equals(modo_pago[i][1][k]))    
            {
                
            
            System.out.print(datos_producto[i][1][k]);
            
                 String num = Integer.toString(datos_producto[i][1][k]);
                for(int aux = num.length(); aux <ventas.length() + 8 ; aux++)
                {
                    
                    System.out.print(" ");
                    
                    
                    
                }
                
                
            
            
             
                 for(int x= 1; x<= d; x++){
                     
                 if (datos_producto[i][1][k] == producto[x][1]){
                 
                 precio_finalx = producto[x][2] * datos_producto[i][2][k]; 
                 
                 System.out.print(precio_finalx);
                 
                 String num1 = Integer.toString(precio_finalx);
                for(int aux = num1.length(); aux <precio_final.length() + 8 ; aux++)
                {
                    
                    System.out.print(" ");
                    
                    
                    
                }
                 
                 }
                 
                 }
            
            
            
            
            
            
            }
            
            
            
        }
        
        
            System.out.println();
            System.out.println();
        
        
        
        
    }
    
    }
    
    public static void imprimir_inventario(int [][]A , String []B, int x)
    {
        String codigo = "Código";
        String descripcion = "Descripcion";
        
        
        System.out.print(codigo +"        "); System.out.print(descripcion + "            "); System.out.print("Valor");
        
        System.out.println();
        System.out.println();
        for (int i=1; i<=x; i++){
            
            
            
            for(int j=1; j<3;){                                      //Se repite no mas una vez
                        
                System.out.print(A[i][j]);  
                String num = Integer.toString(A[i][j]);
                
                for(int aux = num.length(); aux <codigo.length() + 8 ; aux++)
                {
                    
                    System.out.print(" ");
                    
                    
                    
                }
                
                
                System.out.print(B[i]); 
                
                for(int aux = B[i].length(); aux <descripcion.length() + 12; aux++)
                {
                    
                    System.out.print(" ");
                    
                    
                    
                }
                
                
                j++;
                
                System.out.print(A[i][j]+ "        ");  
                
                        
                j++;       
            
            }
            
            System.out.println();
            
            
       
        }
        
        
        
        
        
    }
    
}
