// El programa debe verificar que el string dado tenga un conjunto valido de {}[]()
import java.util.Scanner;

public class Exam4{
 
 private Scanner teclado;
 private int contador;
 private char conjunto[];

 public Exam4(){
  teclado = new Scanner(System.in);
  contador = 0;
  conjunto = introduccion(); 
  verificacion();
 }

 private char[] introduccion(){
  System.out.println("Este programa verifica que el conjunto de []{}() sea correcto\n"+
   "A continuacion ingrese el conjunto a evaluar:");
  String textoS = teclado.nextLine();
  char texto[] = textoS.toCharArray();
  return texto;
 }

 private void verificacion(){
  if (conjunto.length%2!=0)
   System.out.println("El conjunto no es valido porque es tienen un numero impar de llaves");
  else 
   analisisSusesivo();
 }

 private void analisisSusesivo(){
  boolean flag = true;
  while(flag){
   int ini = conjunto.length; // especifico valor de inicio de la longitud del arreglo
   System.out.println("Inicio de for");
   for(int i=0;i<conjunto.length;i++){
    switch(conjunto[i]){ 
     case '(' :
      if( (i+1)<conjunto.length ){
       if( conjunto[i+1] == ')' ){
        pasoMedio(i);
        System.out.println("-{} en:"+i+".."+(i+1));
        i--;
        System.out.println("paso:"+contador);
       }
      }
      break;
     case '[' :
      if( (i+1)<conjunto.length ){
       if( conjunto[i+1] == ']' ){
        pasoMedio(i);
        System.out.println("-{} en:"+i+".."+(i+1));
        i--;
        System.out.println("paso:"+contador);
       }
      }
      break;
     case '{' :
      if( (i+1)<conjunto.length ){
       if( conjunto[i+1] == '}' ){
        pasoMedio(i);
        System.out.println("-{} en:"+i+".."+(i+1));
        i--;
        System.out.println("paso:"+contador);
       }
      }
      break; 
    } // fin del switch
   } // fin del for
   int fin = conjunto.length; // espesifico el valor de la longitud del arreglo luego de evaluacion
   if (ini == fin){
    flag = false;
    if(conjunto.length>0){
     System.out.printf("\nNo es un conjunto valido %s; numero de evaluaciones: %d",
      conjuntoToString(conjunto),contador);
    }else{
     System.out.printf("\nSi es un conjunto valido\nvalor de repeticiones es: %d",contador);  
    }
   } // fin if
  } // fin del while
 } // fin del metodo

 private void pasoMedio(int i){
  if((conjunto.length-2)>=0){
   char nuevoConjunto[] = new char[conjunto.length-2];
   int x = 0;
   int y = 0;
   for(char llaves : conjunto){
    if( x<i || x>(i+1) ){
     nuevoConjunto[y++] = llaves;
    }
    x++;
   }
   System.out.println("\n Antes: "+conjuntoToString(conjunto));
   System.out.println("Despues: "+conjuntoToString(nuevoConjunto));
   conjunto = nuevoConjunto;
   contador++;
  }
 }

 private String conjuntoToString(char arreglo[]){
  String residuo = "";
   for(char letra: arreglo)
    residuo += letra;

  return residuo;
 }
 
 public static void main(String args[]){
  new Exam4();
 }
}