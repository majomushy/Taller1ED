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
        System.out.println("6. Crear matriz");
        System.out.println("7. Agregar persona a la matriz");
        System.out.println("8. Mostrar matriz");
        System.out.println("9. Crear nodo");
        System.out.println("10. Mostrar nodo");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
        return sc.nextInt();
    }

    public int pedirTamano() {
        System.out.print("Ingrese el tamaño máximo del vector: ");
        return sc.nextInt();
    }

    public int pedirFilas() {
        System.out.print("Ingrese el número de filas: ");
        return sc.nextInt();
    }

    public int pedirColumnas() {
        System.out.print("Ingrese el número de columnas: ");
        return sc.nextInt();
    }

    public persona ingresarPersona() {
        sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        System.out.print("Ingrese peso (kg): ");
        float peso = sc.nextFloat();
        System.out.print("Ingrese altura (m): ");
        float altura = sc.nextFloat();
        return new persona(nombre, apellido, edad, peso, altura);
    }

    public int pedirPosicion() {
        System.out.print("Ingrese la posición de la persona (0 = primera): ");
        return sc.nextInt();
    }

    public String pedirNombre(String variable) {
        sc.nextLine();
        System.out.print("Ingrese el nombre a " + variable);
        return sc.nextLine();
    }

    public void mostrarPersona(persona p) {
    if (p != null) {
        System.out.println("Nombre: " + p.getNombre() +
                ", Apellido: " + p.getApellido() +
                ", Edad: " + p.getEdad() + " años" +
                ", Peso: " + p.getPeso() + " kg" +
                ", Altura: " + p.getAltura() + " m");
    } else {
        System.out.println("Persona no asignada.");
    }

    }
}