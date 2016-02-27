/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laboratorio1;
import java.util.Scanner;

/**
 *  <h1>Sistema informatico : Elecciones a alcalde<h/1>
 *  Sistema informático que permita administrar las elecciones  a alcalde de los diferentes municipios del departamento de Topaiti.
 * 
 * 
 * @author Sebastian Gil y Sergio Betancur
 * @version 1.0
 * @since 23/02/16
 */

public class problema1 {
public static int porcentaje(int a, int b){
    int c;
    c=(a*100)/b;
    return c;
};
    public static void main(String[] args) {
        int m, c, votos;
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("Introdusca el numero de municipios: ");
        m=input.nextInt();
        System.out.print("introdusca el numero de candidatos: ");
        c=input.nextInt();
        String [] cand = new String[c+1];
        int [][] tabla= new int[c+1][m];
        cand[0]=" ";
        System.out.println("Ingrese los candidatos (una sola cifra)");
        for(int i=1; i<=c; i++){
            cand[i]=input.next();
        }
        System.out.print("Introdusca los municipios (solo numeros): ");
        for(int i=0; i<m; i++){
            tabla[0][i]=input.nextInt();
        }
        for(int i=0;i<m;i++){
            for(int j=1;j<=c;j++){
                tabla[j][i]=0;
            }
        }
        System.out.print("Ingrese el candidato seguido del municipio para asiganer los votos"
                + " en caso de no ingresar un valor, este sera 0. (ingrese 21 en\ncualquier opcion para terminar de asignar votos)");
        System.out.print("\n");
        String k;
        for(int fil=0, col=0; fil<m || col<=c;){
            System.out.print("Candidato: ");
            k=input.next();
            for(int i=1;i<=c;i++){
                if(k.equals(cand[i])){
                    col=i;
                }
            }
            System.out.print("Municipio: ");
            fil=input.nextInt();
            if(fil==21){
                break;
            }
            System.out.print("Numero de votos: ");
            votos=input.nextInt();
            tabla[col][fil-1]=votos;
        }
        System.out.print("             ");
        for(int i=0; i<=c;i++){
            if(i>0){
               System.out.print("Candidato "+cand[i]+"  ");
            }
        }
        System.out.print("\n");
        for(int i=0;i<m;i++){
            System.out.print("Municipio ");
            for(int j=0;j<=c;j++){
                System.out.print(tabla[j][i]+"     ");
                if(j>=1){
                    System.out.print("       ");
                }
            }
            System.out.print("\n");
        }
        int [] total=new int[c];
        for(int i=0;i<c;i++){
            total[i]=0;
        }
        for(int i=1, n=0;i<=c;i++,n++){
            for(int j=0;j<m;j++){
                total[n]+=tabla[i][j];
            }
        }
        int suma=0;
        for(int i=0; i<c;i++){
            suma+=total[i];
        }
        int mayor;
        String z;
        for(int i=0; i<=c-1;i++){
            for(int j=0;j<c-1;j++){
                if(total[j]<total[j+1]){
                    int l=j+1;
                    mayor=total[j];
                    total[j]=total[j+1];
                    total[j+1]=mayor;
                    z=cand[l];
                    cand[l]=cand[l+1];
                    cand[l+1]=z;
                }
            }
        }
        System.out.println("El total de votos de cada candidato fue: ");
        for(int i=0,s=1;i<c;i++,s++){
            System.out.println("candidato "+cand[s]+": "+total[i]+" Porcentaje: "+porcentaje(total[i],suma)+"%");
        }
        String ganador="ninguno";
        boolean existeGanador=false;
        for(int i=0;i<c;i++){
            if(porcentaje(total[i],suma)>50){
                ganador=cand[i+1];
                existeGanador=true;
                break;
            }
        }
        if(existeGanador=true){
            System.out.println("El ganador es: "+ganador);
        }
        else{
            int a, b;
            System.out.print("Introdusca el total de votos del candidato "+cand[1]);
            a=input.nextInt();
            System.out.print("Introdusca el total de votos del candidato "+cand[2]);
            b=input.nextInt();
            if(a>b){
                System.out.println("El ganador es: "+cand[1]);
            }
            else{
                System.out.println("El ganador es: "+cand[2]);
            }
        }
    }
    
}