// La idea es Determinar cuantas veces esta contenido el StringA en el StringB
import java.util.Map; 
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class Exam1V2{

 private Map<Character, Integer> mapaA;
 private Map<Character, Integer> mapaB;
 private Scanner teclado;
 private int conteo;
 
 public Exam1V2(){
  mapaA = new HashMap<Character, Integer>(); 
  mapaB = new HashMap<Character, Integer>();
  teclado = new Scanner(System.in); 

  String cadenas[] = introduccion();
  separar(cadenas[0],cadenas[1]);  

  System.out.printf("\nEl numero de veces que se puede escribir a con b es: %d\n"
   ,comparadorF());
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

 // Se separa en caracteres unicos el String a y b
 private void separar(String A, String B){
  mapaA = sepEnCaracteres(A);  
  imprimirCaracteresDe(mapaA,"A",A);
  mapaB = sepEnCaracteres(B);
  imprimirCaracteresDe(mapaB,"B",B);
 }

 // metodo para la obtencion de caracteres de un string 
  // a su vez obtiene el numero de repeticiones
 private Map<Character,Integer> sepEnCaracteres(String palabra){
 
  // convierte palabra en una cade de caracteres
  Character caracteres[] = new Character[palabra.length()];
  for(int i=0;i<palabra.length();i++)
   caracteres[i] = palabra.charAt(i);

  // Genera un mapa caracteres sin repeticion
  Map<Character, Integer> mapa = new HashMap<Character, Integer>(); 
  for (Character letra:caracteres){
   if(mapa.containsKey(letra)){
    int cuenta = mapa.get(letra); // obtiene el numero actual de repeticiones
    mapa.put(letra,cuenta+1); // aumenta el contador de repeticion
   } else
    mapa.put(letra,1); // añade una nueva letra
  }  

  return mapa;
 }

 public static void main(String args[]){
  new Exam1V2();   
 }

 // metodo para imprimir arreglo de caracteres y su repeticion
 private void imprimirCaracteresDe(Map<Character,Integer> mapa, String nombre, String palabra){
  System.out.printf("\nConjunto de palabra %s: %s\n",nombre,palabra);
  // obtiene un set de las claves del mapa
  Set<Character> claves = mapa.keySet(); 
  // ordena las llaves
  TreeSet<Character> clavesOrdenadas = new TreeSet<Character>(claves);

  for(Character clave: clavesOrdenadas)
   System.out.printf("[%s:%d]",clave,mapa.get(clave));
  System.out.println();
 }

 // compara dos cadenas de int para determinar el min numero de repeticiones posibles
 public int comparadorF(){
  
  // obtiene un set de las claves del mapa
  Set<Character> clavesA = mapaA.keySet(); 
  // ordena las llaves
  TreeSet<Character> clavesOrdenadasA = new TreeSet<Character>(clavesA);

  int contadorMin = 0;
  int valorB;
  for(Character clave: clavesOrdenadasA){
   if (mapaB.get(clave)==null)
    valorB = 0;
   else
    valorB = mapaB.get(clave);
   if(contadorMin == 0)
    contadorMin = valorB/mapaA.get(clave);
   else if((valorB/mapaA.get(clave))<contadorMin)
    contadorMin = valorB/mapaA.get(clave);
  }
  return contadorMin;
 }
}