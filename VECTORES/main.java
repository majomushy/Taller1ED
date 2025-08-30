
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
      
         Scanner sc = new Scanner(System.in); 
       //--- menu de opciones ------//


        boolean salida = false;
        int t,opcion; //Guardaremos la opcion del usuario
        while (!salida) // Mientras no sea falso se repite el menu
        {
 
        System.out.println("Bienvenido al sistema de gestion de personas");
        System.out.println("1. Agregar persona");
        System.out.println("2. Mostrar personas");
        System.out.println("3. Eliminar persona");
        System.out.println("4. Buscar persona");
        System.out.println("5. Salir");
            // try catch para manejar excepciones y controlar los errores en tiempo de ejecución
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();
 
                switch (opcion) {
                    case 1:
                               System.out.println("Solo números entre 1 y 4");
                            
                        break;
                    case 2:
                          R.ConsultarHora();
                    break;
                    case 3:
                    
                    break;
                    case 4:
                        salida = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();z


    }
    
}
