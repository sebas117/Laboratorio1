/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package laboratorio1;
import java.util.Scanner;

/**
 *  <h1>Simulador puesto avion<h/1>
 *  Clase que simula las posiciones de un avion en clase ejecutiva y economica
 * 
 * 
 * @author Sebastian Gil y Sergio Betancur
 * @version 1.0
 * @since 23/02/16
 */

public class Problema2 {
    public static void main(String[] args){
        System.out.println("Bienvenido al asignador de puestos de la aerolinea:\n"
                + "1. Asignar puesto.\n"
                + "2. Sillas ejecutivas desocupadas.\n"
                + "3. Buscar posicion por documento.\n"
                + "4. Buscar silla economica disponible.\n"
                + "5. Anular una reserva.\n"
                + "6. Contar numero de puestos en ventana disponibles de clase economica.\n"
                + "7. Buscar documentos con mismos nombres.\n");
        Scanner input=new Scanner(System.in);
        int punto;
        String [][][] ejecutivo=new String[5][2][3];
        String [][][] economico=new String[7][7][3];
        ejecutivo[2][0][0]=" ";
        ejecutivo[2][1][0]=" ";
        for(int i=0; i<7; i++){
            economico[3][i][0]=" ";
        }
        for(int i=0;i<2;i++){
            for(int j=0; j<5; j++){
                if(!" ".equals(ejecutivo[j][i][0])){
                    ejecutivo[j][i][0]="D";
                }
            }
        }
        for(int i=0;i<7;i++){
            for(int j=0; j<7; j++){
                if(!" ".equals(economico[j][i][0])){
                    economico[j][i][0]="D";
                }
            }
        }
        do{
        System.out.print("Introdusca la opcion: ");
        punto=input.nextInt();
        switch(punto){
            case 1:
                String nombre,cedula,lugar,clase;
                System.out.print("Introdusca su nombre: ");
                nombre=input.next();
                System.out.print("introdusca su cedula: ");
                cedula=input.next();
                boolean silla=false;
                System.out.print("Introdusca la clase de ubicacion: ");
                clase=input.next();
                if("ejecutivo".equals(clase)){
                    System.out.print("Introdusca su lugar de preferencia: ");
                    lugar=input.next();
                    for(int i=0;i<2;i++){
                        for(int j=0; j<5; j++){
                            if("ventana".equals(lugar)&&"D".equals(ejecutivo[j][i][0])&&(j==0||j==4)){
                                ejecutivo[j][i][0]="O";
                                silla=true;
                            }
                            if("pasillo".equals(lugar)&&"D".equals(ejecutivo[j][i][0])&&j+1==2){
                                ejecutivo[j][i][0]="O";
                                silla=true;
                            }
                            if(silla==true){
                                ejecutivo[j][i][1]=nombre;
                                ejecutivo[j][i][2]=cedula;
                                break;
                            }
                            
                        }
                        if(silla==true){
                            break;
                        }
                    }
                }
                if("economico".equals(clase)){
                    System.out.print("Introdusca su lugar de preferencia: ");
                    lugar=input.next();
                    for(int i=0;i<7;i++){
                        for(int j=0; j<7; j++){
                            if("ventana".equals(lugar)&&"D".equals(ejecutivo[j][i][0])&&(j==0||j==6)){
                                economico[j][i][0]="O";
                                silla=true;
                            }
                            if("pasillo".equals(lugar)&&"D".equals(ejecutivo[j][i][0])&&j+1==3){
                                economico[j][i][0]="O";
                                silla=true;
                            }
                            if("centro".equals(lugar)&&"D".equals(ejecutivo[j][i][0])&&(j==1||j==5)){
                                economico[j][i][0]="O";
                                silla=true;
                            }
                            if(silla==true){                       
                                economico[j][i][1]=nombre;                                
                                economico[j][i][2]=cedula;
                                break;
                            }
                        }
                        if(silla==true){
                            break;
                        }
                    }
                }
                break;
            case 2:
                int contador=0;
                for(int i=0; i<2; i++){
                    for(int j=0;j<5; j++){
                        if(!"D".equals(ejecutivo[j][i][0])||!" ".equals(ejecutivo[j][i][0])){
                            contador++;
                        }
                    }
                }
                System.out.println("Hay "+contador+" ocupadas");
                break;
            case 3:
                int n=0, m=0;
                String numero;
                System.out.print("Introdusca el documento a buscar: ");
                numero=input.next();
                boolean encontrado=false;
                String cambio="0";
                for(n=0;n<2;n++){
                    for(m=0;m<5;m++){
                        if(ejecutivo[m][n][2].equals(numero)){
                            ejecutivo[m][n][0]="*";
                            encontrado=true;
                            cambio="ejecutivo";
                            break;
                        }
                    }
                    if(encontrado==true){
                        break;
                    }
                }
                if (encontrado==false){
                    for(n=0;n<7;n++){
                        for(m=0;m<7;m++){
                            if(economico[m][n][2].equals(numero)){
                               economico[m][n][0]="*";
                               encontrado=true;
                               cambio="economico";
                               break;
                            }
                        }
                        if(encontrado==true){
                           break;
                        }
                    }
                }
                if(encontrado==false){
                    System.out.println("El documento que esta buscando no esta registrado");
                    break;
                }
                if(encontrado==true){
                    System.out.println("El usuario que busca esta(*)...");
                    System.out.println("Parte ejecutiva");
                    for(int i=0;i<2;i++){
                        for(int j=0;j<5;j++){
                            System.out.print(ejecutivo[j][i][0]);
                            System.out.print(" ");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("Parte economica");
                    for(int i=0;i<7;i++){
                        for(int j=0;j<7;j++){
                            System.out.print(economico[j][i][0]);
                            if(j==3){
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }
                }
                if("ejecutivo".equals(cambio)){
                    ejecutivo[m][n][0]="O";
                }
                if("economico".equals(cambio)){
                    economico[m][n][0]="O";
                }
                break;
            case 4:
                int a=0;
                int b=0;
                boolean encontrar=false;
                for(a=0;a<7;a++){
                    for(b=0;b<7;b++){
                        if("D".equals(economico[b][a][0])){
                            economico[b][a][0]="*";
                            encontrar=true;
                            break;
                        }
                    }
                    if(encontrar==true){
                        break;
                    }
                }
                if(encontrar==false){
                    System.out.print("No se a encontrado un puesto libre");
                }
                if(encontrar==true){
                    System.out.print("Puesto disponible (*)");
                    System.out.println("Parte economica");
                    for(int i=0;i<7;i++){
                        for(int j=0;j<7;j++){
                            System.out.print(economico[j][i][0]);
                            if(j==3){
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }
                    economico[b][a][0]="D";
                }
                break;
            case 5:
                String nomb;
                boolean encont=false;
                nomb=input.next();
                for(int i=0;i<2;i++){
                    for(int j=0;j<5;j++){
                        if(ejecutivo[j][i][1].equals(nomb)){
                            ejecutivo[j][i][0]="D";
                            ejecutivo[j][i][1]=" ";
                            ejecutivo[j][i][2]=" ";
                            break;
                        }
                    }
                    if(encont==true){
                        break;
                    }
                }
                if (encont==false){
                    for(int i=0;i<7;i++){
                        for(int j=0;j<7;j++){
                            if(economico[j][i][1].equals(nomb)){
                               economico[j][i][0]="D";
                               economico[j][i][1]=" ";
                               economico[j][i][2]=" ";
                               break;
                            }
                        }
                        if(encont==true){
                           break;
                        }
                    }
                }
                break;
            case 6:
                int contador2=0;
                for(int i=0;i<7;i++){
                    if("D".equals(economico[0][i][0])){
                        contador2++;
                    }
                    if("D".equals(economico[6][i][0])){
                        contador2++;
                    }
                }
                System.out.print(contador2+" puestos economicos en ventana disponibles");
                break;
            case 7:
                int i=0, j=0, c=0, d=0;
                boolean repetido=false;
                String persona1, persona2;
                for(i=0;i<7;i++){
                    for(j=0;j<7;j++){
                        if("O".equals(economico[j][i][0])){
                            for(c=i;c<7;c++){
                                for(d=j+1;d<7;d++){
                                    if(economico[d][c][1].equals(economico[j][i][1])){
                                        repetido=true;
                                        break;
                                    }
                                }
                                if(repetido==true){
                                    break;
                                }
                            }
                        }
                        if(repetido==true){
                            break;
                        }
                    }
                    if(repetido==true){
                        break;
                    }
                }
                if(repetido==true){
                    System.out.println("El documento "+economico[j][i][2]+" tiene el mismo nombre al documento "+economico[d][c][2]);
                }
                if(repetido==false){
                    System.out.println("No hay nombres repetidos");
                }
                break;
            case 8:
                System.out.println("Adios :)");
                break;
            default:
                System.out.println("La opcion no corresponde...");
                break;
        }
        }while(punto!=8);
    }
}