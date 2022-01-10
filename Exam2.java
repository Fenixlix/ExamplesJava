// Este codigo tiene por objetivo obtener 
 // todos los numeros primos existentes hasta 
 // el valor dado por el usuario
import java.util.Scanner;

public class Exam2{

 private Scanner teclado;
 private int numPri[];
 
 public Exam2(){
  teclado = new Scanner(System.in);
  //int valor = ;
  imprimirP(calcularNP(introduccion()));
 }

 private int introduccion(){
  System.out.print("Este programa sirve para calular los numeros primos"+
  "\nEscriba el numero de numeros primos que desea calcular: ");
  int numero = 0;
  do{
   numero = teclado.nextInt();
   if(numero<=0)
    System.out.println("\nDebe ingresar un numero positivo mayor a 0");
  }while(numero<=0);
  return numero;
 }  

 private int[] calcularNP(int cantidad){
  numPri = new int[cantidad];
  int numero = 2;
  int contadorP = 0;
  boolean flag;
  while (contadorP < cantidad){
   if (contadorP == 0)
    numPri[contadorP++] = numero++;
   else{
    flag = false;
    for(int n=0; n<contadorP;n++){
     if ((numero%numPri[n])==0){
      flag = true;
      break;
     }      
    }
    if(flag)
     numero++;
    else
     numPri[contadorP++] = numero++;
   }     
  } 
  return numPri;
 }

 private void imprimirP(int[] numerosP){
  for(int numP: numerosP)
   System.out.printf("[%d]",numP);
 }

 public static void main(String args[]){
  new Exam2();
 }

}