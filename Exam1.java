// La idea es Determinar cuantas veces esta contenido el StringA en el StringB
/* TODO: 
-hacer que los strings ingresen por teclado [LISTO]
-validar para evitar que se pueda realizar divicion por 0 [LISTO]
-mejorar logica de funcionamiento [LISTO]
-hacer interfaz grafica para que se vea todo bonito
-hacer vercion de solucion usando mapas [LISTO] (Es la V2)
*/
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Scanner;

public class Exam1{
 // variables de clase
 private int conteo;
 private Character aC[],bC[];
 private int aI[],bI[];
 private Scanner teclado; 

 public Exam1(){
  teclado = new Scanner(System.in); 
  String cadenas[] = introduccion();
  separar(cadenas[0],cadenas[1]);
  
  System.out.printf("\nEl numero de veces que se puede escribir a con b es: %d\n"
   ,comparadorF(cadenas[1]));
 }

 private String[] introduccion(){
  String a = " ";
  String b = "";
  // Introduccion y obtencion de valores correctos
  System.out.println("El siguiente programa determina cuantas veces "
   +"se puede escribir el conjunto A\n"
   +"en el conjunto de letras B...\n");
  do{
   System.out.print("\nIngrese el conjunto de letras A: ");
   a = teclado.nextLine();
   System.out.print("\nIngrese el conjunto de letras B: ");
   b = teclado.nextLine();
   if(a.length()>b.length())
    System.out.println("\nPara que el programa funcione bien, a debe tener menos letras que b");
  }while(a.length()>b.length());

  // Normalizacion de los caracteres para llevar de mayusculas a minusculas
  a = a.toLowerCase();
  b = b.toLowerCase();

  String cadenas[] = {a,b};

  return cadenas;
 }
 
 private void separar(String a, String b){
  // Se separa en caracteres unicos el String a y se muestra el numero de repeticiones  
  aC = sepEnCaracteres(a);
  aI = new int[aC.length];

  for(int i=0; i<aC.length;i++)
   aI[i] = numDeRep(a,aC[i],0);
 
  imprimirCaracteresDe(aC,aI,"A",a);  

  // Se separa en caracteres unicos el String b y se muestra el numero de repeticiones
  bC = sepEnCaracteres(b);
  bI = new int[bC.length];

  for(int i=0; i<bC.length;i++)
   bI[i] = numDeRep(b,bC[i],0);
  
  imprimirCaracteresDe(bC,bI,"B",b);    
 }

 // metodo recursivo de clasificacion que obtiene el numero 
  // de repeticiones de un caracter en una cadena dada
 private int numDeRep(String palabra, char letra, int indice){
  if (indice == 0) // condicion de incio para el proceso de conteo
   conteo = 0;
  if (!(indice > palabra.length())){ 
   if(palabra.indexOf(letra,indice)>=0){
    indice = palabra.indexOf(letra,indice);
    numDeRep(palabra,letra,indice+1);
   }
  } 
  return conteo++;
 }

 // metodo para imprimir arreglo de caracteres y su repeticion
 private void imprimirCaracteresDe(Character cC[], int cI[], String nombre, String palabra){
  System.out.printf("\nConjunto de palabra %s: %s\n",nombre,palabra);
  int x = 0;
  for(Character letra: cC)
   System.out.printf("[%s:%d]",letra,cI[x++]);
  System.out.println();
 }

 // metodo para la obtencion de caracteres de un string 
 private Character[] sepEnCaracteres(String palabra){
 
  // convierte palabra en una cade de caracteres
  Character pLetra[] = new Character[palabra.length()];
  for(int i=0;i<palabra.length();i++)
   pLetra[i] = palabra.charAt(i);

  // Genera un set de caracteres sin repeticion
  Set<Character> palabraEnCaracteres = 
   new HashSet<Character>(Arrays.asList(pLetra));

  // crea y llena una cadena de caracteres sin repeticion  
  pLetra = new Character[palabraEnCaracteres.size()];
  int i=0;
  for(Character letra:palabraEnCaracteres)
   pLetra[i++] = letra;

  return pLetra;
 }

 // compara dos cadenas de int para determinar el min numero de repeticiones posibles
 private int comparadorF(String b){
  int aEnB[] = new int[aC.length];
  int contadorMin = 0;
  for(int i=0;i<aC.length;i++){
   conteo = 0;
   aEnB[i] = numDeRep(b,aC[i],0);
   if(i==0)
    contadorMin = aEnB[i]/aI[i];
   else if((aEnB[i]/aI[i])<contadorMin)
    contadorMin = aEnB[i]/aI[i];
  }
  return contadorMin;
 }

 public static void main(String args[]){
  new Exam1();
 }
}