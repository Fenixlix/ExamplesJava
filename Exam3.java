// usar un mapa para realizar un contador de palabras para un determinado texto
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class Exam3{
 private Scanner teclado;
 private Map<String,Integer> palabras; 

 // Constructor: crea los objetos de teclado y palabras
 // luego solicita un texto y lo clasifica y muestra
 public Exam3(){
  teclado = new Scanner(System.in);
  palabras = new HashMap<String,Integer>();
  String bloqueDeTexto = introduccion();
  clasificar(bloqueDeTexto);
  mostrarPalabras(); 
 }

 // Da una introduccion 
 // y obtiene el bloque de texto a procesar
 private String introduccion(){
  System.out.println("\nEl siguiente programa realiza una clasificacion por palabras.\n"+
  "Favor introducir un parrafo a clasificar:\n");
  String texto = "";
  do{
   texto = teclado.nextLine();
   if(texto.length()==0)
    System.out.println("Debe introducir almenos un caracter");
  }while(texto.length() == 0);
  return texto;
 }

 // Separa en palabras el texto y lo normaliza para
 // añadirlo al mapa (palabras)
 private void clasificar(String texto){
  // separa en tokens el texto dado por el usuario
  StringTokenizer tokens = new StringTokenizer(texto);
  
  // registra palabra a palabra haciendo uso de la separacion por tokens
  // adicional a eso evalua minusculas mayusculas y signos de puntuacion
  String palabra;
  char ultimoChar;
  while(tokens.hasMoreTokens()){
   palabra = tokens.nextToken().toLowerCase(); // convierte todo a minusculas
   // se evalua el criterio de adicion al mapa
   ultimoChar = palabra.charAt(palabra.length()-1); 
   switch (ultimoChar){
    case '.':
     upToMapa(".");
     if (palabra.length()>1)
      upToMapa(palabra.substring(0,palabra.length()-1));
     break;
    
    case ',':
     upToMapa(",");
     if (palabra.length()>1)
      upToMapa(palabra.substring(0,palabra.length()-1));    
     break;
    
    case ':':
     upToMapa(":");
     if (palabra.length()>1)
      upToMapa(palabra.substring(0,palabra.length()-1));    
     break;

    case ';':
     upToMapa(";");
     if (palabra.length()>1)
      upToMapa(palabra.substring(0,palabra.length()-1));    
     break;

    case '!':
     upToMapa("!");
     if (palabra.length()>1)
      upToMapa(palabra.substring(0,palabra.length()-1));    
     break;

    case '?':
     upToMapa("?");
     if (palabra.length()>1)
      upToMapa(palabra.substring(0,palabra.length()-1));    
     break;
    
    default:
     upToMapa(palabra);
     break;
   }
  }
 }

 // Resumen del proceso de añadir palabra nueva a mapa
 private void upToMapa(String item){
  if(palabras.containsKey(item)){
   int conteo = palabras.get(item);
   palabras.put(item,conteo+1);
  } else
     palabras.put(item,1);  
 }

 // Muestra las palabras unicas encontradas en el texto
 private void mostrarPalabras(){
  Set<String> claves = palabras.keySet();
  TreeSet<String> clavesO = new TreeSet<String>(claves);

  for(String clave: clavesO)
   System.out.printf("[%s]:%d\n",clave,palabras.get(clave));
 }

 public static void main(String args[]){
  new Exam3();
 }
}