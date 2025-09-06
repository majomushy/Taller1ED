import java.util.Scanner;

public class menu {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Crear vector");
        System.out.println("2. Ingresar persona");
        System.out.println("3. Mostrar personas");
        System.out.println("4. Eliminar persona");
        System.out.println("5. Buscar persona");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
        return sc.nextInt();
    }

    public int pedirTamano() {
        System.out.print("Ingrese el tamaño máximo del vector: ");
        return sc.nextInt();
    }

    public persona ingresarPersona() {
        sc.nextLine(); 
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese peso (kg): ");
        float peso = sc.nextFloat();
        System.out.print("Ingrese altura (m): ");
        float altura = sc.nextFloat();
        return new persona(nombre, apellido, peso, altura);
    }

    public int pedirPosicion() {
        System.out.print("Ingrese la posición de la persona (0 = primera): ");
        return sc.nextInt();
    }

    public String pedirNombre( String variable) {
        sc.nextLine();
        System.out.print("Ingrese el nombre a " + variable );
        return sc.nextLine();
    }
}