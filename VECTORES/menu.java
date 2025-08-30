public class menu {
    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestion de personas");
        System.out.println("1. Agregar persona");
        System.out.println("2. Mostrar personas");
        System.out.println("3. Eliminar persona");
        System.out.println("4. Buscar persona");
        System.out.println("5. Salir");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        

        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    if (!vector.vectorLleno()) {
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese el apellido: ");
                        String apellido = scanner.next();
                        System.out.print("Ingrese el peso: ");
                        float peso = scanner.nextFloat();
                        System.out.print("Ingrese la altura: ");
                        float altura = scanner.nextFloat();

                        persona p = new persona(nombre, apellido, peso, altura);
                        vector.agregarPersona(p);
                    } else {
                        System.out.println("El vector esta lleno");
                    }
                    break;
                case 2:
                    vector.mostrarVector();
                    break;
                case 3:
                    if (!vector.vectorVacio()) {
                        System.out.print("Ingrese la posicion a eliminar (0 a " + vector.getIndice() + "): ");
                        int posicion = scanner.nextInt();
                        vector.eliminarPersona(posicion);
                    } else {
                        System.out.println("El vector esta vacio");
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
        }

        System.out.println("Saliendo del sistema...");
        scanner.close();
    }
}
